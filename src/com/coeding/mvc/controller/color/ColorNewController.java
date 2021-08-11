package com.coeding.mvc.controller.color;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

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

@Component(value = "/admin/color/new.do")
public class ColorNewController implements Controller, DataBinding {
	private ColorDAO daoColor;
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		ColorVO vo = (ColorVO) model.get("color");
		if (vo.getName() != null) {
			return doPost(model);
		}
		return doGet(model);
	}

	private String doGet(Map<String, Object> model) {
		return "/color/newcolor.jsp";
	}

	private String doPost(Map<String, Object> model) {
		ColorVO vo = (ColorVO) model.get("color");
		daoColor.insert(vo);
		return "redirect:/3rdteam01/admin/color/list.do";
	}


	public void setDaoColor(ColorDAO daoColor) {
		this.daoColor = daoColor;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "color", ColorVO.class };
	}

}
