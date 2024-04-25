package Model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Promotion {

	@JsonIgnoreProperties
	String id;
	String type;
	
	@JsonIgnoreProperties
	int requiredQtd;
	
	@JsonIgnoreProperties
	int freeQtd;
	
	@JsonIgnoreProperties
	BigDecimal amount;
	
	@JsonIgnoreProperties
	BigDecimal price;

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

	public int getRequiredQtd() {
		return requiredQtd;
	}

	public void setRequiredQtd(int requiredQtd) {
		this.requiredQtd = requiredQtd;
	}

	public int getFreeQtd() {
		return freeQtd;
	}

	public void setFreeQtd(int freeQtd) {
		this.freeQtd = freeQtd;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		if (price == null) {
			price = new BigDecimal(0);
		}
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
