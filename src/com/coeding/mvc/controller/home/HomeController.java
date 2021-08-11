package com.coeding.mvc.controller.home;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.controller.Controller;

@Component(value = "/admin/home.do")
public class HomeController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return "/index.jsp";
	}

}
