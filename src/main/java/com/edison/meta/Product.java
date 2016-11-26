package com.edison.meta;

import org.apache.ibatis.type.Alias;

@Alias(value="content")
public class Product {
	private int id;
	private String title;
	private String image;
	private double price;
	private String detail;
	private boolean isBuy;
	private boolean isSell;
	private String summary;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getIsBuy() {
		return isBuy;
	}

	public void setIsBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}

	public boolean getIsSell() {
		return isSell;
	}

	public void setIsSell(boolean isSell) {
		this.isSell = isSell;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

		

	
}
