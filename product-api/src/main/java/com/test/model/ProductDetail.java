package com.test.model;

import java.util.List;

public class ProductDetail {

	String id;
	String name;
	int price;
	List<Promotions> promotions;

	public ProductDetail(String id, String name, int price, List<Promotions> promotions) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.promotions = promotions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Promotions> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotions> promotions) {
		this.promotions = promotions;
	}

}
