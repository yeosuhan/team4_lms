package com.team4.myapp.cause.service;

import com.team4.myapp.attendance.domain.Attendance;
import com.team4.myapp.cause.model.Cause;

public interface ICauseService {
	void insertFutureAttendace(Attendance attendance);
	void insertCause(Cause cause);
	
}
