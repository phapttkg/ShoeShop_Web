package com.coeding.mvc.controller.color;

import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.ColorDAO;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.vo.BrandVO;
import com.coeding.mvc.vo.ColorVO;

@Component(value="/admin/color/list.do")
public class ColorListController implements Controller {
	
	private ColorDAO daoColor;
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		List<ColorVO> listColor = daoColor.selectAll();
		model.put("listColor", listColor);
		return "/color/listcolor.jsp";
	}

	

	public void setDaoColor(ColorDAO daoColor) {
		this.daoColor = daoColor;
	}

	
	
}
