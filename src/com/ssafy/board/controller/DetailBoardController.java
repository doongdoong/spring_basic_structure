package com.ssafy.board.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.service.BoardService;
import com.ssafy.board.service.BoardServiceImpl;
import com.ssafy.board.vo.Board;

public class DetailBoardController implements Controller {
	private BoardService service;
	
	public DetailBoardController() {
		service = new BoardServiceImpl();
	}

	// 목록 페이지에 필요한 작업 진행
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 파라미터 추출
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 작업할 내용
		Board board = service.detail(no);
		
		ModelAndView mav = new ModelAndView("/board/detail.jsp");
		mav.addObject("board", board);
		
		return mav;
	}
}
