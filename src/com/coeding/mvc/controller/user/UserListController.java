package com.coeding.mvc.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.UserDAO;
import com.coeding.mvc.vo.UserVO;

@Component(value = "/admin/user/list.do")
public class UserListController implements Controller {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;

	
	public UserListController(UserDAO userDAO) {
		this.dao = userDAO;
	}
	public UserListController() {
		super();
	}

	public Controller setUserDao(UserDAO userDAO) {
		this.dao = userDAO;
		return this;
	}


	@Override
	public String execute(Map<String, Object> model) throws Exception {
		List<UserVO> list = dao.selectAll();
		model.put("userList", list);
		return "/jsp/user/listuser.jsp";
	}

	

}
