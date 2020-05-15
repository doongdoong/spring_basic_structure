package org.springframework.web.servlet;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.board.controller.DeleteBoardController;
import com.ssafy.board.controller.DetailBoardController;
import com.ssafy.board.controller.ListBoardController;

public class URLHandlerMapping {
	Map<String, Controller> mapping = new HashMap<>();
	
	public URLHandlerMapping() {
		mapping.put("/board/list.do", new ListBoardController());
		mapping.put("/board/detail.do", new DetailBoardController());
		mapping.put("/board/delete.do", new DeleteBoardController());
	}
	
	public Controller getController(String uri) {
		return mapping.get(uri);
	}
}
