package com.coeding.mvc.vo;

public class ProductVO {
	private long id;
	private String name;
	private String img;
	private double price;
	private int size;
	private long id_color;
	private long id_category;
	private long id_brand;
	private int amount;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getId_color() {
		return id_color;
	}

	public void setId_color(long id_color) {
		this.id_color = id_color;
	}

	public long getId_category() {
		return id_category;
	}

	public void setId_category(long id_category) {
		this.id_category = id_category;
	}

	public long getId_brand() {
		return id_brand;
	}

	public void setId_brand(long id_brand) {
		this.id_brand = id_brand;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
