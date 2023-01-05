package com.team4.myapp.member.model;

public class Lecture {
	private int lectureId;
	private String lectureName;
	
	public int getLectureId() {
		return lectureId;
	}
	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	@Override
	public String toString() {
		return "Lecture [lectureId=" + lectureId + ", lectureName=" + lectureName + "]";
	}
	
}
