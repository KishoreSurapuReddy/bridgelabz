/*Purpose:Stock management system is used to add the stock details and in this
 * we also performed updating stock and creating customer account which 
 * having details of customer and stock details
 * @author bridgelabsz
 * @version 1.0
 * @since 16/01/2020
 * @file StockManagementMain.java
 */
package com.bridgelabz.stockmanagement;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class StockManagementMain {
	static StockManagementDAOImpl stock = new StockManagementDAOImpl();

	public void stock() throws IOException, ParseException {
		System.out.println("--------------------");
		System.out.println("  STOCK MANAGEMENT  ");
		System.out.println("  1.add stock       ");
		System.out.println("  2.view stock      ");
		System.out.println("  3.view all stocks ");
		System.out.println("  4.delete stock    ");
		System.out.println("  5.update stock    ");
		System.out.println("  6.back            ");
		System.out.println("enter the choice");
		int choice = stock.scanner.nextInt();
		switch (choice) {
		case 1:
			StockManagement stockdata = new StockManagement();
			try {
				System.out.println("enter the name of stock :");
				stockdata.setStockName(stock.scanner.next());
			} catch (Exception e) {
				System.out.println("enter string data only...");
			}
			try {
				System.out.println("enter the number of shares :");
				stockdata.setNumberOfShares(stock.scanner.nextInt());
				System.out.println("enter the price of each share :");
				stockdata.setSharePrice(stock.scanner.nextDouble());
			} catch (Exception e) {
				System.out.println("enter correct type of data..");
			}
			stock.addStock(stockdata);
			stock();
			break;
		case 2:
			try {
				System.out.println("enter the stock name :");
				String name = stock.scanner.next();
				stock.viewStock(name);
			} catch (Exception e) {
				System.out.println("enter string data onlt...");
			}
			stock();
			break;
		case 3:
			stock.viewAllStocks();
			stock();
			break;
		case 4:
			try {
				System.out.println("enter the stock name to delete ");
				String deletename = stock.scanner.next();
				stock.deleteStock(deletename);
			} catch (Exception e) {
				System.out.println("enter string data only...");
			}
			stock();
			break;
		case 5:
			try {
				System.out.println("enter the name stock to update ");
				String update = stock.scanner.next();
				stock.updateStock(update);
			} catch (Exception e) {
				System.out.println("enter string data only...");
			}
			stock();
			break;
		case 6:
			menu();
			break;
		default:
			System.out.println("enter the range between 1-6 only");

		}
	}

	public void customer() throws IOException, ParseException {

		System.out.println("--------------------");
		System.out.println("  CUSTOMER MANAGEMENT  ");
		System.out.println("  1.Add customer       ");
		System.out.println("  2.View customer      ");
		System.out.println("  3.Calculate stock    ");
		System.out.println("  4.Buy share          ");
		System.out.println("  5.Sell share         ");
		System.out.println("  6.Save file          ");
		System.out.println("  7.Back");
		System.out.println("enter the choice");
		int choice = stock.scanner.nextInt();
		switch (choice) {
		case 1:
			int[] shares = new int[2];
			String[] stocks = new String[2];
			double[] value = new double[2];
			CustomerStockAccount customer = new CustomerStockAccount();
			try {
				System.out.println("enter customer name :");
				customer.setCustomerName(stock.scanner.next());
				System.out.println("enter customer id:");
				customer.setCustomerId(stock.scanner.nextInt());
				System.out.println("enter the names of stocks :");
				for (int index = 0; index < shares.length; index++) {
					stocks[index] = stock.scanner.next();
				}
				customer.setStockName(stocks);
				System.out.println("enter the number of shares :");
				for (int index = 0; index < shares.length; index++) {
					shares[index] = stock.scanner.nextInt();
				}
				customer.setNumberOfShares(shares);
				System.out.println("enter the value of share :");
				for (int index = 0; index < shares.length; index++) {
					value[index] = stock.scanner.nextDouble();
				}
			} catch (Exception e) {
				System.out.println("enter correct type of data only...");
			}
			customer.setShareValue(value);
			customer.toString();
			stock.stockAccount(customer);
			customer();
			break;
		case 2:
			try {
				System.out.println("enter customer name :");
				String name = stock.scanner.next();
				stock.printReport(name);
			} catch (Exception e) {
				System.out.println("enter string data only..");
			}
			customer();
			break;
		case 3:
			try {
				System.out.println("enter customer name :");
				String customername = stock.scanner.next();
				int[] result = stock.valueOfAccount(customername);
				for (int index = 0; index < result.length; index++) {
					System.out.println(result[index]);
				}
			} catch (Exception e) {
				System.out.println("enter string data only...");
			}
			customer();
			break;
		case 4:
			try {
				System.out.println("enter stock name :");
				String sellname = stock.scanner.next();
				System.out.println("enter amount :");
				int sellamount = stock.scanner.nextInt();
				stock.buyShare(sellamount, sellname);
			} catch (Exception e) {
				System.out.println("enter correct data...");
			}
			customer();
			break;
		case 5:
			try {
				System.out.println("enter stock name :");
				String stockname = stock.scanner.next();
				System.out.println("enter amount :");
				int amount = stock.scanner.nextInt();
				stock.sellShare(amount, stockname);
			} catch (Exception e) {
				System.out.println("enter correct type of data...");
			}
			customer();
			break;
		case 6:
			try {
				System.out.println("enter file name :");
				String file = stock.scanner.next();
				stock.saveFile(file);
			} catch (Exception e) {
				System.out.println("enter string type of data...");
			}
			customer();
			break;
		case 7:
			menu();
			break;
		default:
			System.out.println("enter range between 1-8 only...");
		}

	}

	public void menu() throws IOException, ParseException {

		System.out.println("-------------------------");
		System.out.println("    STOCK MANAGEMENT     ");
		System.out.println("    1.Stock management   ");
		System.out.println("    2.customer management");
		System.out.println("    3.Exit               ");
		System.out.println("enter choice :");
		int choiceof = stock.scanner.nextInt();
		switch (choiceof) {
		case 1:
			stock();
			break;
		case 2:
			customer();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("enter choice between 1-3 only...");

		}

	}

	public static void main(String[] args) throws IOException, ParseException {
		StockManagementMain stockmain = new StockManagementMain();
		stockmain.menu();
	}

}
