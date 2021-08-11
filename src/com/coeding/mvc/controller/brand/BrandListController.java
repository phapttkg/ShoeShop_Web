package com.coeding.mvc.controller.brand;

import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.controller.Controller;
import com.coeding.mvc.dao.BrandDAO;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.vo.BrandVO;

@Component(value="/admin/brand/list.do")
public class BrandListController implements Controller {
	
	private BrandDAO daoBrand;
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		List<BrandVO> listBrand = daoBrand.selectAll();
		
		
		model.put("listBrand", listBrand);
		
		return "/brand/listbrand.jsp";
	}

	

	public void setDaoBrand(BrandDAO daoBrand) {
		this.daoBrand = daoBrand;
	}

	
	
}
