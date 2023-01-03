package com.team4.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginComtroller {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String base() {
		return "login/login";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String cause() {
		return "cause/list";
	}
}
