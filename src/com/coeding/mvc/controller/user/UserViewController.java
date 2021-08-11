package com.coeding.mvc.controller.user;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.UserDAO;
import com.coeding.mvc.vo.UserVO;

@Component("/admin/user/detail.do")
public class UserViewController implements Controller, DataBinding {
	private UserDAO dao;

	public Controller setUserDAO(UserDAO userDAO) {
		// TODO Auto-generated method stub
		this.dao = userDAO;
		return this;
	}
	public UserViewController(UserDAO userDAO) {
		this.dao = userDAO;
	}
	public  UserViewController() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String email = (String) model.get("email");
		UserVO vo = new UserVO();
		vo.setEmail(email);
		System.out.println(vo);
		UserVO user = dao.selectOne(vo);
		model.put("user", user);
		System.out.println(user.getName());
		return "/jsp/user/detail.jsp";
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
			"email", String.class
		};
	}
	

}
