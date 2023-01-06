package com.team4.myapp.attendance.service;

import java.sql.Date;
import java.util.List;

import com.team4.myapp.attendance.controller.dto.CalendarDto;
import com.team4.myapp.attendance.model.Attendance;

public interface IAttendanceService {
	void insertAttendance(Attendance attendance);
	
	List<CalendarDto> selectMemberAttendance(String memberId, int month);
	
	int selectAttendanceId(String memberId, Date attendanceDate);
	Attendance selectDataAndCategory(int attendanceId);

}
