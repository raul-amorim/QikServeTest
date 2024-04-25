package com.test.Principal;

import java.math.BigDecimal;
import java.math.RoundingMode;

import Model.CartItem;

public class Promotions {
	public BigDecimal QTY_BASED_PRICE_OVERRIDE(CartItem cartItem) {
		return (cartItem.getQtd() % 2 == 0 ? new BigDecimal(cartItem.getQtd()/2).multiply(cartItem.getProduct().getPromotion().get(0).getPrice()) : new BigDecimal(cartItem.getQtd()/2).multiply(cartItem.getProduct().getPromotion().get(0).getPrice()).add(cartItem.getProduct().getPrice())).divide(new BigDecimal(100)).setScale(2, RoundingMode.CEILING); 
	}

	public BigDecimal BUY_X_GET_Y_FREE(CartItem cartItem) {
		if (cartItem.getQtd() <= cartItem.getProduct().getPromotion().get(0).getRequiredQtd())
			return new BigDecimal(cartItem.getQtd()).multiply(cartItem.getProduct().getPrice()).divide(new BigDecimal(100)).setScale(2);
		int qtd = cartItem.getQtd();
		return new BigDecimal(qtd-(qtd/((cartItem.getProduct().getPromotion().get(0).getRequiredQtd() + cartItem.getProduct().getPromotion().get(0).getFreeQtd())))).multiply(cartItem.getProduct().getPrice()).divide(new BigDecimal(100)).setScale(2, RoundingMode.CEILING);
	}

	public BigDecimal FLAT_PERCENT(CartItem cartItem) {
		return (new BigDecimal(cartItem.getQtd()).multiply(cartItem.getProduct().getPrice()).multiply(new BigDecimal(100).subtract(cartItem.getProduct().getPromotion().get(0).getAmount()).divide(new BigDecimal(100)))).divide(new BigDecimal(100)).setScale(2,RoundingMode.CEILING);
	}
}
