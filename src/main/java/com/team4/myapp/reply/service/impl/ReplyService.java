package com.team4.myapp.reply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.myapp.reply.dao.IReplyRepository;
import com.team4.myapp.reply.model.Reply;
import com.team4.myapp.reply.service.IReplyService;

@Service
public class ReplyService implements IReplyService{
	@Autowired
	IReplyRepository replyRepository;

	@Override
	public void writeReply(int boardId, String content, String memberId) {
		replyRepository.writeReply(boardId, content, memberId);			
	}	
	@Override
	public List<Reply> selectReply(int boardId) {
		return replyRepository.selectReply(boardId);
	}
	@Override
	public void deleteReply(String memberId, int replyId) {
		replyRepository.deleteReply(memberId, replyId);	
	}
}
