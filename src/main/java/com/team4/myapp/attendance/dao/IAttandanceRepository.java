package com.team4.myapp.attendance.dao;

import org.apache.ibatis.annotations.Param;

public interface IAttandanceRepository {
	int selectAttendanceId(@Param("memberId") String memberId, @Param("attendanceDate") String attendanceDate);

}
