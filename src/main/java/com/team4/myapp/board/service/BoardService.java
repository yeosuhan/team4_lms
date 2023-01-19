package com.team4.myapp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team4.myapp.board.dao.IBoardRepository;
import com.team4.myapp.board.model.Board;
import com.team4.myapp.reply.dao.IReplyRepository;

@Service
public class BoardService implements IBoardService {

	@Autowired
	IBoardRepository boardRepository;
	
	@Autowired
	IReplyRepository replyRepository;

	@Transactional
	public void insertArticle(Board board) {
		boardRepository.insertArticle(board);
	}
	
	@Transactional
	public void insertFileArticle(Board board) {
        	boardRepository.insertFileData(board);
        //}
	}

	@Override
	public List<Board> selectArticleListByCategory(String boardType, int page) {
		int start = (page-1)*10 + 1;
		return boardRepository.selectArticleListByCategory(boardType, start, start+9); // 오라클은 BETWEEN a AND b에서 a와 b모두 포함하므로 9를 더함
	}

	@Transactional
	public Board selectArticle(int boardId) {
		boardRepository.updateReadCount(boardId);
		return boardRepository.selectArticle(boardId);
	}

	@Override
	public Board getFile(int boardId) {
		return boardRepository.selectArticle(boardId);
	}
	
	@Override
	public Board getFileCount(int boardId) {
		boardRepository.updateDownloadCount(boardId);
		return boardRepository.selectArticle(boardId);
	}	
	
	@Transactional
	public void updateArticle(Board board) {
		boardRepository.updateArticle(board);
        if(board.getFile() != null && board.getFileName() != null && !board.getFileName().equals("")) {
        	boardRepository.updateFileData(board);
        }
	}
	
	@Override
	public Board selectDeleteArticle(int boardId) {
		return boardRepository.selectDeleteArticle(boardId);
	}
	
	@Transactional
	public void deleteArticle(int boardId) {
		boardRepository.deleteArticleByBoardId(boardId);
	}

	@Override
	public int selectTotalArticleCount() {
		return boardRepository.selectTotalArticleCount();
	}

	@Override
	public int selectTotalArticleCountByCategoryId(String boardType) {
		return boardRepository.selectTotalArticleCountByCategoryId(boardType);
	}

	@Override
	public List<Board> searchListByContentKeyword(String keyword, String boardType, int page) {
		int start = (page-1)*10 + 1;
		return boardRepository.searchListByContentKeyword("%"+keyword+"%", boardType, start, start+9); // 오라클은 BETWEEN a AND b에서 a와 b모두 포함하므로 9를 더함
	}

	@Override
	public int selectTotalArticleCountByKeyword(String keyword, String boardType) {
		return boardRepository.selectTotalArticleCountByKeyword("%"+keyword+"%", boardType);
	}

	@Override
	public void addHeartCount(int boardId) {
		boardRepository.updateHeartCount(boardId);
	}

}