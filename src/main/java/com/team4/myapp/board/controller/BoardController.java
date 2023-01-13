package com.team4.myapp.board.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team4.myapp.board.model.Board;
import com.team4.myapp.board.service.IBoardService;
<<<<<<< HEAD
import com.team4.myapp.reply.model.Reply;
import com.team4.myapp.reply.service.IReplyService;
=======
import com.team4.myapp.interceptor.Auth;
import com.team4.myapp.interceptor.Role;
>>>>>>> branch 'main' of https://github.com/oti-team4/team4_lms.git

@Controller
public class BoardController {
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	IBoardService boardService;
	
	@Autowired
	IReplyService replyService;
	// 작성 폼 열기
	@RequestMapping(value = "/board/write/{boardType}", method = RequestMethod.GET)
	public String writeArticle(@PathVariable String boardType, Locale locale, Model model) {
		model.addAttribute("boardType", boardType);
		return "board/writeform";
	}

	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String writeArticle(Board board, BindingResult results, RedirectAttributes redirectAttrs) {
		try{
			board.setContent(board.getContent().replace("\r\n", "<br>"));
			board.setTitle(Jsoup.clean(board.getTitle(), Whitelist.basic()));
			board.setContent(Jsoup.clean(board.getContent(), Whitelist.basic()));
			MultipartFile mfile = board.getFile();
			if(mfile!=null && !mfile.isEmpty()) {
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
			System.out.println("");
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/board/list/"+board.getBoardType();
	}
	
	@RequestMapping("/board/list/{boardType}/{page}")
	public String getListByCategory(@PathVariable String boardType, @PathVariable int page, HttpSession session, Model model) {
		session.setAttribute("page", page);
		model.addAttribute("boardType", boardType);
		
		List<Board> boardList = boardService.selectArticleListByCategory(boardType, page);
		model.addAttribute("boardList", boardList);

		// paging start
		int bbsCount = boardService.selectTotalArticleCountByCategoryId(boardType);
		int totalPage = 0;
		if(bbsCount > 0) {
			totalPage= (int)Math.ceil(bbsCount/10.0);
		}
		model.addAttribute("totalPageCount", totalPage);
		model.addAttribute("page", page);
		return "board/boardlist";
	}

	@RequestMapping("/board/list/{boardType}")
	public String getListByCategory(@PathVariable String boardType, HttpSession session, Model model) {
		return getListByCategory(boardType, 1, session, model);
	}

	@RequestMapping("/board/detail/{boardId}")
	public String getBoardDetails(@PathVariable int boardId, Model model) {		
		Board board = boardService.selectArticle(boardId);
		List <Reply> reply = replyService.selectReply(boardId);
		model.addAttribute("board", board);
		model.addAttribute("boardType", board.getBoardType());
		model.addAttribute("reply", reply);
		return "board/boarddetail";
	}
	
	@RequestMapping("/board/download/{boardId}")
	public ResponseEntity<byte[]> getFile(@PathVariable int boardId) {
		Board board= boardService.getFile(boardId);
		final HttpHeaders headers = new HttpHeaders();
		String[] mtypes = board.getFileContentType().split("/");
		headers.setContentType(new MediaType(mtypes[0], mtypes[1]));
		headers.setContentLength(board.getFileSize());
		headers.setContentDispositionFormData("attachment", board.getFileName(), Charset.forName("UTF-8"));
		return new ResponseEntity<byte[]>(board.getFileData(), headers, HttpStatus.OK);
	}
	
	@RequestMapping("/board/download/{boardId}/cnt")
	public ResponseEntity<byte[]> getFileCount(@PathVariable int boardId) {
		Board board= boardService.getFileCount(boardId);
		final HttpHeaders headers = new HttpHeaders();
		String[] mtypes = board.getFileContentType().split("/");
		headers.setContentType(new MediaType(mtypes[0], mtypes[1]));
		headers.setContentLength(board.getFileSize());
		headers.setContentDispositionFormData("attachment", board.getFileName(), Charset.forName("UTF-8"));
		return new ResponseEntity<byte[]>(board.getFileData(), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/board/update/{boardId}", method=RequestMethod.GET)
	public String updateArticle(@PathVariable int boardId, Model model) {
		//List<BoardCategory> categoryList = categoryService.selectAllCategory();
		//model.addAttribute("categoryList", categoryList);
		Board board = boardService.selectArticle(boardId);
		//model.addAttribute("boardType", board.getBoardType());
		model.addAttribute("board", board);
		return "board/updateform";
	}

	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String updateArticle(Board board, RedirectAttributes redirectAttrs) {
		//String dbPassword = boardService.getPassword(board.getBoardId());
		//if(!board.getPassword().equals(dbPassword)) {
//			throw new RuntimeException("게시글 비밀번호가 다릅니다.");
			//redirectAttrs.addFlashAttribute("passwordError", "게시글 비밀번호가 다릅니다");
			//return "redirect:/board/update/" + board.getBoardId();
		//}
		try{
			board.setTitle(Jsoup.clean(board.getTitle(), Whitelist.basic()));
			board.setContent(Jsoup.clean(board.getContent(), Whitelist.basic()));
			MultipartFile mfile = board.getFile();
			if(mfile!=null && !mfile.isEmpty()) {
				//BoardUploadFile file = new BoardUploadFile();
				board.setFileName(mfile.getOriginalFilename());
				board.setFileSize(mfile.getSize());
				board.setFileContentType(mfile.getContentType());
				board.setFileData(mfile.getBytes());
			}
			boardService.updateArticle(board);
			
		}catch(Exception e){
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/board/detail/"+board.getBoardId();
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.POST)
	public String deleteArticle(Board board, HttpSession session, Model model) {
		try {	
			boardService.deleteArticle(board.getBoardId()); //, board.getReplyNumber());
			return "redirect:/board/list/" + board.getBoardType() + "/" + (Integer)session.getAttribute("page");			
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "error/runtime";
		}
	}
	
	@RequestMapping("/board/search/{boardType}/{page}")
	public String search(@RequestParam(required=false, defaultValue="") String keyword, @PathVariable String boardType, @PathVariable int page, HttpSession session, Model model) {
		try {
			List<Board> boardList = boardService.searchListByContentKeyword(keyword, boardType, page);
			model.addAttribute("boardList", boardList);
	
			// 검색 결과 페이징 처리
			int bbsCount = boardService.selectTotalArticleCountByKeyword(keyword, boardType);
			int totalPage = 0;

			if(bbsCount > 0) {
				totalPage= (int)Math.ceil(bbsCount/10.0);
			}
			model.addAttribute("totalPageCount", totalPage);
			model.addAttribute("page", page);
			model.addAttribute("keyword", keyword);
			model.addAttribute("boardType", boardType);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "board/boardsearch";
	}
	
	@RequestMapping("/board/like/{boardId}")
	public String addHeartCount(@PathVariable int boardId) {
		boardService.addHeartCount(boardId);
		return "redirect:/board/detail/"+boardId;
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
