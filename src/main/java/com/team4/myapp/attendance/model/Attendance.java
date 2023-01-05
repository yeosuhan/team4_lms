package com.team4.myapp.attendance.domain;


import java.util.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
	private int attendanceId;
	private String memeberId;
	private Date attendanceDate;
	private Timestamp start;
	private Timestamp end;
	private int attendanceStatus;
	private int submitStatus;

}
