package com.team4.myapp.reply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team4.myapp.reply.model.Reply;

public interface IReplyRepository {
	void writeReply(@Param("boardId")int boardId, @Param("content")String content, @Param("memberId")String memberId);

	List<Reply> selectReply(int boardId);

	void deleteReply(@Param("memberId")String memberId, @Param("replyId")int replyId);
}
