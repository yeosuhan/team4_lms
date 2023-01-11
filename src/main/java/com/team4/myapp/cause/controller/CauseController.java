package com.team4.myapp.cause.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.team4.myapp.attendance.model.Attendance;
import com.team4.myapp.attendance.service.IAttendanceService;
import com.team4.myapp.cause.model.Cause;
import com.team4.myapp.cause.model.dto.CauseDto;
import com.team4.myapp.cause.model.dto.CauseListDto;
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
	
	//사유서 작성폼 띄우기
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
		return "cause/write";
	}
	
	//사유서 작성하기
	@RequestMapping(value="/cause/write", method = RequestMethod.POST)
	public String insertCauseWrite(CauseDto causeDto, BindingResult result, RedirectAttributes redirectAttrs, HttpSession session) {
		logger.info("/cause/write : "+ causeDto.toString());
		try {
			causeDto.toString();
			MultipartFile file = causeDto.getFile();
			if(file != null && !file.isEmpty()) {
				logger.info("/cause/write : " + file.getOriginalFilename());
			}		
			
			causeService.insertCause(causeDto);
			System.out.println("글쓰기 성공");
			return "redirect:/cause/list/"+ session.getAttribute("page");
			
		} catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "cause/write";
	}
	
	//사유서 목록 불러오기(유저)
	@RequestMapping(value = "/cause/list/{page}", method = RequestMethod.GET)
	public String selectCauseList(@PathVariable int page, HttpSession session, Model model) {
		//리스트 불러오기
		session.setAttribute("page", page);
		System.out.println("멤버id: "+session.getAttribute("memberid").toString());
		List<CauseListDto> causeList = causeService.selectCauseList((String)session.getAttribute("memberid"), page);
		System.out.println("사이즈: "+causeList.size() + "  페이징: "+page);
		model.addAttribute("causeList", causeList);
		String memberId = session.getAttribute("memberid").toString();
		
		//전체 페이지 구하기(5페이지씩 구분)
		int bbsCount = causeService.selectCauseCount(memberId);
		int totalPageCount=0;
		if(bbsCount > 0) {
			totalPageCount = (int)Math.ceil(bbsCount/5.0);
		}
		
		model.addAttribute("totalPageCount",totalPageCount);
		model.addAttribute("page",page);
		model.addAttribute("boardType", "/cause/list/");
		
		return "cause/list";
	}
	
	//사유서 목록 보기 (관리자)
	@RequestMapping(value="/cause/admin/list/{page}", method = RequestMethod.GET)
	public String selectCauseListAdmin(@PathVariable int page, HttpSession session, Model model) {
		//리스트 불러오기
		session.setAttribute("page", page);
		List<CauseListDto> causeList = causeService.selectCauseListAdmin(page);
		model.addAttribute("causeList", causeList);
		
		//전체 페이지 구하기(5페이지씩 구분)
		int bbsCount = causeService.selectCount();
		System.out.println("관리자 전체 행: "+ bbsCount);
		int totalPageCount=0;
		if(bbsCount > 0) {
			totalPageCount = (int)Math.ceil(bbsCount/5.0);
		}
		model.addAttribute("totalPageCount",totalPageCount);
		model.addAttribute("page",page);
		model.addAttribute("boardType","/cause/admin/list/");
		
		return "manager/list";
	}
	
	//신청서 상세 조회
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="YYYY-MM-dd")
	@ResponseBody
	@RequestMapping(value="/cause/detail/{id}", method=RequestMethod.GET)
	public CauseListDto selectCauseDetail(@PathVariable int id, HttpSession session) {
		CauseListDto cdlist = causeService.selectCauseDetail(id);
		return cdlist;
	}
	
	//사진 보여주기
	@RequestMapping("/file/{causeId}")
	public ResponseEntity<byte[]> getFile(@PathVariable int causeId){
		Cause file = causeService.selectFileDetail(causeId);
		logger.info("getFile "+ file.toString());
		final HttpHeaders headers = new HttpHeaders();
		String[] mtypes = file.getFileContentType().split("/");
		headers.setContentType(new MediaType(mtypes[0], mtypes[1]));
		headers.setContentLength(file.getFileSize());
		headers.setContentDispositionFormData("attachment", file.getFileName(), Charset.forName("UTF-8"));
		return new ResponseEntity<byte[]>(file.getFileData(), headers, HttpStatus.OK);
	}
	
	//사유서 수정
	@RequestMapping(value="/cause/update/{causeId}", method=RequestMethod.GET)
	public String updateCause(@PathVariable int causeId, Model model){
		CauseListDto cause= causeService.selectCauseDetail(causeId);
		
		logger.info("/cause/update : "+ cause.toString());
		model.addAttribute("list",cause);
		return "cause/update";
	}
	
	@RequestMapping(value="/cause/update", method=RequestMethod.POST)
	public String updateCause(Cause cause, BindingResult result, HttpSession session, RedirectAttributes redurectAttrs, Model model) {
		causeService.updateCause(cause);
		
		return "redirect:/cause/list";
	}
	
}
