package com.coeding.mvc.controller;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.dao.MySQLBillDAO;
import com.coeding.mvc.dao.ProductDAO;
import com.coeding.mvc.vo.BillVO;
import com.coeding.mvc.vo.ProductVO;

@Component("/admin/bill/view.do")
public class BillDetailController implements Controller, DataBinding {
	private static final long serialVersionUID = 1L;
	private DAO dao;
	private ProductDAO pdao;
	private MySQLBillDAO bdao;
	
	
	
	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}
	
	public void setBdao(MySQLBillDAO bdao) {
		this.bdao = bdao;
	}


	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		BillVO bill = ((BillVO) model.get("bill"));
		bill = bdao.selectOne(bill);
		ProductVO product = new ProductVO();
		product.setId(bill.getPid());
		product = pdao.selectOne(product);
		model.put("bill", bill);
		model.put("product", product);
		return "/jsp/bill/detail.jsp";
	}
	public MySQLBillDAO getBdao() {
		return bdao;
	}


	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"bill", BillVO.class
		};
	}
}
