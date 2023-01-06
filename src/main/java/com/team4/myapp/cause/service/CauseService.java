package com.team4.myapp.cause.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team4.myapp.attendance.dao.IAttendanceRepository;
import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.cause.dao.ICauseRepository;
import com.team4.myapp.cause.model.Cause;
import com.team4.myapp.cause.model.dto.CauseDto;

@Service
public class CauseService implements ICauseService{
	
	@Autowired
	ICauseRepository causeRepository;
	
	@Autowired
	IAttendanceRepository attendanceRepository;
	
	//사유서 작성하기
	@Transactional
	public void insertCause(CauseDto causeDto) {
		Cause cause = new Cause();
		int aId = 0;
		if(causeDto.getAttendanceId() == 0) {
			//DB에 먼저 attendanceId 만들기
			attendanceRepository.insertFutureAttendance(causeDto.getMemberId(), causeDto.getAttendanceDate());
			aId = attendanceRepository.selectAttendanceId(causeDto.getMemberId(), causeDto.getAttendanceDate());
			cause.setAttendanceId(aId);
		} else {
			cause.setAttendanceId(causeDto.getAttendanceId());
		}
		//attendanceId가 있는 경우
		cause.setContent(causeDto.getContent());
		cause.setCategoryId(causeDto.getCategoryId());
		cause.setMemberId(causeDto.getMemberId());
		//파일이 있는 경우
		if(causeDto.getFile() != null && !causeDto.getFile().isEmpty()) {
			cause.setFileName(causeDto.getFile().getOriginalFilename());
			cause.setFileSize(causeDto.getFile().getSize());
			cause.setFileContentType(causeDto.getFile().getContentType());
			try {
				cause.setFileData(causeDto.getFile().getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		causeRepository.insertCause(cause);
	}    

}
