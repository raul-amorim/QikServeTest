package com.test.model;

public class Promotions {

	String id;
	String type;
	int amount;
	int requiredQtd;
	int price;
	int freeQtd;

	public void saladPromotions(String id, String type, int amount) {
		this.id = id;
		this.type = type;
		this.amount = amount;
	}

	public void pizzaPromotions(String id, String type, int requiredQtd, int price) {
		this.id = id;
		this.type = type;
		this.requiredQtd = requiredQtd;
		this.price = price;
	}

	public void burgerPromotions(String id, String type, int requiredQtd, int freeQtd) {
		this.id = id;
		this.type = type;
		this.requiredQtd = requiredQtd;
		this.freeQtd = freeQtd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRequiredQtd() {
		return requiredQtd;
	}

	public void setRequiredQtd(int requiredQtd) {
		this.requiredQtd = requiredQtd;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getFreeQtd() {
		return freeQtd;
	}

	public void setFreeQtd(int freeQtd) {
		this.freeQtd = freeQtd;
	}

}
