package com.team4.myapp.lecture.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team4.myapp.attendance.model.dto.CalendarDto;
import com.team4.myapp.interceptor.Auth;
import com.team4.myapp.interceptor.Role;
import com.team4.myapp.member.service.ILectureService;

@Controller
@Auth(role = Role.PROFESSOR)
public class LectureController {
	@Autowired
	ILectureService lectureService;
	
	@RequestMapping(value = "/lecture/{id}", method = RequestMethod.GET)
	public String getLectureDetail(@PathVariable int id, @RequestParam String lectureName, Model model, HttpSession session) {
		model.addAttribute("lectureName", lectureName);
		session.setAttribute("lectureId1", id);
		return "lecture/index";
	}
	
	// 관리자가 출결 조회
	@ResponseBody
	@RequestMapping(value="/lecture", method = RequestMethod.GET)
	public List<CalendarDto> getAttendanceList(@RequestParam String day, @RequestParam String month, @RequestParam String year,HttpSession session) {
		if(month.equals("January")) {
			month = "01";
		} else if(month.equals("February")) {
			month = "02";
		} else if(month.equals("March")) {
			month = "03";
		} else if(month.equals("April")) {
			month = "04";
		} else if(month.equals("May")) {
			month = "05";
		} else if(month.equals("June")) {
			month = "06";
		} else if(month.equals("July")) {
			month = "07";
		} else if(month.equals("August")) {
			month = "08";
		} else if(month.equals("September")) {
			month = "09";
		} else if(month.equals("October")) {
			month = "10";
		} else if(month.equals("November")) {
			month = "11";
		} else if(month.equals("December")) {
			month = "12";
		}
		if(day.equals("1")) {
			day = "01";
		} else if(day.equals("2")) {
			day = "02";
		} else if(day.equals("3")) {
			day = "03";
		} else if(day.equals("4")) {
			day = "04";
		} else if(day.equals("5")) {
			day = "05";
		} else if(day.equals("6")) {
			day = "06";
		} else if(day.equals("7")) {
			day = "07";
		} else if(day.equals("8")) {
			day = "08";
		} else if(day.equals("9")) {
			day = "09";
		}
		int lectureId = (Integer) session.getAttribute("lectureId1");
		String today = (String) year+"-"+month+"-"+day;
		return lectureService.selectAttendanceList(lectureId, today);
	}
}
