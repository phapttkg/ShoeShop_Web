package com.coeding.mvc.vo;


public class BillVO {
	private long bid;
	private String cName;
	private long pid;
	private double uPrice;
	private int amount;
	private double totalPrice;
	
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public double getuPrice() {
		return uPrice;
	}
	public void setuPrice(double uPrice) {
		this.uPrice = uPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
