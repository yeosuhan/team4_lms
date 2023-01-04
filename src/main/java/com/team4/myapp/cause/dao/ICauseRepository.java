package com.team4.myapp.cause.dao;

import com.team4.myapp.attendance.domain.Attendance;
import com.team4.myapp.cause.model.Cause;

public interface ICauseRepository {
	
	void insertFutureAttendance(Attendance attendance);
	void insertCause(Cause cause);
}
