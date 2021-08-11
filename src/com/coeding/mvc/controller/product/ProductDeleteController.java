package com.coeding.mvc.controller.product;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.ProductDAO;
import com.coeding.mvc.vo.ProductVO;

@Component(value = "/admin/product/delete.do")
public class ProductDeleteController implements Controller, DataBinding {
	private ProductDAO dao;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return doGet(model);
	}

	private String doGet(Map<String, Object> model) {
		long id = (long) model.get("id");
		ProductVO vo = new ProductVO();
		vo.setId(id);
		dao.delete(vo);
		return "redirect:/3rdteam01/admin/product/list.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "id", Long.class };
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

}
