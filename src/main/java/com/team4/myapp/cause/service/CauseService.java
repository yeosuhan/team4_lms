package com.team4.myapp.cause.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.team4.myapp.attendance.dao.IAttendanceRepository;
import com.team4.myapp.cause.dao.ICauseRepository;
import com.team4.myapp.cause.model.Cause;
import com.team4.myapp.cause.model.dto.CauseDto;
import com.team4.myapp.cause.model.dto.CauseListDto;

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
			aId = attendanceRepository.selectId(causeDto.getMemberId(), causeDto.getAttendanceDate().toString());
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

	//사유서 리스트 보기
	@Transactional
	public List<CauseListDto> selectCauseList(String memberId, int page) {
		//페이징 처리
		int start = ((page-1) * 5) +1;
		
		List<CauseListDto> list = causeRepository.selectCauseList(memberId, start, start+4);
		for(CauseListDto i : list) {
			String  s = i.attendanceStatus(i.getAttendanceStatus());
			i.setAttendanceStatusString(s);
		}
		
		return list;
	}

	//전체 행수 구하기
	@Override
	public int selectCauseCount(String memberId) {
		return causeRepository.selectCauseCount(memberId);
	} 
	
	

}
