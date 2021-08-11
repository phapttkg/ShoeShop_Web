package com.coeding.mvc.controller;

import java.util.List;
import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.dao.MySQLBillDAO;
import com.coeding.mvc.vo.BillVO;

@Component(value="/admin/bill/list.do")
public class BillListController implements Controller {
	private static final long serialVersionUID = 1L;
	private MySQLBillDAO dao;
	
//	public Controller setBillDao(MySQLBillDAO billdao) {
//		System.out.println(billdao + " injected into " +this);
//		this.dao = billdao;
//		return this;
//	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		List<BillVO> list = dao.selectAll();
		model.put("billList", list);
		return "/jsp/bill/list.jsp";
	}

	public void setDao(MySQLBillDAO dao) {
		this.dao = dao;
	}
	
}
