package com.coeding.mvc.controller.product;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.CategoryDAO;
import com.coeding.mvc.dao.ColorDAO;
import com.coeding.mvc.dao.ProductDAO;
import com.coeding.mvc.vo.BrandVO;
import com.coeding.mvc.vo.CategoryVO;
import com.coeding.mvc.vo.ColorVO;
import com.coeding.mvc.vo.ProductVO;

@Component(value = "/admin/product/view.do")
public class ProductDetailController implements Controller, DataBinding {
	private ProductDAO dao;
	private BrandDAO daoBrand;
	private ColorDAO daoColor;
	private CategoryDAO daoCategory;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return doGet(model);
	}

	private String doGet(Map<String, Object> model) {
		long id = (long) model.get("id");
		ProductVO vo = new ProductVO();
		vo.setId(id);
		ProductVO result = dao.selectOne(vo);
		model.put("product", result);
		
		BrandVO b = new BrandVO();
		b.setId(result.getId_brand());
		BrandVO b1 = daoBrand.selectOne(b);
		model.put("brand", b1);
		
		ColorVO c = new ColorVO();
		c.setId(result.getId_color());
		ColorVO c1 = daoColor.selectOne(c);
		model.put("color", c1);
		
		CategoryVO ca = new CategoryVO();
		ca.setId(result.getId_category());
		CategoryVO ca1 = daoCategory.selectOne(ca);
		model.put("category", ca1);
		model.put("image", result.getImg());
		return "/product/product-detail.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "id", Long.class };
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
