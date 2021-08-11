package com.coeding.mvc.controller.user;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.UserDAO;
import com.coeding.mvc.vo.UserVO;

@Component("/admin/user/delete.do")
public class UserDeleteController implements Controller, DataBinding {
	private UserDAO dao;

	public Controller setUserDAO(UserDAO userDAO) {
		this.dao = userDAO;
		return this;

	}

	public UserDeleteController(UserDAO dao) {
		this.dao = dao;
	}

	public UserDeleteController() {
		super();
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return doGet(model);
	}

	protected String doGet(Map<String, Object> model) {

		int uid = (int) model.get("uid");
		UserVO vo = new UserVO();
		vo.setUid(uid);
		dao.delete(vo);
		return "redirect:/3rdteam01/admin/product/list.do";

	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "uid", Integer.class };
	}

}
