package com.coeding.mvc.controller.user;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.UserDAO;
import com.coeding.mvc.vo.UserVO;

@Component("/admin/user/edit.do")
public class UserEditController implements Controller, DataBinding {
	private UserDAO dao;

	public Controller setUserDAO(UserDAO userDAO) {
		this.dao = userDAO;
		return this;
	}

	public UserEditController(UserDAO dao) {

		this.dao = dao;
	}

	public UserEditController() {
		super();
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		UserVO vo = (UserVO) model.get("user");
		System.out.println(vo.getName());
		if (vo.getName() != null) {

			return doPost(model);
		} else {
			return doGet(model);

		}

	}

	protected String doGet(Map<String, Object> model) {
		int uid = (int) model.get("uid");
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		UserVO userVO = dao.selectOne(vo);
		model.put("userVO", userVO);
		return "/jsp/user/form-edit.jsp";
	}

	protected String doPost(Map<String, Object> model) {
		UserVO vo = (UserVO) model.get("user");
		dao.update(vo);
		
		return "redirect:/3rdteam01/admin/user/view.do?uid=" + vo.getUid();

	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] { "uid", Integer.class, "user", UserVO.class };
	}
}