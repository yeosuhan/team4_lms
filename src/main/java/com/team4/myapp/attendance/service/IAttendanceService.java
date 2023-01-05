package com.team4.myapp.attendance.service;

import java.util.List;

import com.team4.myapp.attendance.controller.dto.CalendarDto;
import com.team4.myapp.attendance.model.Attendance;

public interface IAttendanceService {
	void insertAttendance(Attendance attendance);
	
	List<CalendarDto> selectMemberAttendance(String memberId, int month);

}
