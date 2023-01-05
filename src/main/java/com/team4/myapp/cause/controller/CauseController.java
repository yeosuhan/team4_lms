package com.team4.myapp.cause.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team4.myapp.cause.model.Cause;
import com.team4.myapp.cause.service.ICauseService;
import com.team4.myapp.reasoncategory.model.ReasonCategory;
import com.team4.myapp.reasoncategory.service.IReasonCategoryService;



@Controller
public class CauseController {
	static final Logger logger = LoggerFactory.getLogger(CauseController.class);
	
	@Autowired
	ICauseService causeService;
	
	@Autowired
	IReasonCategoryService reansonCategoryService;
	
	@RequestMapping(value = "/cause/write", method = RequestMethod.GET)
	public String causeForm(Model model) {
		System.out.println("cause_detail");
		List<ReasonCategory> categoryList = reansonCategoryService.selectCategoryList();
		model.addAttribute("categoryList", categoryList);
		return "cause/cause_detail";
	}
	
	@RequestMapping(value="/cause/write", method = RequestMethod.POST)
	public String insertCauseWrite(@RequestParam(value="attandanceId", required=false, defaultValue="0") int attendanceId, Cause cause, BindingResult result, RedirectAttributes redirectAttrs) {
		logger.info("/cause/write : "+ cause.toString());
		try {
			if(attendanceId==0) {
				
			}
			cause.setContent(cause.getContent());
			cause.setStatus(cause.getStatus());
			cause.setCategoryId(cause.getCategoryId());
//			cause.setAttendanceId(cause.getAttendanceId());
			cause.setAttendanceId(1);
//			cause.setMemberId(cause.getMemberId());
			cause.setMemberId("hong");
			causeService.insertCause(cause);
			logger.info("/cause/write : "+ cause.toString());
			
			
		} catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		System.out.println("글쓰기 성공");
		return "성공";
	}
	
	/*@RequestMapping(value = "/example", method = RequestMethod.GET)
	public String test() {
		System.out.println("example");
		return "manager/manager_main";
	}*/
}
