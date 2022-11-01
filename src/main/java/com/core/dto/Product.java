package com.core.dto;

public class Product {
	private int itemId;
	private String productName;
	
	
	public Product(int itemId, String productName) {
		super();
		this.itemId = itemId;
		this.productName = productName;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getProductname() {
		return productName;
	}
	public void getProductname(String productName) {
		this.productName = productName;
	}
	
	
}
