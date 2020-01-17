/*Purpose:Inventory management is used to add the products into the file and 
 * we can also perform operation like calculating the total value of product
 * @author kishorereddy
*/
package com.bridgelabz.inventorymangement;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class InventoryMain {

	InventoryDAOImpl inventory = new InventoryDAOImpl();

	public void menu() throws IOException {
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
			case2();
			menu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("enter choice 1-3 only");
			break;
		}

	}

	public void case2() throws IOException {

		System.out.println("select the calculation choice ");
		System.out.println("1. rice calulation ");
		System.out.println("2. wheat calculation ");
		System.out.println("3. pulses calculation ");
		System.out.println("4. all ");
		int choice = inventory.scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("calulation for rice");
			try {
				System.out.println(inventory.readInventory("Rice"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("calculation for wheat ");
			try {
				System.out.println(inventory.readInventory("wheat"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 3:
			System.out.println("calculation for pulses ");
			try {
				System.out.println(inventory.readInventory("pulses"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 4:
			System.out.println("calculation for all ");
			try {
				System.out.println(inventory.readInventory("All"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("wrong choice");
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
