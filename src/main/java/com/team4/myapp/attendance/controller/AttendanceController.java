package com.team4.myapp.attendance.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.myapp.attendance.controller.dto.CalendarDto;
import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.service.IAttendanceService;



@Controller
public class AttendanceController {
	
	@Autowired
	IAttendanceService attendanceService;
	
	// 출근 처리
	@RequestMapping(value = "/attendance/in", method = RequestMethod.GET)
	public String checkIn() {
		System.out.println("ddddddddddddddddddddddddddddd");
		Attendance a1 = new Attendance();
		a1.setMemberId("je");
		
		attendanceService.insertAttendance(a1);
		System.out.println("출석 됨!!!!");
		
		return "redirect:/attendance/main";
	}
	
	
	// 유저의 출결 현황 조회
	@RequestMapping(value = "/attendance/main", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("여기 2 ~~~~~~");
		
		return "calendar/userCalendar";
	}
	
	// 유저의 출결 현황 조회 - 출결 데이터  json으로 반환하기 !!!! 월별로 가져오기 !!! {month}
	@ResponseBody
	@RequestMapping(value = "/attendance/list", method = RequestMethod.GET)
	public List<CalendarDto> getUserAttendanceList() {	
		return attendanceService.selectMemberAttendance("je" , 1);
	}
	

}
