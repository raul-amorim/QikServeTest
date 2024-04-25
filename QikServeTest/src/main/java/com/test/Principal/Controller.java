package com.test.Principal;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

import Model.Cart;
import Model.CartItem;
import Model.JsonBody;
import Model.Promotion;

public class Controller {

	final static Scanner SCAN = new Scanner(System.in);
	static List<JsonBody> products = null;
	static Cart cart = new Cart();

	public Controller() {
		products = DataGathering.getProducts();
	}

	public static void listItems() {
		int i = 0;
		for (JsonBody product : products) {
			i++;
			System.out.println(i + " -> " + product.getName() + " - $" + product.getPrice().divide(new BigDecimal(100)));
		}
	}

	public static void listCartItems() {
		int i = 0;
		for (CartItem cartItem : cart.getCart()) {
			i++;
			System.out.print(i + " -> " + cartItem.getQtd() + " - " + cartItem.getProduct().getName() + " - $"
					+ cartItem.getPrice());
			if (!cartItem.getSaved().equals(new BigDecimal(0))) {
				System.out.println(" (-$" + cartItem.getSaved() + ")");
			}
		}
		
		if(cart.getCart().size() == 0) {
			System.out.println("Your cart is empty!");
		}
	}

	public static void addItem() {
		listItems();
		System.out.println("0 - Return to MENU");
		System.out.println("Select an item to add to your cart");
		int op = 0;
		do {
			op = SCAN.nextInt();
			if (op == 0)
				return;
			else {
				System.out.println("How many?");
				int qtd = SCAN.nextInt();
				JsonBody product = products.get(op - 1);
				for (CartItem cartItem : cart.getCart()) {
					if (cartItem.getProduct().getName().equals(product.getName())) {
						cartItem.addQtd(qtd);
						activatePromotion(cartItem);
						return;
					}
				}
				CartItem newCartItem = new CartItem(qtd, product);
				activatePromotion(newCartItem);
				cart.addCartItem(newCartItem);
			}
		} while (op > products.size());
	}

	public static void removeItem() {
		if (cart.getCart().size() == 0) {
			System.out.println("You have no items in your cart!");
			return;
		}
		System.out.println("Select an item to remove:");
		int op = 99;
		while (op != 0) {
			listCartItems();
			System.out.println("0 -> Back to MENU");
			op = SCAN.nextInt();

			if (op == 0)
				return;

			System.out.println("How many to remove?");
			int qtdRemove = SCAN.nextInt();

			if (qtdRemove > cart.getCart().get(op - 1).getQtd()) {
				System.out.println("You don't have " + qtdRemove + " "
						+ cart.getCart().get(op - 1).getProduct().getName() + " in your cart.");
				System.out.println("Do you want to remove all " + cart.getCart().get(op - 1).getProduct().getName()
						+ " from your cart? (Y/N)");
				SCAN.nextLine();
				String removeAll = SCAN.nextLine();
				if (removeAll.equalsIgnoreCase("Y")) {
					qtdRemove = cart.getCart().get(op - 1).getQtd();
					cart.getCart().remove(op - 1);
					return;
				} else
					return;
			}
			if (qtdRemove == cart.getCart().get(op - 1).getQtd())
				cart.getCart().remove(op - 1);
			else
				cart.getCart().get(op - 1).setQtd(cart.getCart().get(op - 1).getQtd() - qtdRemove);

			return;
		}
	}

	public static void closeCart() {
		System.out.println("\nPurchase Details:");
		listCartItems();
		BigDecimal saved = new BigDecimal(0);
		for (CartItem item : cart.getCart())
			saved = saved.add(item.getSaved());
			
		System.out.println("\n\nYou saved: $" + saved);
	}
	
	private static void activatePromotion(CartItem cartItem) {
		if(cartItem.getProduct().getPromotion().size() > 0 && cartItem.getProduct().getPromotion().get(0).getId() != null) {
			String promotionType = cartItem.getProduct().getPromotion().get(0).getType();
			
			try {
				Method method = Promotions.class.getMethod(promotionType, CartItem.class);
				Promotions promotions = new Promotions();
				cartItem.setPrice((BigDecimal) method.invoke(promotions, cartItem));
			} catch (Exception e) {
				e.printStackTrace();
			}
			cartItem.setSaved(cartItem.getProduct().getPrice().multiply(new BigDecimal(cartItem.getQtd())).divide(new BigDecimal(100)).subtract(cartItem.getPrice()).setScale(2));
		} else {
			cartItem.setPrice(new BigDecimal(cartItem.getQtd()).multiply(cartItem.getProduct().getPrice()).divide(new BigDecimal(100)).setScale(2, RoundingMode.CEILING));
			cartItem.setSaved(new BigDecimal(0));
		}
	}
	
}
