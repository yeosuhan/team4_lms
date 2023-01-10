package com.team4.myapp.attendance.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.model.CalendarDto;

public interface IAttendanceService {
	
	void insertAll();
	
	List<CalendarDto> selectMemberAttendance(String memberId, int month);
	
	Optional<Integer> selectAttendanceId(String memberId, Date attendanceDate);
	Attendance selectDataAndCategory(int attendanceId);

	void updateChekIn(String memberId);
	void updateCheckOut(String memberId);
	
	String selectCheckIn(String memberId);
	String selectCheckOut(String memberId);
	void leaveEarly(String memberId);

	int selectId(String memberId); 
}
