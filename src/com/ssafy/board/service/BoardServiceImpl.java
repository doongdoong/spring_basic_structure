package com.ssafy.board.service;

import java.util.List;

import com.ssafy.board.dao.BoardDAO;
import com.ssafy.board.dao.BoardDAOImpl;
import com.ssafy.board.vo.Board;

public class BoardServiceImpl implements BoardService {

	private BoardDAO dao;
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}
	
	@Override
	public List<Board> list() throws Exception {
		return dao.selectBoard();
	}

	@Override
	public Board detail(int no) throws Exception {
		return dao.selectBoardByNo(no);
	}

	@Override
	public void delete(int no) throws Exception {
		dao.deleteBoard(no);
	}

	@Override
	public void addBoard(Board board) throws Exception {
		dao.insertBoard(board);
	}
}
