package com.team4.myapp.cause.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team4.myapp.attendance.domain.Attendance;
import com.team4.myapp.cause.model.Cause;
import com.team4.myapp.cause.service.ICauseService;

@Controller
public class CauseController {
	static final Logger logger = LoggerFactory.getLogger(CauseController.class);
	
	@Autowired
	ICauseService causeService;
	
	@RequestMapping(value = "/cause/list", method = RequestMethod.GET)
	public String base() {
		System.out.println("cause_detail");
		return "cause/cause_detail";
	}
	
	@RequestMapping(value="/cause/list/1", method = RequestMethod.POST)
	public String insertCauseWrite(Attendance attendance, Cause cause, BindingResult result, RedirectAttributes redirectAttrs) {
		logger.info("/cause/write : "+ cause.toString());
		try {
			/*attendance.setAttendanceStatus(attendance.getAttendanceStatus());
			attendance.setMemberId(attendance.getMemberId());*/
			attendance.setAttendanceStatus(0);
			attendance.setMemberId("hong");
			causeService.insertFutureAttendace(attendance);
			
			/*cause.setContent(cause.getContent());
			cause.setStatus(cause.getStatus());
			cause.setCategoryId(cause.getCategoryId());
			cause.setAttendanceId(cause.getAttendanceId());
			cause.setMemberId(cause.getMemberId());*/
			cause.setContent("병원에 다녀옵니다.");
			cause.setStatus(0);
			cause.setCategoryId(7);
			cause.setAttendanceId(1);
			cause.setMemberId("hong");
			causeService.insertCause(cause);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		System.out.printf("글쓰기 성공");
		return "성공";
	}
	
	/*@RequestMapping(value = "/example", method = RequestMethod.GET)
	public String test() {
		System.out.println("example");
		return "manager/manager_main";
	}*/
}
