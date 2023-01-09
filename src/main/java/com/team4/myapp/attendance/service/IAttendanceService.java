package com.team4.myapp.attendance.service;

import java.util.List;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.model.CalendarDto;

public interface IAttendanceService {
	
	void insertAll();
	
	List<CalendarDto> selectMemberAttendance(String memberId, int month);

	void updateChekIn(String memberId);
	
	void updateCheckOut(String memberId);
	
	String selectCheckIn(String memberId);
	
	String selectCheckOut(String memberId);
}
