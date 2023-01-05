package com.team4.myapp.board.controller;

import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team4.myapp.board.service.IBoardService;
import com.team4.myapp.board.vo.Board;

@Controller
public class BoardController {
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	IBoardService boardService;
	
	// 작성 폼 열기
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String writeArticle(Locale locale, Model model) {	
		return "board/writeform";
	}

	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String writeArticle(Board board, BindingResult results, RedirectAttributes redirectAttrs) {
		//logger.info("/board/write : " + board.toString());
		try{
			board.setContent(board.getContent().replace("\r\n", "<br>"));
			board.setTitle(Jsoup.clean(board.getTitle(), Whitelist.basic()));
			board.setContent(Jsoup.clean(board.getContent(), Whitelist.basic()));
			MultipartFile mfile = board.getFile();
			if(mfile!=null && !mfile.isEmpty()) {
				logger.info("/board/write : " + mfile.getOriginalFilename());
				board.setFileName(mfile.getOriginalFilename());
				board.setFileSize(mfile.getSize());
				board.setFileContentType(mfile.getContentType());
				board.setFileData(mfile.getBytes());
				boardService.insertFileArticle(board);
			}else {
				boardService.insertArticle(board);
			}
		}catch(Exception e){
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/board/write";
	}
	
	// 유저의 출결 현황 조회 - 출결 데이터  json으로 반환하기
	//@ResponseBody
	//@RequestMapping(value = "/attendance/list", method = RequestMethod.GET)
	//public List<CalendarDto> getUserAttendanceList() {
		//List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		//CalendarDto a1 = new CalendarDto(new Timestamp(System.currentTimeMillis()),
				//new Timestamp(System.currentTimeMillis()), "출석");
		
		//list.add(a1);
		//System.out.println(a1);
		//return list;
	//}

}
