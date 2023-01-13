package com.team4.myapp.attendance.model;

import java.sql.Timestamp;

import com.team4.myapp.attendance.model.Attendance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CalendarDto {
	private Timestamp start;
	private Timestamp end;
	private String title;
	private String id;
	private int attendanceStatus;
	private int submitStatus;
	private String memberName;
	private String backgroundColor;
	private String borderColor;
	private String url;

	public static CalendarDto toCalendarDto(Attendance attendance) {
		String status = "";
		String color = "";
		String url = null;
		int aStatus = attendance.getAttendanceStatus();

		switch (aStatus) {
		case 0:
			status = "결석";
			color = "#FF6363";
			break;
		case 1:
			status = "출석";
			color = "#47D99E";
			break;
		case 2:
			status = "지각";
			color = "#FFFDA2";
			break;
		case 3:
			status = "조퇴";
			color = "#FFAB76";
			break;
		}

		if(attendance.getAttendanceStatus() == 1) url = "/attendance/main";
		else if(attendance.getAttendanceStatus() != 1 || attendance.getSubmitStatus() == 1){
			url = "/cause/update/0?attendanceId=" + attendance.getAttendanceId();
		}  // 수정페이지
		else if(attendance.getAttendanceStatus() != 1 || (attendance.getSubmitStatus() == 2 
				|| attendance.getSubmitStatus() == 3)) {
			// 리스트 페이지
			url = "/cause/list/1";
		}
		else if(attendance.getAttendanceStatus() != 1 || attendance.getSubmitStatus() == 0) {
			// 작성페이지
			url = "/cause/write";
		} 
		return new CalendarDto(attendance.getCheckIn(), attendance.getCheckOut(), status, attendance.getAttendanceId()+"",
				attendance.getAttendanceStatus(), attendance.getSubmitStatus(), attendance.getMemberName(), color, color, url);
	}
}
