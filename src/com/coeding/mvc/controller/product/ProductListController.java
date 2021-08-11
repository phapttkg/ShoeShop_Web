package com.coeding.mvc.controller.product;

import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.CategoryDAO;
import com.coeding.mvc.dao.ColorDAO;
import com.coeding.mvc.dao.ProductDAO;
import com.coeding.mvc.vo.BrandVO;
import com.coeding.mvc.vo.CategoryVO;
import com.coeding.mvc.vo.ColorVO;
import com.coeding.mvc.vo.ProductVO;

@Component(value = "/admin/product/list.do")
public class ProductListController implements Controller {
	private ProductDAO dao;
	private BrandDAO daoBrand;
	private ColorDAO daoColor;
	private CategoryDAO daoCategory;
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		List<ProductVO> list = dao.selectAll();
		List<BrandVO> listBrand = daoBrand.selectAll();
		List<ColorVO> listColor = daoColor.selectAll();
		List<CategoryVO> listCategory = daoCategory.selectAll();
		model.put("listProduct", list);
		model.put("listBrand", listBrand);
		model.put("listColor", listColor);
		model.put("listCategory", listCategory);
		return "/product/product-list.jsp";
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	public void setDaoBrand(BrandDAO daoBrand) {
		this.daoBrand = daoBrand;
	}

	public void setDaoColor(ColorDAO daoColor) {
		this.daoColor = daoColor;
	}

	public void setDaoCategory(CategoryDAO daoCategory) {
		this.daoCategory = daoCategory;
	}
	
}
