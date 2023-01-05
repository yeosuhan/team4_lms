package com.team4.myapp.cause.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.cause.dao.ICauseRepository;
import com.team4.myapp.cause.model.Cause;

@Service
public class CauseService implements ICauseService{
	
	@Autowired
	ICauseRepository causeRepository;
	
	@Override
	public void insertFutureAttendace(Attendance attendance) {
		causeRepository.insertFutureAttendance(attendance);
	}
	
	@Override
	public void insertCause(Cause cause) {
		causeRepository.insertCause(cause);
	}

	

}
