package com.team4.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CauseController {
	@RequestMapping(value = "/iindex", method = RequestMethod.GET)
	public String base() {
		System.out.println("aa");
		return "cause/cause_detail";
	}
}
