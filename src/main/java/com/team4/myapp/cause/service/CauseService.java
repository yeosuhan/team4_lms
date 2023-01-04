package com.team4.myapp.cause.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team4.myapp.attendance.domain.Attendance;
import com.team4.myapp.cause.dao.ICauseRepository;
import com.team4.myapp.cause.model.Cause;

@Service
public class CauseService implements ICauseService{
	
	@Autowired
	ICauseRepository causeRepository;
	
	@Transactional
	public void insertFutureAttendace(Attendance attendance) {
		causeRepository.insertFutureAttendance(attendance);
	}
	
	@Transactional
	public void insertCause(Cause cause) {
		causeRepository.insertCause(cause);
	}

	

}
