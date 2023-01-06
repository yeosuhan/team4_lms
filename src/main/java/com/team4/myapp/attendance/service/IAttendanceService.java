package com.team4.myapp.attendance.service;

import java.util.List;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.model.CalendarDto;

public interface IAttendanceService {
	
	List<CalendarDto> selectMemberAttendance(String memberId, int month);

	void insertChekIn(Attendance attendance);
	
	void insertCheckOut(String memberId);
	
	int selectId(String memberId);
	
	String selectCheckOut(String memberId);
}
