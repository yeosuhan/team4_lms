package com.team4.myapp.attendance.service;

import java.sql.Date;
import java.util.List;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.model.CalendarDto;
import com.team4.myapp.util.scheduler.dto.Statistics;

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
	void insertToday(List<Statistics> mlist, String yesterday, String year, String month); 
}
