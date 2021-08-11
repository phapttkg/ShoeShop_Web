package com.coeding.mvc.controller.color;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.ColorDAO;
import com.coeding.mvc.vo.BrandVO;
import com.coeding.mvc.vo.ColorVO;

@Component(value = "/admin/color/delete.do")
public class ColorDeleteController implements Controller, DataBinding {
	private ColorDAO dao;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return doGet(model);
	}

	private String doGet(Map<String, Object> model) {
		long id = (long) model.get("id");
		ColorVO vo = new ColorVO();
		vo.setId(id);
		ColorVO v = dao.selectOne(vo);
		dao.delete(v);
		return "redirect:/3rdteam01/admin/color/list.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "id", Long.class };
	}

	public void setDao(ColorDAO dao) {
		this.dao = dao;
	}
}
