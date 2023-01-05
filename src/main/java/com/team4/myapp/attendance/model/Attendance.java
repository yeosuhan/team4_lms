package com.team4.myapp.attendance.model;


import java.util.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
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
	private String memberId;
	private Date attendanceDate;
	private Timestamp start;
	private Timestamp end;
	private int attendanceStatus;
	private int submitStatus;

}
