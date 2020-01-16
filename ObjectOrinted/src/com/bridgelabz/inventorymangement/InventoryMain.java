package com.bridgelabz.inventorymangement;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class InventoryMain {
	
	InventoryDAOImpl inventory = new InventoryDAOImpl();
	
	public void menu() throws IOException, ParseException {
		System.out.println("--------------------");
		System.out.println("enter the option.... ");
		System.out.println("1. add the details.. ");
		System.out.println("2. caluculation... ");
		System.out.println("3. exit..");
		System.out.println("please enter the option ");
		int option = inventory.scanner.nextInt();
		switch (option) {
		case 1:
			case1();
			menu();
			break;
		case 2:
			System.out.println("select the calculation choice ");
			System.out.println("1. rice calulation ");
			System.out.println("2. wheat calculation ");
			System.out.println("3. pulses calculation ");
			System.out.println("4. all ");
			int choice = inventory.scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("calulation for rice");
				System.out.println(inventory.readInventory("Rice"));
				break;
			case 2:
				System.out.println("calculation for wheat ");
				System.out.println(inventory.readInventory("wheat"));

				break;
			case 3:
				System.out.println("calculation for pulses ");
				System.out.println(inventory.readInventory("pulses"));

				break;
			case 4:
				System.out.println("calculation for all ");
				System.out.println(inventory.readInventory("All"));
				break;

			default:
				System.out.println("wrong choice");
				break;
			}
			break;
		default:
			System.out.println("enter choice 1-4 only");
			break;
		}

	}

	public void case1() {
		System.out.println("select the option for which type of product you want ");
		System.out.println(" 1. Rice ");
		System.out.println(" 2. Wheats ");
		System.out.println(" 3. pulses ");
		System.out.println("please enter the product choice ");
		int productOpt = inventory.scanner.nextInt();
		switch (productOpt) {
		case 1:
			System.out.println("add rice details ");
			inventory.addInventory("Rice");

			break;
		case 2:
			System.out.println("add wheat details ");
			inventory.addInventory("wheat");

			break;
		case 3:
			System.out.println("add pulses details ");
			inventory.addInventory("pulses");

			break;
		default:
			System.out.println("enter choice 1-3 only");
			break;

		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		InventoryMain menu = new InventoryMain();
		menu.menu();

	}

}
