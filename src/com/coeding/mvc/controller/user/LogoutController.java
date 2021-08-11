package com.coeding.mvc.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.controller.Controller;

@Component(value = "/user/logout.do")
public class LogoutController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		request.getSession().invalidate();
		return "redirect:/3rdteam01/user/login.do";
	}

}
