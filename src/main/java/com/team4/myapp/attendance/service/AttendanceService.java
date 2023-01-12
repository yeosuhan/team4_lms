package com.team4.myapp.attendance.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team4.myapp.attendance.dao.IAttendanceRepository;
import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.model.CalendarDto;
import com.team4.myapp.member.dao.IMemberRepository;
import com.team4.myapp.out.dao.IOutRepository;
import com.team4.myapp.out.model.OutListDto;
import com.team4.myapp.out.service.OutService;
import com.team4.myapp.util.date.Today;

import oracle.sql.TIMESTAMP;

@Service
public class AttendanceService implements IAttendanceService {

	@Autowired
	IAttendanceRepository attendanceRepository;

	@Autowired
	IMemberRepository memberRepository;
	
	@Autowired
	IOutRepository outRepository;
	
	@Autowired
	OutService outService;

	// 근무시간 충족 여부 검사 : 조퇴, 퇴근 시 수행 됨// 5 시간 이상 근무 시 true 리턴한다.
	private boolean calWorkingTime(String memberId, String today, OutListDto out) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");	
		Date date = null;   // 출근시간	
		Date date2 = null; // 퇴근 or 조퇴 버튼 누른 현재 시간
		long totalOut = 0;
		
		try {
			// 출근 시간 조회
			String str = null;
			if(today == null && out == null) {
				str = attendanceRepository.selectCheckIn(memberId, Today.getToday());
				date2 = new Date();			
			}
			else {
				str = attendanceRepository.selectCheckIn(memberId,today);
				date2 = format2.parse(today);
				date2.setHours(18);
				date2.setMinutes(0);
				date2.setSeconds(0);
				
				// 총 외출 시간
				Date outs = new Date();
				outs.setYear(date2.getYear());
				outs.setMonth(date2.getMonth());
				outs.setDate(date2.getDate());
				outs.setHours(out.getHours());
				outs.setMinutes(out.getMinutes());
				outs.setSeconds(out.getSeconds());
				totalOut = out.getTotal() * 1000;
			}
			date = format.parse(str);
		} catch (ParseException e) {
			System.out.println("calWorkingTime() 에러 ");
			e.printStackTrace();
		}
		

		// 근무시간 >= 5 이여야 출석 인정
		System.out.println("-----------  AttendanceService  calWorkingTime() ----------");
		System.out.println("퇴근 시간 : " + date2);
		System.out.println("출근 시간 : " + date);
		System.out.println("외출 시간 : " + totalOut);
		System.out.println("출근 시간 - 퇴근시간 : " + (date2.getTime() - date.getTime()));
		System.out.println(" 총 초 : " +( date2.getTime() - date.getTime() - totalOut));
		long total = (date2.getTime() - date.getTime() - totalOut) / 3600000;
		//long total = (date2.getTime() - date.getTime()) / 3600000;
		System.out.println("total hours ~~~  : " + total);
		if (total < 5) {
			return false;
		}
		return true;
	}

	public List<CalendarDto> selectMemberAttendance(String memberId, int month) {
		List<Attendance> alist = attendanceRepository.selectMemberAttendance(memberId, month);

		System.out.println("selectMemberAttendance ~~~~~~~~~~~~~~~~~");
		System.out.println(alist);

		List<CalendarDto> clist = new ArrayList<CalendarDto>();

		for (Attendance a : alist) {
			clist.add(CalendarDto.toCalendarDto(a));
		}
		return clist;
	}

	public void updateChekIn(String memberId) {
		Attendance attendance = new Attendance();
		attendance.setMemberId(memberId);

		String today = Today.getToday();

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		attendance.setCheckIn(ts);

		// 2시 이후 출석 시 결석 처리
		if (ts.getHours() >= 14) {
			attendance.setAttendanceStatus(0);
		}
		// 지각처리
		else if (ts.getHours() >= 9 && ts.getMinutes() > 0) {
			attendance.setAttendanceStatus(2);
		}
		// 정상 출석 처리
		else {
			attendance.setAttendanceStatus(1);
		}

		attendanceRepository.updateCheckIn(attendance, today);
	}

	public void updateCheckOut(String memberId) {
		// memberId, 날짜로 출석 id 찾아서 퇴근 값 넣기
		String today = Today.getToday();
		// 퇴근 버튼 누른 시점에서 퇴근시간 - 출근시간 >= 5 여야 출석 인정 됨
		boolean result = calWorkingTime(memberId, null, null);

		// 근무시간 미달 여부 검사
		if (!result) {
			attendanceRepository.updateCheckOut(memberId, 0, today);
		} else
			attendanceRepository.updateCheckOut(memberId, -1, today);
	}

	public int selectId(String memberId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String today = sdf.format(new Date());

		int attendanceId = attendanceRepository.selectId(memberId, today);
		return attendanceId;
	}

	public String selectCheckIn(String memberId) {
		String today = Today.getToday();

		String checkin = attendanceRepository.selectCheckIn(memberId, today);
		return checkin;
	}

	public String selectCheckOut(String memberId) {
		String today = Today.getToday();
		String checkout = attendanceRepository.selectCheckOut(memberId, today);
		return checkout;
	}

	// 출석ID 가져오기
	public int selectAttendanceId(String memberId, Date attendanceDate) {
		return attendanceRepository.selectAttendanceId(memberId, attendanceDate.toString());
	}

	// 날짜와 출석유형 조회하기
	public Attendance selectDataAndCategory(int attendanceId) {
		return attendanceRepository.selectDataAndCategory(attendanceId);
	}

	@Transactional
	public void insertAll() {
		String today = Today.getToday();
		// 매일 오전 12시에 스켘줄러에 의해 실행 될 메소드이다.
		// 모든 학생 조회
		// 만약 휴가 신청할 경우 출석 데이터가 미리 존재하는 경우도 있다. <- 처리 필요
		List<String> members = memberRepository.selectAllStudent();
		System.out.println("attendance service: insertAll() " + members);
		// 출석 데이터 삽입하기 (결석상태로 초기화)
		try {
			for (String mid : members) {
				if (attendanceRepository.selectId(mid, today) == null) {
					System.out.println("출석 삽입 : " + mid);
					attendanceRepository.insertAttendance(mid);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" 출석 삽입 실패 ! ! !");
		}
	}

	// 조퇴 처리 : 퇴근시간=현재시간으로 설정
	// 출근 시간 충족 여부에 따라 결석/ 조퇴 결정 됨
	public void leaveEarly(String memberId) {
		boolean result = calWorkingTime(memberId, null, null);
		String today = Today.getToday();
		System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		if (!result) { // 출근 시간 미달인 경우
			System.out.println(" 미달~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			attendanceRepository.updateCheckOut(memberId, 0, today); // 결석 처리
		} else {
			attendanceRepository.updateCheckOut(memberId, 3, today); // 조퇴 처리
		}
	}

	// 스케줄러가 호출함 : 최종적으로 퇴근처리 안한 사람 update 처리
	@Transactional
	public void todayPost(Date date, String today){
//		0. 출근했는데 퇴근 시간이 빈 유저 목록 가져오기
		List<Integer> alist = attendanceRepository.selectCheckoutNull(today);
		
//		1. 그 사람들 결석처리, 퇴근시간은 null로 유지
		for(int aid : alist) {
			System.out.println(" 결석 처리 : " + aid);
			attendanceRepository.updateAttendanceStatusById(aid, 0); // 결석 처리
		}
		
//		3. 외출데이터에 복귀값 없으면  18:00 로 수정
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
		date.setHours(18);
		date.setMinutes(0);

				
		String timestamp = sdt.format(date);
		System.out.println("timestamp  : " + timestamp);
		outRepository.updateOutNull(today, timestamp);
		
//		4. 오늘 외출한 member_Id 가져오기
		List<String> members = outRepository.selectMemberId(today);
		
		OutListDto outListDto = null;
		boolean result;
		for(String mid : members) {
			try {
				// 5. 외출한 사람별 총 외출시간 계산하여 	
				// 6. 근무시간 계산하고 최종 수정
				outListDto = outService.getOutDetails(mid, today);
				System.out.println(mid + " 의 오늘 하루 총 외출 시간 : " + outListDto.toString());
				result = calWorkingTime(mid, today, outListDto);
				
				if (!result) { // 출근 시간 미달인 경우
					System.out.println(" 미달 ~~~~~~");
					attendanceRepository.updateCheckOut(mid, 0, today); // 결석 처리
				} else {
					attendanceRepository.updateCheckOut(mid, -1, today); // 가존 상태 유지
				}				
				
			} catch (ParseException e) {e.printStackTrace();}			
		}	
	}


	
}
