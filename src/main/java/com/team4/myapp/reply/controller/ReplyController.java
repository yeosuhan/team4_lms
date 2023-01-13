package com.team4.myapp.reply.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team4.myapp.reply.service.IReplyService;

@Controller
public class ReplyController {
	static final Logger logger = LoggerFactory.getLogger(ReplyController.class);

	@Autowired
	IReplyService replyService;

	@RequestMapping(value = "/reply/write", method = RequestMethod.POST)
	public String writeReply(@RequestParam int boardId, @RequestParam String content, RedirectAttributes redirectAttrs, HttpSession session) {
		String memberId = (String) session.getAttribute("memberid");
		replyService.writeReply(boardId, content, memberId);
		return "redirect:/board/detail/"+boardId;
	}
	@RequestMapping(value = "/reply/delete", method = RequestMethod.POST)
	public String deleteReply(@RequestParam int boardId, @RequestParam int replyId, RedirectAttributes redirectAttrs, HttpSession session) {
		String memberId = (String) session.getAttribute("memberid");
		replyService.deleteReply(memberId, replyId);
		return "redirect:/board/detail/"+boardId;
	}
}
