package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<CartItem> cart;
	
	public Cart() {
		super();
		cart = new ArrayList<>();
	}
	
	public void addCartItem(CartItem cartItem) {
		this.cart.add(cartItem);
	}
	
	public List<CartItem> getCart() {
		return cart;
	}

	public void setCart(List<CartItem> cart) {
		this.cart = cart;
	}

}
