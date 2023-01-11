package com.team4.myapp.attendance.service;

import java.util.Date;
import java.util.List;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.model.CalendarDto;

public interface IAttendanceService {
	
	void insertAll();
	void todayPost(Date date, String today) throws Exception;
	
	List<CalendarDto> selectMemberAttendance(String memberId, int month);
	
	int selectAttendanceId(String memberId, Date attendanceDate);
	Attendance selectDataAndCategory(int attendanceId);

	void updateChekIn(String memberId);
	void updateCheckOut(String memberId);
	
	String selectCheckIn(String memberId);
	String selectCheckOut(String memberId);
	void leaveEarly(String memberId);

	int selectId(String memberId); 
}
