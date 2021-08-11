package com.coeding.mvc.controller.category;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.CategoryDAO;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.vo.BrandVO;
import com.coeding.mvc.vo.CategoryVO;

@Component(value = "/admin/category/new.do")
public class CategoryNewController implements Controller, DataBinding {
	private CategoryDAO daoCategory;
//	public CategoryNewController(DAO dao) {
//		this.dao = dao;
//	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		CategoryVO vo = (CategoryVO) model.get("category");
		if (vo.getName() != null) {
			return doPost(model);
		}
		return doGet(model);
	}

	private String doGet(Map<String, Object> model) {
		return "/category/newcategory.jsp";
	}

	private String doPost(Map<String, Object> model) {
		CategoryVO vo = (CategoryVO) model.get("category");
		daoCategory.insert(vo);
		return "redirect:/3rdteam01/admin/category/list.do";
	}


	public void setDaoCategory(CategoryDAO daoCategory) {
		this.daoCategory = daoCategory;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "category", CategoryVO.class };
	}

	
	
}
