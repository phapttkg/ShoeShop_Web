package com.coeding.mvc.controller.category;

import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.CategoryDAO;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.vo.CategoryVO;

@Component(value="/admin/category/list.do")
public class CategoryListController implements Controller {
	
	private CategoryDAO daoCategory;
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		List<CategoryVO> listCategory = daoCategory.selectAll();
		
		
		model.put("listCategory", listCategory);
		
		return "/category/listcategory.jsp";
	}

	

	public void setDaoCategory(CategoryDAO daoCategory) {
		this.daoCategory = daoCategory;
	}

	
	
}
