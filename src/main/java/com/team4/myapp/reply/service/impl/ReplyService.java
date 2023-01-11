package com.team4.myapp.reply.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team4.myapp.reply.dao.IReplyRepository;
import com.team4.myapp.reply.model.Reply;
import com.team4.myapp.reply.service.IReplyService;

@Service
public class ReplyService implements IReplyService{
	@Autowired
	IReplyRepository replyRepository;

	@Override
	public void writeReply(Reply reply) {
		replyRepository.writeReply(reply);
	}	
}
