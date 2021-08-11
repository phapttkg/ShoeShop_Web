package com.coeding.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.dao.MySQLBillDAO;
import com.coeding.mvc.dao.ProductDAO;
import com.coeding.mvc.vo.BillVO;
import com.coeding.mvc.vo.ProductVO;

@Component("/admin/bill/edit.do")
public class BillEditController implements Controller, DataBinding{
	private static final long serialVersionUID = 1L;
	private DAO dao;
	private ProductDAO pdao;
	
	public Controller setBillDao(MySQLBillDAO billdao) {
		System.out.println(billdao + " injected into " +this);
		this.dao = billdao;
		return this;
	}
	
	protected String doGet(Map<String, Object> model) {
		// TODO select bill to edit
		BillVO bill = (BillVO) dao.selectOne((BillVO) model.get("bill"));
		List<ProductVO> productList = pdao.selectAll();
		String list = "";
		for(ProductVO product : productList) {
			list += product.getId()+",";
		}
		model.put("list", list);		
		model.put("bill", bill);
		
		return "/jsp/bill/form-edit.jsp";
	}

	protected String doPost(Map<String, Object> model) {
		// TODO update bill
		// data binding : from request to VO
		long bid = ((BillVO) model.get("bill")).getBid();// form input name
		String cname = ((BillVO) model.get("bill")).getcName();
		long pid = ((BillVO) model.get("bill")).getPid();
		int amount = ((BillVO) model.get("bill")).getAmount();
		
		BillVO bill = new BillVO();
		bill.setBid(bid);
		bill.setcName(cname);
		bill.setPid(pid);
		bill.setAmount(amount);
		dao.update(bill);

		return "redirect:/3rdteam01/admin/bill/list.do";
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"bill", BillVO.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String bid = Long.toString(((BillVO) model.get("bill")).getBid());
		String cname = ((BillVO) model.get("bill")).getcName();
		String viewUrl = "/jsp/bill/form-edit.jsp";
		if( cname == null || cname.isEmpty()) {
			if( bid != null && !bid.isEmpty()) {
				viewUrl = doGet(model);
			}
		}else {
			viewUrl = doPost(model);
		}
		return viewUrl;
	}
	public ProductDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}

	
}
