package com.coeding.mvc.controller.brand;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.vo.BrandVO;

@Component(value = "/admin/brand/delete.do")
public class BrandDeleteController implements Controller, DataBinding {
	private BrandDAO dao;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return doGet(model);
	}

	private String doGet(Map<String, Object> model) {
		long id = (long) model.get("id");
		BrandVO vo = new BrandVO();
		vo.setId(id);
		BrandVO v = dao.selectOne(vo);
		dao.delete(v);
		return "redirect:/3rdteam01/admin/brand/list.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "id", Long.class };
	}

	public void setDao(BrandDAO dao) {
		this.dao = dao;
	}
}
