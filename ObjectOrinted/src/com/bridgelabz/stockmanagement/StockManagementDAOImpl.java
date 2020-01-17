package com.bridgelabz.stockmanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockManagementDAOImpl implements StockManagementDAO {
	Scanner scanner = new Scanner(System.in);
	List<String> stocks = new ArrayList<String>();
	/*
	 * function to implement adding Stock to file
	 */
	@Override
	public void addStock() throws IOException, ParseException {
		StockManagement stock = new StockManagement();
		System.out.println("enter the name of stock :");
		stock.setStockName(scanner.next());
		System.out.println("enter the number of shares :");
		stock.setNumberOfShares(scanner.nextInt());
		System.out.println("enter the price of each share :");
		stock.setSharePrice(scanner.nextDouble());
		writeIntoFile(stock.getStockName(), stock.getNumberOfShares(), stock.getSharePrice());

	}
	/*
	 * function to implement view stock
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void viewStock(String stockName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/stocks.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			JSONArray array = (JSONArray) jsonobject.get(stockName);
			if (array != null) {
				Iterator iterator = array.iterator();
				while (iterator.hasNext()) {
					JSONObject data = (JSONObject) iterator.next();
					data.forEach((key, value) -> System.out.println(key + "  " + value));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement viewall stocks
	 */
	@Override
	public void viewAllStocks() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/stocks.json");
			Object object = parser.parse(file);
			JSONObject json = (JSONObject) object;
			System.out.println(json);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement update stock
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void updateStock(String stockName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/stocks.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			if (jsonobject.get(stockName) != null) {
				JSONArray array = (JSONArray) jsonobject.get(stockName);
				JSONObject data = (JSONObject) array.get(0);
				data.forEach((key, value) -> {
					if (!key.equals(stockName)) {
						System.out.println(key + "\t\t" + value);
						System.out.println("enter 1 to edit the content ");
						int num = scanner.nextInt();
						if (num == 1) {
							System.out.println("enter the details ");
							if (key.equals("numberOfShares")) {
								data.put(key, scanner.nextInt());
							} else if (key.equals("sharePrice")) {
								data.put(key, scanner.nextDouble());
							} else {
								data.put(key, scanner.next());
							}
						}
					}
				});
				System.out.println("after updating ");
				data.forEach((key, value) -> System.out.println(key + "\t\t" + value));
				FileWriter filewriter = new FileWriter("/home/bridgelabsz/Desktop/stocks.json");
				filewriter.write(data.toJSONString());
				filewriter.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement delete stock
	 */
	@Override
	public void deleteStock(String stockName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/stocks.json");
			Object object = parser.parse(file);
			JSONObject json = (JSONObject) object;
			json.get(stockName);
			json.remove(stockName);
			FileWriter filewriter = new FileWriter("/home/bridgelabsz/Desktop/stocks.json");
			filewriter.write(json.toJSONString());
			filewriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement adding stock to file
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void writeIntoFile(String stockName, int numberOfShares, double sharePrice)
			throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/stocks.json");
			Object object = parser.parse(file);
			JSONObject json = (JSONObject) object;
			JSONArray array = new JSONArray();
			JSONObject jsonob = new JSONObject();
			jsonob.put("stockName", stockName);
			jsonob.put("numberOfShares", numberOfShares);
			jsonob.put("sharePrice", sharePrice);
			array.add(jsonob);
			System.out.println(array);
			json.put(stockName, array);
			FileWriter writer = new FileWriter("/home/bridgelabsz/Desktop/stocks.json");
			writer.write(json.toJSONString());
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement adding customer account details 
	 */
	@Override
	public void stockAccount() throws IOException, ParseException {
		int[] shares = new int[2];
		String[] stocks = new String[2];
		double[] value = new double[2];
		CustomerStockAccount customer = new CustomerStockAccount();
		System.out.println("enter customer name :");
		customer.setCustomerName(scanner.next());
		System.out.println("enter customer id:");
		customer.setCustomerId(scanner.nextInt());
		System.out.println("enter the names of stocks :");
		for (int index = 0; index < shares.length; index++) {
			stocks[index] = scanner.next();
		}
		customer.setStockName(stocks);
		System.out.println("enter the number of shares :");
		for (int index = 0; index < shares.length; index++) {
			shares[index] = scanner.nextInt();
		}
		customer.setNumberOfShares(shares);
		System.out.println("enter the value of share :");
		for (int index = 0; index < shares.length; index++) {
			value[index] = scanner.nextDouble();
		}
		customer.setShareValue(value);
		customer.toString();
		write(customer.getCustomerName(), customer.getCustomerId(), customer.getStockName(),
				customer.getNumberOfShares(), customer.getShareValue());

	}
	/*
	 * function to implement finding value of stock
	 */
	@Override
	public int[] valueOfAccount(String customerName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		int[] total = new int[2];
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/customer.json");
			Object object = parser.parse(file);
			JSONObject json = (JSONObject) object;
			if (json.get(customerName) != null) {
				JSONArray array = (JSONArray) json.get(customerName);
				total = calShare(array);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	@SuppressWarnings("unused")
	private int[] calShare(JSONArray array) {
		int[] valueofshare = new int[3];
		JSONObject object = (JSONObject) array.get(0);
		JSONArray jsonshare = new JSONArray();
		jsonshare = (JSONArray) object.get("numberOfShares");
		JSONArray jsonvalue = new JSONArray();
		jsonvalue = (JSONArray) object.get("shareValue");
		for (int index = 0; index < 3; index++) {
			long shares = (long) jsonshare.get(index);
			long value = (long) jsonvalue.get(index);
			valueofshare[index] = (int) (shares * value);

		}

		return valueofshare;
	}
	/*
	 * function to implement to buy a share
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buyShare(int amount, String stockName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		int numberofshares = 0;
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/stocks.json");
			Object object = parser.parse(file);
			JSONObject json = (JSONObject) object;
			JSONArray array = (JSONArray) json.get(stockName);
			JSONObject jsonob = (JSONObject) array.get(0);
			System.out.println("data is:" + jsonob);
			if (jsonob != null) {
				System.out.println("enter the share value of one :");
				double value = scanner.nextDouble();
				numberofshares = (int) (amount / value);
				System.out.println("you will get shares :" + numberofshares + " by this " + amount);
				long shares = (long) jsonob.get("numberOfShares");
				long finalshares = (shares - numberofshares);
				jsonob.put("numberOfShares", finalshares);
				array.add(jsonob);
				json.put(stockName, array);
				FileWriter writer = new FileWriter("/home/bridgelabsz/Desktop/stocks.json");
				writer.write(json.toJSONString());
				writer.close();
			} else {
				System.out.println("file is empty ");
			}
			FileReader customer = new FileReader("/home/bridgelabsz/Desktop/customer.json");
			JSONObject jsoncustomer = (JSONObject) parser.parse(customer);
			System.out.println("enter customer name :");
			String namecustomer = scanner.next();
			JSONArray arraycustomer = (JSONArray) jsoncustomer.get(namecustomer);
			JSONObject jsonupdate = (JSONObject) arraycustomer.get(0);
			JSONArray matcharray = (JSONArray) jsonupdate.get("stockName");
			JSONArray valuecustomer = (JSONArray) jsonupdate.get("shareValue");
			for (int index = 0; index < matcharray.size(); index++) {
				if (matcharray.get(index).equals(stockName)) {
					long position = (long) valuecustomer.get(index);
					position = position + numberofshares;
					valuecustomer.add(index, position);
					jsonupdate.put("numberOfShares", position);
				} else if (index == matcharray.size() - 1) {
					matcharray.add(index, stockName);
					valuecustomer.add(index, numberofshares);
					jsonupdate.put("stockName", matcharray);
					jsonupdate.put("sharevalue", valuecustomer);
				}
			}
			FileWriter customerfile = new FileWriter("/home/bridgelabsz/Desktop/customer.json");
			customerfile.write(jsonupdate.toJSONString());
			customerfile.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement to sell a share
	 */
	@Override
	public void sellShare(int amount, String stockName) {
		// TODO Auto-generated method stub

	}
	/*
	 * function to implement saving file
	 */
	@Override
	public void saveFile(String fileName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("/home/bridgelabsz/Desktop/customer.json");
		Object object = parser.parse(file);
		JSONObject json = (JSONObject) object;
		FileWriter writer = new FileWriter("/home/bridgelabsz/Desktop/" + fileName + ".json");
		writer.write(json.toJSONString());
		writer.close();
	}
	/*
	 * function to implement print report of account
	 */
	@Override
	public void printReport(String customerName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/customer.json");
			Object object = parser.parse(file);
			JSONObject json = (JSONObject) object;
			if (json.get(customerName) != null) {
				JSONArray array = (JSONArray) json.get(customerName);
				// JSONObject jsonob = (JSONObject) array.get(0);
				System.out.println(array);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement adding stock to file
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void write(String customerName, int customerId, String[] stockName, int[] numberOfshares,
			double[] shareValue) throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		System.out.println(stockName.toString());
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/customer.json");
			Object object = parser.parse(file);
			JSONObject json = (JSONObject) object;
			JSONArray array = new JSONArray();
			JSONObject jsonob = new JSONObject();
			jsonob.put("customerName", customerName);
			jsonob.put("customerId", customerId);
			jsonob.put("stockName", stockName);
			jsonob.put("numberOfShares", numberOfshares);
			jsonob.put("shareValue", shareValue);
			array.add(jsonob);
			System.out.println(array.toString());
			json.put(customerName, array);
			FileWriter writer = new FileWriter("/home/bridgelabsz/Desktop/customer.json");
			writer.write(json.toJSONString());
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
