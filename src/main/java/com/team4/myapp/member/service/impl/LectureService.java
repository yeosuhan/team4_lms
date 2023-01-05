package com.team4.myapp.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.myapp.member.dao.ILectureRepository;
import com.team4.myapp.member.model.Lecture;
import com.team4.myapp.member.service.ILectureService;
@Service
public class LectureService implements ILectureService {

	@Autowired
	ILectureRepository lectureRepository;
	
	@Override
	public List<Lecture> selectAllLecture() {
		return lectureRepository.selectAllLecture();
	}

}
