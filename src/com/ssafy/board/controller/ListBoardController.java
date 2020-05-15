package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.service.BoardService;
import com.ssafy.board.service.BoardServiceImpl;
import com.ssafy.board.vo.Board;

// 게시물 목록 조회
public class ListBoardController implements Controller {
	private BoardService service;
	
	public ListBoardController() {
		service = new BoardServiceImpl();
	}

	// 목록 페이지에 필요한 작업 진행
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 파라미터 추출
		
		// 작업할 내용
		List<Board> list = service.list();
		
		ModelAndView mav = new ModelAndView("/board/list.jsp");
		mav.addObject("list", list);
		
		// 페이지 이동
		return mav;
	}
}
