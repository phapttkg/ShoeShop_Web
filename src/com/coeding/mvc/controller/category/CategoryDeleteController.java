package com.coeding.mvc.controller.category;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.CategoryDAO;
import com.coeding.mvc.vo.BrandVO;
import com.coeding.mvc.vo.CategoryVO;

@Component(value = "/admin/category/delete.do")
public class CategoryDeleteController implements Controller, DataBinding {
	private CategoryDAO dao;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return doGet(model);
	}

	private String doGet(Map<String, Object> model) {
		long id = (long) model.get("id");
		CategoryVO vo = new CategoryVO();
		vo.setId(id);
		CategoryVO v = dao.selectOne(vo);
		dao.delete(v);
		return "redirect:/3rdteam01/admin/category/list.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "id", Long.class };
	}

	public void setDao(CategoryDAO dao) {
		this.dao = dao;
	}
}
