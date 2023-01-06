package com.team4.myapp.board.service;

import java.util.List;

import com.team4.myapp.board.vo.Board;
import com.team4.myapp.board.vo.BoardUploadFile;

public interface IBoardService {
	void insertArticle(Board boardId);
	void insertFileArticle(Board boardId);
	
	List<Board> selectArticleListByCategory(String boardType, int page);
	
	Board selectArticle(int boardId);
	
	BoardUploadFile getFile(int fileId);
	
	void replyArticle(Board board);
	void replyArticle(Board board, BoardUploadFile file);

	String getPassword(int boardId);
	
	void updateArticle(Board board);
	void updateArticle(Board board, BoardUploadFile file);
	
	Board selectDeleteArticle(int boardId);
	void deleteArticle(int boardId, int replyNumber);
	
	int selectTotalArticleCount();
	int selectTotalArticleCountByCategoryId(String boardType);
	
	List<Board> searchListByContentKeyword(String keyword, int page);
	int selectTotalArticleCountByKeyword(String keyword);
}