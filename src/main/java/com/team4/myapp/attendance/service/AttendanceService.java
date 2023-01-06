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
	public void insertAttendance(Attendance attendance) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		attendance.setCheckIn(ts);
		
		// 지각처리
		if(ts.getHours() >= 9 && ts.getMinutes() > 0) {
			attendance.setAttendanceStatus(2);
		}
		
		//2시 이후 출석 시 결석 처리
		else if(ts.getHours() >= 2) {
			attendance.setAttendanceStatus(0);
		}
		
		// 정상 출석 처리
		else {
			attendance.setAttendanceStatus(1);
		}

		attendance.setSubmitStatus(0);
		attendanceRepository.insertAttendance(attendance);
	}

	@Override
	public List<CalendarDto> selectMemberAttendance(String memberId, int month) {
//		String startDate = 
		List<Attendance> alist = attendanceRepository.selectMemberAttendance(memberId, month);

		System.out.println("~~~~~~~~~~~~~~~~~");
		System.out.println(alist);

		List<CalendarDto> clist = new ArrayList<CalendarDto>();

		for (Attendance a : alist) {
			clist.add(CalendarDto.toCalendarDto(a));
		}
		return clist;
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
