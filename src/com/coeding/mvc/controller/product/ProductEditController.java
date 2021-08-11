package com.coeding.mvc.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
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

@Component(value = "/admin/product/edit.do")
public class ProductEditController implements Controller, DataBinding {
	private ProductDAO dao;
	private BrandDAO daoBrand;
	private ColorDAO daoColor;
	private CategoryDAO daoCategory;

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		ProductVO vo = (ProductVO) model.get("product");
		if (vo.getName() != null) {
			return doPost(model);
		}
		return doGet(model);
	}

	private String doGet(Map<String, Object> model) {
		long id = (long) model.get("id");
		ProductVO vo = new ProductVO();
		vo.setId(id);
		ProductVO result = dao.selectOne(vo);
		model.put("product", result);

		List<BrandVO> listBrand = daoBrand.selectAll();
		List<ColorVO> listColor = daoColor.selectAll();
		List<CategoryVO> listCategory = daoCategory.selectAll();

		model.put("listBrand", listBrand);
		model.put("listColor", listColor);
		model.put("listCategory", listCategory);
		model.put("image", result.getImg());
		return "/product/product-edit.jsp";
	}

	private String doPost(Map<String, Object> model) {
		Collection<Part> parts = (Collection<Part>) model.get("parts");
		String fileName = "";
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		ServletContext ctx = request.getServletContext();
		String uploadpath = ctx.getRealPath(ctx.getInitParameter("uploadDir"));
		String filepath = "";
		for (Part part : parts) {
			if (part.getContentType() != null) {
				// has file data
				String name = part.getName();// <input type="file" name="">
				System.out.println(name);
				fileName = part.getSubmittedFileName();// upload file's name
				// upload/date/time/
				System.out.println(fileName);
				// save into server path have to be realPath
				filepath = uploadpath + File.separator + fileName;
				try {
					part.write(filepath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		long id = Long.parseLong(request.getParameter("id"));
		String img = "/uploads/" + fileName;
		ProductVO vo = (ProductVO) model.get("product");
		vo.setImg(img);
		dao.update(vo);
		return "redirect:/3rdteam01/admin/product/view.do?id="+vo.getId();
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "id", Long.class, "product", ProductVO.class };
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
