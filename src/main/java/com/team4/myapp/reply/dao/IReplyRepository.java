package com.team4.myapp.reply.dao;

import org.springframework.ui.Model;

import com.team4.myapp.reply.model.Reply;

public interface IReplyRepository {
	void writeReply(Reply reply);
}
