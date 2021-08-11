package com.coeding.mvc.controller.user;

import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.UserDAO;
import com.coeding.mvc.vo.UserVO;

@Component("/user/join.do")
public class UserJoinController implements Controller, DataBinding {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;

	public UserJoinController(UserDAO dao) {
		this.dao = dao;
	}

	public UserJoinController() {
		super();
	}

	public Controller setUserDAO(UserDAO userDAO) {
		// TODO Auto-generated method stub
		this.dao = userDAO;
		return this;
	}

	protected String doPost(Map<String, Object> model) {
		// TODO save to DB getAttribute(); from other servlet
		List<UserVO> list = dao.selectAll();
		UserVO user = (UserVO) model.get("user");
		for (UserVO u : list) {
			if (user.getEmail().equals(u.getEmail())) {
				return "/jsp/user/form-new-1.jsp";
			}
		}
		dao.insert(user);
		// changed by client
		return "redirect:/3rdteam01/admin/user/list.do";
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		UserVO userVO = (UserVO) model.get("user");
		String viewUrl = "/jsp/user/form-new-1.jsp";
		if (userVO.getName() != null) {
			viewUrl = doPost(model);
		}
		return viewUrl;
	}

	@Override
	public Object[] getDataBinders() {
		// reflection : by self
		// need data, type ask to DispatcherServlet
		return new Object[] { "user", UserVO.class };
	}
}