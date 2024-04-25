package Model;

import java.math.BigDecimal;

public class CartItem {

	int qtd;
	JsonBody product;
	BigDecimal price;
	BigDecimal saved;

	public CartItem(int qtd, JsonBody product) {
		super();
		this.qtd = qtd;
		this.product = product;
		this.price = new BigDecimal(0);
		this.saved = new BigDecimal(0);
	}

	public void addQtd(int qtd) {
		this.qtd += qtd;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public JsonBody getProduct() {
		return product;
	}

	public void setProduct(JsonBody product) {
		this.product = product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSaved() {
		return saved;
	}

	public void setSaved(BigDecimal saved) {
		this.saved = saved;
	}

}
