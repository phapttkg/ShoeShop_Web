package com.coeding.mvc.controller.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.UserDAO;
import com.coeding.mvc.vo.UserVO;

/**
 * Servlet implementation class LoginController
 */
@Component(value = "/user/login.do")
public class LoginController implements Controller, DataBinding {
	private UserDAO dao;

	public LoginController(UserDAO userDAO) {
		this.dao = userDAO;
	}

	public LoginController() {
		super();
	}

	public Controller setUserDao(UserDAO userDAO) {
		this.dao = userDAO;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) {
		UserVO user = (UserVO) model.get("user");
		if (user.getEmail() != null && user.getPasswd() != null) {
			return doPost(model);
		} else {
			return doGet(model);
		}
	}

	private String doGet(Map<String, Object> model) {
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		request.getSession().invalidate();
		return "/login.jsp";
	}

	private String doPost(Map<String, Object> model) {
		UserVO user = (UserVO) model.get("user");
		List<UserVO> list = dao.selectAll();
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		for (UserVO u : list) {
			if (user.getEmail().equals(u.getEmail()) && user.getPasswd().equals(u.getPasswd())) {
				System.out.println("login success!");
				HttpSession session = request.getSession();
				session.setAttribute("email", user.getEmail());
				session.setAttribute("auth", "ADMIN");
				return "redirect:"+request.getContextPath()+"/admin/home.do";
			}
		}
		return "redirect:"+request.getContextPath()+"/user/login.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "user", UserVO.class };
	}
}
