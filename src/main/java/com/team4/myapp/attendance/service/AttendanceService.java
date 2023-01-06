package com.team4.myapp.attendance.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team4.myapp.attendance.controller.dto.CalendarDto;
import com.team4.myapp.attendance.dao.IAttendanceRepository;
import com.team4.myapp.attendance.model.Attendance;


@Service
public class AttendanceService implements IAttendanceService {

	@Autowired
	IAttendanceRepository attendanceRepository;
	
	
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
	public void insertChekIn(Attendance attendance) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		attendance.setCheckIn(ts);
		System.out.println(">>>>   " + ts.getHours());
		
		//2시 이후 출석 시 결석 처리
		if(ts.getHours() >= 14) {
			attendance.setAttendanceStatus(0);
		}		
		// 지각처리
		else if(ts.getHours() >= 9 && ts.getMinutes() > 0) {
			attendance.setAttendanceStatus(2);
		}			
		// 정상 출석 처리
		else {
			attendance.setAttendanceStatus(1);
		}

		attendance.setSubmitStatus(0);
		attendanceRepository.insertChekIn(attendance);
	}

	@Transactional
	public void insertCheckOut(String memberId) {
		// memberId, 날짜로 출석 id 찾아서  퇴근 값 넣기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String today = sdf.format(new Date());
		attendanceRepository.insertCheckOut(memberId, today);		
	}

	@Override
	public int selectId(String memberId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String today = sdf.format(new Date());
		
		int attendanceId = attendanceRepository.selectId(memberId, today);
		return attendanceId;
	}

	@Override
	public String selectCheckOut(String memberId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String today = sdf.format(new Date());
		
		String checkout = attendanceRepository.selectCheckOut(memberId, today);
		return checkout;
	}
	
	//출석ID 가져오기
	@Override
	public int selectAttendanceId(String memberId, Date attendanceDate) {
		
		return attendanceRepository.selectAttendanceId(memberId, attendanceDate);
	}

	//날짜와 출석유형 조회하기
	@Override
	public Attendance selectDataAndCategory(int attendanceId) {
		return attendanceRepository.selectDataAndCategory(attendanceId);
	}
}
