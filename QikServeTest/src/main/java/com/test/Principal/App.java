package com.test.Principal;

import java.util.Scanner;

import Model.CartItem;

public class App {

	final static Scanner SCAN = new Scanner(System.in);
	final static Controller controller = new Controller();

	public static void main(String[] args) {
		int menu = 99;

		while (menu != 0) {

			System.out.println(
					"\n   MENU:\n" + "1 - Add item to cart\n" + "2 - See cart\n" + "3 - Remove item\n" + "0 - Finish shopping");
			menu = SCAN.nextInt();

			switch (menu) {
			case 1:
				controller.addItem();
				break;
			case 2:
				controller.listCartItems();
				break;
			case 3:
				controller.removeItem();
				break;
			case 0:
				controller.closeCart();
				break;
			default:
				System.out.println("Select a Valid Option\n\n");
				break;
			}
		}

	}

}