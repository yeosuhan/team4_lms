package com.team4.myapp.attendance.controller.dto;

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
	private int attendanceId;
	private int attendanceStatus;
	private int submitStatus;
	
	public static CalendarDto toCalendarDto(Attendance attendance) {
		String status = "";
		switch (attendance.getAttendanceStatus()) {
		case 0: status = "결석";
				break;
		case 1:  status = "출석";
				break;
		case 2:  status = "지각";
				break;
		case 3:  status = "조퇴";
				break;
		}
		
		return new CalendarDto(attendance.getCheckIn(), attendance.getCheckOut(), status, 
				attendance.getAttendanceId(), attendance.getAttendanceStatus(), attendance.getSubmitStatus());
	}
}
