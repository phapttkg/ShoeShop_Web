package com.coeding.mvc.controller;

import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.dao.MySQLBillDAO;
import com.coeding.mvc.dao.ProductDAO;
import com.coeding.mvc.vo.BillVO;
import com.coeding.mvc.vo.ProductVO;

@Component("/admin/bill/new.do")
public class BillNewController implements Controller, DataBinding {
	private static final long serialVersionUID = 1L;
	private MySQLBillDAO dao;
	private ProductDAO pdao;
//	public BillNewController(DAO dao) {
//		this.dao = dao;
//	}
	
	public BillNewController() {
		super();
	}
	
	
	
	protected String doGet(Map<String, Object> model) {
		List<ProductVO> productList = pdao.selectAll();
		String list = "";
		for(ProductVO product : productList) {
			list += product.getId()+",";
		}
		System.out.println(list);
		model.put("list", list);
		return "/jsp/bill/form-new.jsp";
	}
	
	public Controller setDao(MySQLBillDAO billdao) {
		System.out.println(billdao + " injected into " +this);
		this.dao = billdao;
		return this;
	}
	
	protected String doPost(Map<String, Object> model) {
		BillVO bill = (BillVO)model.get("bill");
		try {
			dao.insert(bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/3rdteam01/admin/bill/list.do";
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String viewUrl = "/jsp/bill/form-new.jsp";
		String pid = Long.toString(((BillVO) model.get("bill")).getPid());
		if ( pid == null || !pid.isEmpty()) {
			viewUrl = doGet(model);
		}
		if( ((BillVO) model.get("bill")).getcName() != null) {
			viewUrl = doPost(model);
		}
		return viewUrl;
	}
	

	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"bill", BillVO.class
		};
	}
	
	
}
