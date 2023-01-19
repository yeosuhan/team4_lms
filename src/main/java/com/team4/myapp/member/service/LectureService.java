package com.team4.myapp.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.model.dto.CalendarDto;
import com.team4.myapp.member.dao.ILectureRepository;
import com.team4.myapp.member.model.Lecture;
@Service
public class LectureService implements ILectureService {

	@Autowired
	ILectureRepository lectureRepository;
	
	@Override
	public List<Lecture> selectAllLecture() {
		return lectureRepository.selectAllLecture();
	}

	@Override
	public List<CalendarDto> selectAttendanceList(int lectureId, String today) {
		List<Attendance> mlist = lectureRepository.selectAttendanceList(lectureId, today);		
		List<CalendarDto> malist = new ArrayList<CalendarDto>();
		for(Attendance att : mlist) {
			malist.add(CalendarDto.toCalendarDto(att));
		}
		return malist;
	}

}
