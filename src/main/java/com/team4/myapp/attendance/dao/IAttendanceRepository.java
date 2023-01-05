package com.team4.myapp.attendance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team4.myapp.attendance.model.Attendance;

public interface IAttendanceRepository {
	List<Attendance> selectMemberAttendance(@Param("memberId")String memberId,  @Param("month") int month);
	void insertAttendance(Attendance attendance);
}
