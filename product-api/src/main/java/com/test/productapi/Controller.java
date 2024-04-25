package com.test.productapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Product;
import com.test.model.ProductDetail;
import com.test.model.Promotions;

@RestController
@RequestMapping("/products")
public class Controller {
	
	static List<Product> products;
	ProductDetail productDetails;
	
	@GetMapping({"", "/"})
	public List<Product> getProducts() {
		
		products = new ArrayList<Product>();
		
		products.add(new Product("Dwt5F7KAhi", "Amazing Pizza!", 1099));
		products.add(new Product("PWWe3w1SDU", "Amazing Burger!", 999));
		products.add(new Product("C8GDyLrHJb", "Amazing Salad!", 499));
		products.add(new Product("4MB7UfpTQs", "Boring Fries!", 199));
		
		return products;
	}
	
	@GetMapping("/{id}")
	public ProductDetail getProductbyID(@PathVariable("id") final String id){
		Promotions p = new Promotions();
		
		switch (id) {
		case "C8GDyLrHJb":
			p.saladPromotions("Gm1piPn7Fg", "FLAT_PERCENT", 10);
			productDetails = new ProductDetail("C8GDyLrHJb", "Amazing Salad!", 499, new ArrayList<Promotions>(List.of(p)));
			break;
		case "Dwt5F7KAhi":
			p.pizzaPromotions("ibt3EEYczW", "QTY_BASED_PRICE_OVERRIDE", 2, 1799);
			productDetails = new ProductDetail("Dwt5F7KAhi", "Amazing Pizza!", 1099, new ArrayList<Promotions>(List.of(p)));
			break;
		case "PWWe3w1SDU":
			p.burgerPromotions("ZRAwbsO2qM", "BUY_X_GET_Y_FREE", 2, 1);
			productDetails = new ProductDetail("PWWe3w1SDU", "Amazing Burger!", 999, new ArrayList<Promotions>(List.of(p)));
			break;
		case "4MB7UfpTQs":
			p = new Promotions();
			productDetails = new ProductDetail("4MB7UfpTQs", "Boring Fries!", 199, new ArrayList<Promotions>(List.of(p)));
			break;
		}
		return productDetails;
	}

}
