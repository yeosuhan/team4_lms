package com.team4.myapp.reply.controller;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team4.myapp.reply.model.Reply;
import com.team4.myapp.reply.service.IReplyService;

@Controller
public class ReplyController {
	static final Logger logger = LoggerFactory.getLogger(ReplyController.class);

	@Autowired
	IReplyService replyService;

	@RequestMapping(value = "/reply/write", method = RequestMethod.POST)
	public String writeReply(Reply reply, BindingResult results, RedirectAttributes redirectAttrs) {
		try {
			reply.setContent(Jsoup.clean(reply.getContent(), Whitelist.basic()));
			System.out.println(reply);
			replyService.writeReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		return "redirect/boarddetail/"+reply.getBoardId();
	}
}
