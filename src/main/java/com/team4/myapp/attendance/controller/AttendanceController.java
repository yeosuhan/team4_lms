package com.team4.myapp.attendance.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.myapp.attendance.controller.dto.CalendarDto;

@Controller
public class AttendanceController {
	
	// 유저의 출결 현황 조회
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("여기 2 ~~~~~~");
		
		return "index";
	}
	
	// 유저의 출결 현황 조회 - 출결 데이터  json으로 반환하기
	@ResponseBody
	@RequestMapping(value = "/attendance/list", method = RequestMethod.GET)
	public List<CalendarDto> getUserAttendanceList() {
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		CalendarDto a1 = new CalendarDto(new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), "출석");
		
		list.add(a1);
		System.out.println(a1);
		return list;
	}

}
