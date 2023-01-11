package com.team4.myapp.reply.service;

import java.util.List;

import com.team4.myapp.reply.model.Reply;

public interface IReplyService {
	void writeReply(int boardId, String content, String memberId);

	List<Reply> selectReply(int boardId);

	void deleteReply(String memberId, int replyId);
}
