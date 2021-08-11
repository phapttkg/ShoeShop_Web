package com.coeding.mvc.controller.category;

import java.util.HashMap;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.CategoryDAO;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.vo.CategoryVO;

@Component("/admin/category/edit.do")
public class CategoryEditController implements Controller, DataBinding{
	private static final long serialVersionUID = 1L;
	private DAO dao;
	
	public Controller setBillDao(CategoryDAO categorydao) {
		System.out.println(categorydao + " injected into " +this);
		this.dao = categorydao;
		return this;
	}
	
	protected String doGet(Map<String, Object> model) {
		// TODO select bill to edit
		CategoryVO category = (CategoryVO) dao.selectOne((CategoryVO) model.get("category"));//<<<<
		model.put("category", category);
		return "/category/editcategory.jsp";
	}

	protected String doPost(Map<String, Object> model) {
		// TODO update bill
		// data binding : from request to VO
		long id = ((CategoryVO) model.get("category")).getId();// form input name
		String name = ((CategoryVO) model.get("category")).getName();
		
		
		CategoryVO category = new CategoryVO();
		category.setId(id);
		category.setName(name);
		dao.update(category);

		return "redirect:/3rdteam01/admin/category/list.do";
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"category", CategoryVO.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String id = Long.toString(((CategoryVO) model.get("category")).getId());
		String name = ((CategoryVO) model.get("category")).getName();
		String viewUrl = "/category/editcategory.jsp";
		if( name == null || name.isEmpty()) {
			if( id != null && !id.isEmpty()) {
				viewUrl = doGet(model);
			}
		}else {
			viewUrl = doPost(model);
		}
		return viewUrl;
	}
}
