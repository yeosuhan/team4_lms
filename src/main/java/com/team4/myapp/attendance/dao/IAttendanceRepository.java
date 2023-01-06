package com.team4.myapp.attendance.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team4.myapp.attendance.model.Attendance;

public interface IAttendanceRepository {
	List<Attendance> selectMemberAttendance(@Param("memberId")String memberId,  @Param("month") int month);
	
	void insertChekIn(Attendance attendance);
	
	void insertCheckOut(@Param("memberId") String memberId, @Param("today") String today);
	
	int selectId(@Param("memberId") String memberId, @Param("today") String today);
	
	String selectCheckOut(@Param("memberId") String memberId, @Param("today") String today);
}
