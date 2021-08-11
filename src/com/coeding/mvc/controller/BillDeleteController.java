package com.coeding.mvc.controller;

import java.util.Map;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.bind.DataBinding;
import com.coeding.mvc.dao.DAO;
import com.coeding.mvc.dao.MySQLBillDAO;
import com.coeding.mvc.vo.BillVO;

@Component(value="/admin/bill/delete.do")
public class BillDeleteController implements Controller, DataBinding{
	private static final long serialVersionUID = 1L;
	private MySQLBillDAO dao;
	
//	public Controller setBillDao(DAO billdao) {
//		System.out.println(billdao + " injected into " +this);
//		this.dao = billdao;
//		return this;
//	}
	
	protected String doPost(Map<String, Object> model) {
		long bid = ((BillVO) model.get("bill")).getBid();// form input name
		
		BillVO bill = new BillVO();
		bill.setBid(bid);
		dao.delete(bill);

		return "redirect:/3rdteam01/admin/bill/list.do";
	}
	
	public void setDao(MySQLBillDAO dao) {
		this.dao = dao;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		String bid = Long.toString(((BillVO) model.get("bill")).getBid());
		if ( bid != null && !bid.isEmpty()) {
			return doPost(model);
		}
		
		return "redirect:/3rdteam01/admin/bill/list.do";
	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"bill", BillVO.class
		};
	}
	
}
