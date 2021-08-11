package com.coeding.mvc.controller.color;

import java.util.HashMap;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.ColorDAO;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.vo.BrandVO;
import com.coeding.mvc.vo.ColorVO;

@Component("/admin/color/edit.do")
public class ColorEditController implements Controller, DataBinding{
	private static final long serialVersionUID = 1L;
	private DAO dao;
	
	public Controller setBillDao(ColorDAO colordao) {
		System.out.println(colordao + " injected into " +this);
		this.dao = colordao;
		return this;
	}
	
	protected String doGet(Map<String, Object> model) {
		// TODO select bill to edit
		ColorVO color = (ColorVO) dao.selectOne((ColorVO) model.get("color"));//<<<<
		model.put("color", color);
		return "/color/editcolor.jsp";
	}

	protected String doPost(Map<String, Object> model) {
		// TODO update bill
		// data binding : from request to VO
		long id = ((ColorVO) model.get("color")).getId();// form input name
		String name = ((ColorVO) model.get("color")).getName();
		
		
		ColorVO color = new ColorVO();
		color.setId(id);
		color.setName(name);
		dao.update(color);

		return "redirect:/3rdteam01/admin/color/list.do";
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"color", ColorVO.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String id = Long.toString(((ColorVO) model.get("color")).getId());
		String name = ((ColorVO) model.get("color")).getName();
		String viewUrl = "/color/editcolor.jsp";
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
