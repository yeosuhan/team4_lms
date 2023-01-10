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

@Service
public class AttendanceService implements IAttendanceService {

	@Autowired
	IAttendanceRepository attendanceRepository;

	@Autowired
	IMemberRepository memberRepository;
	
	private String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String today = sdf.format(new Date());
		
		return today;
	}
	
	// 근무시간 충족 여부 검사
	private boolean calWorkingTime(String memberId) {
		// 근무시간 게산 로직 필요
		// 5 시간 이상 근무 시 true 리턴한다.
		Date date = null;
        try {
        	String str = attendanceRepository.selectCheckIn(memberId, getToday());
        	System.out.println("str : " + str);
        	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			date = format.parse(str);
		} catch (ParseException e) {
			System.out.println("calWorkingTime() 에러 ");
			e.printStackTrace();
		}
        // 퇴근 or 조퇴 버튼 누른 현재 시간
        Date date2 = new Date();
        
        // 근무시간 >= 5 이여야 출석 인정        
       long total = (date2.getTime() - date.getTime()) / 3600000;
       System.out.println("total hours ~~~  : " + total);
		if(total < 5) {		
			return false;
		}
		
		return true;
	}

	@Override
	public List<CalendarDto> selectMemberAttendance(String memberId, int month) {
//		String startDate = 
		List<Attendance> alist = attendanceRepository.selectMemberAttendance(memberId, month);

		System.out.println("selectMemberAttendance ~~~~~~~~~~~~~~~~~");
		System.out.println(alist);

		List<CalendarDto> clist = new ArrayList<CalendarDto>();

		for (Attendance a : alist) {
			clist.add(CalendarDto.toCalendarDto(a));
		}
		return clist;
	}

	@Override
	public void updateChekIn(String memberId) {
		Attendance attendance = new Attendance();
		attendance.setMemberId(memberId);

		String today = getToday();

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

	@Transactional
	public void updateCheckOut(String memberId) {
		// memberId, 날짜로 출석 id 찾아서 퇴근 값 넣기
		String today = getToday();
		// 퇴근 버튼 누른 시점에서  퇴근시간 - 출근시간 >= 5 여야 출석 인정 됨
		boolean result = calWorkingTime(memberId);
		
		// 근무시간 미달 여부 검사
		if(!result) {
			System.out.println(" ******************************************");
			attendanceRepository.updateCheckOut(memberId, 0, today);
		}
		else attendanceRepository.updateCheckOut(memberId, -1, today);
	}

	@Override
	public String selectCheckIn(String memberId) {
		String today = getToday();

		String checkin = attendanceRepository.selectCheckIn(memberId, today);		
		return checkin;
	}

	@Override
	public String selectCheckOut(String memberId) {
		String today = getToday();

		String checkout = attendanceRepository.selectCheckOut(memberId, today);
		return checkout;
	}

	@Transactional
	public void insertAll() {
		String today = getToday();

		// 매일 오전 12시에 스켘줄러에 의해 실행 될 메소드이다.
		// 모든 학생 조회
		// 만약 휴가 신청할 경우 출석 데이터가 미리 존재하는 경우도 있다. <- 처리 필요
		List<String> members = memberRepository.selectAllStudent();
		System.out.println("attendance service: insertAll() " + members);
		// 출석 데이터 삽입하기 (결석상태로 초기화)
		for (String mid : members) {
			if (attendanceRepository.selectId(mid, today) == null) {
				attendanceRepository.insertAttendance(mid);
			}
		}
	}

}