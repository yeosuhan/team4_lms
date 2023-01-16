package com.team4.myapp.util.scheduler.dto;

public class Statistics {
	private int attendanceStatus;
	private String memberId;
	private int year;
	private int month;
	private int attendance;
	private int absent;
	private int late;
	private int leave;
	
	public int getAttendanceStatus() {
		return attendanceStatus;
	}
	public void setAttendanceStatus(int attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public int getAbsent() {
		return absent;
	}
	public void setAbsent(int absent) {
		this.absent = absent;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getLeave() {
		return leave;
	}
	public void setLeave(int leave) {
		this.leave = leave;
	}
	
	@Override
	public String toString() {
		return "Statistics [attendanceStatus=" + attendanceStatus + ", memberId=" + memberId + ", year=" + year
				+ ", month=" + month + ", attendance=" + attendance + ", absent=" + absent + ", late=" + late
				+ ", leave=" + leave + "]";
	}
}
