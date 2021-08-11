package com.coeding.mvc.controller.brand;

import java.util.HashMap;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.vo.BrandVO;

@Component("/admin/brand/edit.do")
public class BrandEditController implements Controller, DataBinding{
	private static final long serialVersionUID = 1L;
	private DAO dao;
	
	public Controller setBillDao(BrandDAO branddao) {
		System.out.println(branddao + " injected into " +this);
		this.dao = branddao;
		return this;
	}
	
	protected String doGet(Map<String, Object> model) {
		// TODO select bill to edit
		BrandVO brand = (BrandVO) dao.selectOne((BrandVO) model.get("brand"));//<<<<
		model.put("brand", brand);
		return "/brand/editbrand.jsp";
	}

	protected String doPost(Map<String, Object> model) {
		// TODO update bill
		// data binding : from request to VO
		long id = ((BrandVO) model.get("brand")).getId();// form input name
		String name = ((BrandVO) model.get("brand")).getName();
		
		
		BrandVO brand = new BrandVO();
		brand.setId(id);
		brand.setName(name);
		dao.update(brand);

		return "redirect:/3rdteam01/admin/brand/list.do";
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"brand", BrandVO.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String id = Long.toString(((BrandVO) model.get("brand")).getId());
		String name = ((BrandVO) model.get("brand")).getName();
		String viewUrl = "/brand/editbrand.jsp";
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
