package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonBody {

	String id;
	String name;
	BigDecimal price;
	@JsonIgnoreProperties
	@JsonProperty("promotions")
	List<Promotion> promotion;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Promotion> getPromotion() {
		if (promotion == null) {
			return promotion = new ArrayList<Promotion>();
		}
		return promotion;
	}

	public void setPromotion(List<Promotion> promotion) {
		this.promotion = promotion;
	}

}
