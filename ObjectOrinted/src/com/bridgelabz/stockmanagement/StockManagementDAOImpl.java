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

	@Override
	public void addStock() throws IOException, ParseException {
		StockManagement stock = new StockManagement();
		System.out.println("enter the name of stock :");
		stock.setStockName(scanner.next());
		System.out.println("enter the number of shares :");
		stock.setNumberOfShares(scanner.nextInt());
		System.out.println("enter the price of each share :");
		stock.setSharePrice(scanner.nextDouble());
		writeIntoFile(stock.getStockName(),stock.getNumberOfShares(),stock.getSharePrice());
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void viewStock(String stockName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/stocks.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			JSONArray array = (JSONArray) jsonobject.get(stockName);
			if(array != null) {
				Iterator iterator = array.iterator();
				while(iterator.hasNext()) {
					JSONObject data = (JSONObject) iterator.next();
					data.forEach((key , value) -> System.out.println(key +"  "+value));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

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

	@SuppressWarnings("unchecked")
	@Override
	public void updateStock(String stockName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/stocks.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			if(jsonobject.get(stockName)!=null) {
				JSONArray array = (JSONArray) jsonobject.get(stockName);
				JSONObject data = (JSONObject) array.get(0);
				data.forEach((key , value) -> {
					if(!key.equals(stockName)) {
						System.out.println(key+"\t\t"+value);
						System.out.println("enter 1 to edit the content ");
						int num = scanner.nextInt();
						if(num == 1) {
							System.out.println("enter the details ");
							if(key.equals("numberOfShares")) {
								data.put(key, scanner.nextInt());
							}else if(key.equals("sharePrice")) {
								data.put(key, scanner.nextDouble());
							}else {
								data.put(key, scanner.next());
							}
						}
					}
				});
				System.out.println("after updating ");
				data.forEach((key,value) -> System.out.println(key +"\t\t"+value));
				FileWriter filewriter = new FileWriter("/home/bridgelabsz/Desktop/stocks.json");
				filewriter.write(data.toJSONString());
				filewriter.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

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

	@SuppressWarnings("unchecked")
	@Override
	public void writeIntoFile(String stockName, int numberOfShares, double sharePrice) throws IOException, ParseException {
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

	

}
