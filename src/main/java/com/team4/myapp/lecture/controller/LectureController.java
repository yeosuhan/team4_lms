package com.team4.myapp.lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LectureController {
	
	@RequestMapping(value = "/lecture/{id}", method = RequestMethod.GET)
	public String getLectureDetail(@PathVariable int id) {
		
		return "lecture/index";
	}
}
