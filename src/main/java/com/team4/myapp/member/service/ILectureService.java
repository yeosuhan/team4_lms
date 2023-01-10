package com.team4.myapp.member.service;

import java.util.List;

import com.team4.myapp.attendance.model.CalendarDto;
import com.team4.myapp.member.model.Lecture;

public interface ILectureService {
	List<Lecture> selectAllLecture();
	List<CalendarDto> selectAttendanceList(int lectureId, String today);
}
