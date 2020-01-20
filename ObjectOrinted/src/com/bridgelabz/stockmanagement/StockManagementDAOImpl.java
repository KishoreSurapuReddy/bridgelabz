/*purpose:implementing abstract methods
 * @author kishorereddy
 * @version 1.0
 * @since 16/01/2020
 * @file StockManagementDAOImpl.java
 */
package com.bridgelabz.stockmanagement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgelabz.filesystem.FileSystem;

public class StockManagementDAOImpl implements StockManagementDAO {
	Scanner scanner = new Scanner(System.in);
	FileSystem file = new FileSystem();
	List<String> stocks = new ArrayList<String>();
	String stockFile = "/home/bridgelabsz/Desktop/stocks.json";
	String customerFile = "/home/bridgelabsz/Desktop/customer.json";
	/*
	 * function to implement adding Stock to file
	 */
	@Override
	public void addStock(StockManagement stock) throws IOException, ParseException {
		
		writeIntoFile(stock.getStockName(), stock.getNumberOfShares(), stock.getSharePrice());

	}
	/*
	 * function to implement view stock
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void viewStock(String stockName) throws IOException, ParseException {
		try {
			String  readfile = stockFile;
			JSONObject jsonobject = file.readFile(readfile);
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
		
		try {
			String  readFile = stockFile;
			JSONObject json = file.readFile(readFile);
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
		try {
			String  readFile = stockFile;
			JSONObject jsonobject = file.readFile(readFile);
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
				String filewriter = stockFile;
				file.writeFile(filewriter , data);
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
		try {
			String  readFile = stockFile;
			JSONObject json = file.readFile(readFile);
			json.get(stockName);
			json.remove(stockName);
			String filewriter = stockFile;
			file.writeFile(filewriter , json);
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
		try {
			String  readFile = stockFile;
			JSONObject json = file.readFile(readFile);
			JSONArray array = new JSONArray();
			JSONObject jsonob = new JSONObject();
			jsonob.put("stockName", stockName);
			jsonob.put("numberOfShares", numberOfShares);
			jsonob.put("sharePrice", sharePrice);
			array.add(jsonob);
			System.out.println(array);
			json.put(stockName, array);
			String filewriter = stockFile;
			file.writeFile(filewriter , json);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement adding customer account details 
	 */
	@Override
	public void stockAccount(CustomerStockAccount customer) throws IOException, ParseException {
		
		write(customer.getCustomerName(), customer.getCustomerId(), customer.getStockName(),
				customer.getNumberOfShares(), customer.getShareValue());

	}
	/*
	 * function to implement finding value of stock
	 */
	@Override
	public int[] valueOfAccount(String customerName) throws IOException, ParseException {
		
		int[] total = new int[2];
		try {
			String readFile = customerFile;
			JSONObject json = file.readFile(readFile);
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
		int numberofshares = 0;
		try {
			String readFile = stockFile;
			JSONObject json = file.readFile(readFile);
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
				JSONArray arrayupdate = new JSONArray();
				JSONObject objectupdate = new JSONObject();
				arrayupdate.add(jsonob);
				objectupdate.put(stockName, array);
				String  writer = stockFile;
				file.writeFile(writer, objectupdate);
			} else {
				System.out.println("file is empty ");
			}
			String customerfile = customerFile;
			JSONObject jsoncustomer = file.readFile(customerfile);
			System.out.println("enter customer name :");
			String namecustomer = scanner.next();
			JSONArray arraycustomer = (JSONArray) jsoncustomer.get(namecustomer);
			JSONObject jsonupdate = (JSONObject) arraycustomer.get(0);
			JSONArray matcharray = (JSONArray) jsonupdate.get("stockName");
			JSONArray valuecustomer = (JSONArray) jsonupdate.get("numberOfShares");
			for (int index = 0; index < matcharray.size(); index++) {
				if (matcharray.get(index).equals(stockName)) {
					long position = (long) valuecustomer.get(index);
					position = position + numberofshares;
					valuecustomer.remove(index);
					valuecustomer.add(index, position);
					jsonupdate.put("numberOfShares", valuecustomer);
					//arraycustomer.add(jsonupdate);
					//jsoncustomer.put(namecustomer, arraycustomer);
				} else if (index == matcharray.size() - 1) {
					matcharray.add(index, stockName);
					valuecustomer.add(index, numberofshares);
					jsonupdate.put("stockName", matcharray);
					jsonupdate.put("numberOfShares", valuecustomer);
					arraycustomer.add(jsonupdate);
					jsoncustomer.put(namecustomer, arraycustomer);
				}
			}
			JSONArray customerupdate = new JSONArray();
			JSONObject customerobject = new JSONObject();
			customerupdate.add(jsonupdate);
			customerobject.put(namecustomer, customerupdate);
			String filewriter = customerFile;
			file.writeFile(filewriter, customerobject);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * function to implement to sell a share
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void sellShare(int amount, String stockName) throws IOException, ParseException {
		int numberofshares = 0;
		String readFile = customerFile;
		JSONObject jsoncustomer = file.readFile(readFile);
		System.out.println("enter customer name :");
		String namecustomer = scanner.next();
		JSONArray arraycustomer = (JSONArray) jsoncustomer.get(namecustomer);
		JSONObject jsonupdate = (JSONObject) arraycustomer.get(0);
		System.out.println(jsonupdate);
		System.out.println("enter the share value of one :");
		double value = scanner.nextDouble();
		numberofshares = (int) (amount / value);
		System.out.println("you will get shares :" + numberofshares + " by this " + amount);
		JSONArray matcharray = (JSONArray) jsonupdate.get("stockName");
		JSONArray valuecustomer = (JSONArray) jsonupdate.get("numberOfShares");
		for (int index = 0; index < matcharray.size(); index++) {
			if (matcharray.get(index).equals(stockName)) {
				long position = (long) valuecustomer.get(index);
				position = position - numberofshares;
				valuecustomer.remove(index);
				valuecustomer.add(index, position);
				jsonupdate.put("numberOfShares", valuecustomer);
				//arraycustomer.add(jsonupdate);
				//jsoncustomer.put(namecustomer, arraycustomer);
			} else {
				System.out.println("there is no stock name ");
			}
		}
		JSONArray customerupdate = new JSONArray();
		JSONObject customerobject = new JSONObject();
		customerupdate.add(jsonupdate);
		customerobject.put(namecustomer, customerupdate);
		String customerfile = customerFile;
		file.writeFile(customerfile, customerobject);

	}
	/*
	 * function to implement saving file
	 */
	@Override
	public void saveFile(String fileName) throws IOException, ParseException {
		String readFile = customerFile;
		JSONObject json = file.readFile(readFile);
		FileWriter writer = new FileWriter("/home/bridgelabsz/Desktop/" + fileName + ".json");
		writer.write(json.toJSONString());
		writer.close();
	}
	/*
	 * function to implement print report of account
	 */
	@Override
	public void printReport(String customerName) throws IOException, ParseException {
		
		try {
			String readFile = customerFile;
			JSONObject json = file.readFile(readFile);
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

		System.out.println(stockName.toString());
		try {
			String readFile = customerFile;
			JSONObject json = file.readFile(readFile);
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
			String writerfile = customerFile;
			file.writeFile(writerfile, json);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
