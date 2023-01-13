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
import com.team4.myapp.util.date.Today;
import com.team4.myapp.util.scheduler.dto.Statistics;

@Service
public class AttendanceService implements IAttendanceService {

	@Autowired
	IAttendanceRepository attendanceRepository;

	@Autowired
	IMemberRepository memberRepository;

	// 근무시간 충족 여부 검사
	private boolean calWorkingTime(String memberId) {
		// 5 시간 이상 근무 시 true 리턴한다.
		Date date = null;
		try {

			// 출근 시간 조회
			String str = attendanceRepository.selectCheckIn(memberId, Today.getToday());
			System.out.println("str : " + str);
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			date = format.parse(str);
			System.out.println("str : " + date);
		} catch (ParseException e) {
			System.out.println("calWorkingTime() 에러 ");
			e.printStackTrace();
		}
		// 퇴근 or 조퇴 버튼 누른 현재 시간
		Date date2 = new Date();

		// 근무시간 >= 5 이여야 출석 인정
		long total = (date2.getTime() - date.getTime()) / 3600000;
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
		boolean result = calWorkingTime(memberId);

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
	public int selectAttendanceId(String memberId, java.sql.Date attendanceDate) {
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

	// 조퇴 처리
	public void leaveEarly(String memberId) {
		boolean result = calWorkingTime(memberId);
		String today = Today.getToday();
		System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		if (!result) { // 출근 시간 미달인 경우
			System.out.println(" 미달~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			attendanceRepository.updateCheckOut(memberId, 0, today);
		} else {
			attendanceRepository.updateCheckOut(memberId, 3, today);
		}
	}

	@Transactional
	public void todayPost(String today) {
		// 퇴근처리가 안된 경우 18:00 로 값을 넣는다.

		// 외출 시간 계산
		// 외출 값이 있을 경우 -> 마지막 외출의 check_out== null 이면 18:00로 update 한다.
		// 총 외출 시간을 기반으로 근무시간 계산 후 -> 결석 여부 판단

	}

	//다음달 통계행 넣기


	@Override
	public void insertToday(List<Statistics> mlist, String yesterday, String year, String month) {
		for(Statistics memberStatus : mlist) {
			attendanceRepository.insertToday(memberStatus.getMemberId(), memberStatus.getAttendanceStatus(), yesterday, year, month);
		}	
	}

}
