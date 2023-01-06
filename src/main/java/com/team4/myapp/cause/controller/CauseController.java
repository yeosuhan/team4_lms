package com.team4.myapp.cause.controller;

import java.sql.Date;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.service.IAttendanceService;
import com.team4.myapp.cause.model.dto.CauseDto;
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
	
	@Autowired
	IAttendanceService attendanceService;
	
	@RequestMapping(value = "/cause/write", method = RequestMethod.GET)
	public String causeForm(@RequestParam(value="attendanceId", required=false, defaultValue="0") int attendanceId, Model model) {
		System.out.println("causeForm띄우기");
		//사유 카테고리 불러오기
		if(attendanceId != 0) {
			//attendance_id로 날짜와 카테고리 불러오기(달력에서 작성버튼 누름)
			Attendance dateAndCategory = attendanceService.selectDataAndCategory(attendanceId);			
			model.addAttribute("dateAndCategory", dateAndCategory);	
		}
		List<ReasonCategory> categoryList = reansonCategoryService.selectCategoryList();
		model.addAttribute("attendanceId", attendanceId);
		model.addAttribute("categoryList", categoryList);
		return "cause/cause_write";
	}
	
	@RequestMapping(value="/cause/write", method = RequestMethod.POST)
	public String insertCauseWrite(CauseDto causeDto, BindingResult result, RedirectAttributes redirectAttrs) {
		logger.info("/cause/write : "+ causeDto.toString());
		try {
			causeDto.toString();
			MultipartFile file = causeDto.getFile();
			if(file != null && !file.isEmpty()) {
				logger.info("/cause/write : " + file.getOriginalFilename());
//				causeDto.setFileName(file.getOriginalFilename());
//				causeDto.setFileSize(file.getSize());
//				causeDto.setFileContentType(file.getContentType());
//				causeDto.setFileData(file.getBytes());
				causeDto.toString();
				logger.info("/cause/write: "+ file.toString());
			}		
			
			causeService.insertCause(causeDto);
			System.out.println("글쓰기 성공");
			return "redirect:/cause/list";
		} catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "cause/cause_write";
	}
	
	@RequestMapping(value = "cause/list", method = RequestMethod.GET)
	public String cause() {
		return "cause/list";
	}
	
	/*@RequestMapping(value = "/example", method = RequestMethod.GET)
	public String test() {
		System.out.println("example");
		return "manager/manager_main";
	}*/
}
