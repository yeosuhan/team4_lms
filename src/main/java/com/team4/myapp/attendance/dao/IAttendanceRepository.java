package com.team4.myapp.attendance.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import com.team4.myapp.attendance.model.Attendance;

public interface IAttendanceRepository {
	List<Attendance> selectMemberAttendance(@Param("memberId")String memberId,  @Param("month") int month);
	void insertAttendance(String memberId);
	
	void updateCheckIn(@Param("attendance") Attendance attendance, @Param("today") String today);
	void updateCheckOut(@Param("memberId") String memberId, @Param("attendanceStatus") int attendanceStatus, @Param("today") String today);
	
	Optional<Integer> selectId(@Param("memberId") String memberId, @Param("today") String today);
	
	String selectCheckIn(@Param("memberId") String memberId, @Param("today") String today);
	String selectCheckOut(@Param("memberId") String memberId, @Param("today") String today);
	
	void insertFutureAttendance(@Param("memberId")String memberId, @Param("attendanceDate") Date attendanceDate);
	Attendance selectDataAndCategory(int attendanceId);

}
