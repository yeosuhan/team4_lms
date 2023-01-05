package com.team4.myapp.member.dao;

import java.util.List;

import com.team4.myapp.member.model.Lecture;

public interface ILectureRepository {
	List<Lecture> selectAllLecture();
}
