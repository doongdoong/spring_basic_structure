package org.springframework.web.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private URLHandlerMapping uhm;
	
	public void init(ServletConfig config) {
		uhm = new URLHandlerMapping();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI().substring(contextPath.length());
		
		System.out.println(requestURI);
		
		try {
			Controller control = uhm.getController(requestURI);
			
			if(control == null) {
				throw new ServletException("요청하신 URL이 존재하지 않습니다.");
			}
			
			ModelAndView mav = control.service(request, response);
			String view = mav.getViewName();
			
			// 페이지 주소가 바뀌어야 하기 떄문에 sendRedirect()로 가야한다.
			if(view.startsWith("redirect:")) {
				response.sendRedirect(view.substring("redirect:".length()));
			}
			else {
				// 화면에서 사용할 데이터 공유
				Map<String, Object> model = mav.getModel();
				Set<String> keys = model.keySet();
				
				for(String key : keys) {
					request.setAttribute(key, model.get(key));
				}
				
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}
}
