package com.team4.myapp.attendance.controller.dto;

import java.sql.Timestamp;

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
}
