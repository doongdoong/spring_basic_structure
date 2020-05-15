package org.springframework.web.servlet;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	// 뷰 관리
	private String viewName;
	
	// 모델 - 공유할 데이터 관리
	private Map<String, Object> model = new HashMap<>();
	
	public ModelAndView() {}
	
	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}
	
	public void addObject(String key, Object value) {
		model.put(key, value);
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
}
