package com.team4.myapp.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.member.model.Lecture;

public interface ILectureRepository {
	List<Lecture> selectAllLecture();
	List<Attendance> selectAttendanceList(@Param("lectureId")int lectureId, @Param("today")String today);
}
