package com.team4.myapp.board.service;

import java.util.List;

import com.team4.myapp.board.model.Board;
import com.team4.myapp.board.model.BoardUploadFile;

public interface IBoardService {
	void insertArticle(Board boardId);
	void insertFileArticle(Board boardId);
	
	List<Board> selectArticleListByCategory(String boardType, int page);
	
	Board selectArticle(int boardId);	
	Board getFile(int boardId);
	Board getFileCount(int boardId);
	
	void replyArticle(Board board);
	void replyArticle(Board board, BoardUploadFile file);
	
	void updateArticle(Board board);
	
	Board selectDeleteArticle(int boardId);
	void deleteArticle(int boardId); //, int replyNumber);
	
	int selectTotalArticleCount();
	int selectTotalArticleCountByCategoryId(String boardType);
	
	List<Board> searchListByContentKeyword(String keyword, String boardType, int page);
	int selectTotalArticleCountByKeyword(String keyword, String boardType);
	void addHeartCount(int boardId);
}