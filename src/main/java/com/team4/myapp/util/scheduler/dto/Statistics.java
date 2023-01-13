package com.team4.myapp.util.scheduler.dto;

public class Statistics {
	private int attendanceStatus;
	private String memberId;
	
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
	@Override
	public String toString() {
		return "Statistics [attendanceStatus=" + attendanceStatus + ", memberId=" + memberId + "]";
	}
	
}
