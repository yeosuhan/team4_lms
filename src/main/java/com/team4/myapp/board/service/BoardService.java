package com.team4.myapp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team4.myapp.board.repository.IBoardRepository;
import com.team4.myapp.board.vo.Board;
import com.team4.myapp.board.vo.BoardUploadFile;

@Service
public class BoardService implements IBoardService {

	@Autowired
	IBoardRepository boardRepository;

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
	public void replyArticle(Board board) {
		//boardRepository.updateReplyNumber(board.getMasterId(), board.getReplyNumber());
		//board.setBoardId(boardRepository.selectMaxArticleNo()+1);
		//board.setReplyNumber(board.getReplyNumber()+1);
		//board.setReplyStep(board.getReplyStep()+1);
		//boardRepository.replyArticle(board);
	}

	@Transactional
	public void replyArticle(Board board, BoardUploadFile file) {
		//boardRepository.updateReplyNumber(board.getMasterId(), board.getReplyNumber());
		//board.setBoardId(boardRepository.selectMaxArticleNo()+1);
		//board.setReplyNumber(board.getReplyNumber()+1);
		//board.setReplyStep(board.getReplyStep()+1);
		//boardRepository.replyArticle(board);
        if(file != null && file.getFileName() != null && !file.getFileName().equals("")) {
        	file.setBoardId(board.getBoardId());
        	file.setFileId(boardRepository.selectMaxFileId()+1);
        	//////boardRepository.insertFileData(file);
        }
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
	public void deleteArticle(int boardId, int replyNumber) {
		if(replyNumber>0) {
			boardRepository.deleteReplyFileData(boardId);
			boardRepository.deleteArticleByBoardId(boardId);
		}else if(replyNumber==0){
			boardRepository.deleteFileData(boardId);
			boardRepository.deleteArticleByMasterId(boardId);
		}else {
			throw new RuntimeException("WRONG_REPLYNUMBER");
		}
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
	public List<Board> searchListByContentKeyword(String keyword, int page) {
		int start = (page-1)*10 + 1;
		return boardRepository.searchListByContentKeyword("%"+keyword+"%", start, start+9); // 오라클은 BETWEEN a AND b에서 a와 b모두 포함하므로 9를 더함
	}

	@Override
	public int selectTotalArticleCountByKeyword(String keyword) {
		return boardRepository.selectTotalArticleCountByKeyword("%"+keyword+"%");
	}

}