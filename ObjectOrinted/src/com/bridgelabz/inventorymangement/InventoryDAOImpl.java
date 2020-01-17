package com.bridgelabz.inventorymangement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InventoryDAOImpl implements InventoryDAO {

	Scanner scanner = new Scanner(System.in);

	/*
	 * function to implement adding inventory to file
	 */
	@Override
	public void addInventory(String item) {
		JSonInventoryDataManagement inventory = new JSonInventoryDataManagement();
		System.out.println("enter item name :");
		inventory.setItemName(scanner.next());
		System.out.println("enter item weight :");
		inventory.setItemWeight(scanner.nextDouble());
		System.out.println("enter item price: ");
		inventory.setItemPrice(scanner.nextDouble());
		try {
			writeInventory(item, inventory.getItemName(), inventory.getItemWeight(), inventory.getItemPrice());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * function to implement writing inventory to file
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void writeInventory(String item, String itemName, double itemWeight, double itemPrice)
			throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/inventory.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			JSONArray array = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("itemName", itemName);
			json.put("itemWeight", itemWeight);
			json.put("itemPrice", itemPrice);
			array.add(json);
			System.out.println(array);
			jsonobject.put(item, array);
			FileWriter filewriter = new FileWriter("/home/bridgelabsz/Desktop/inventory.json");
			filewriter.write(jsonobject.toJSONString());
			filewriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * function to implement reading inventory to file
	 */
	@Override
	public double readInventory(String item) throws IOException, ParseException {
		double total = 0;
		JSONParser parser = new JSONParser();
		FileReader file;
		try {
			file = new FileReader("/home/bridgelabsz/Desktop/inventory.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			if (item.equals("All")) {
				JSONArray array = (JSONArray) jsonobject.get("Rice");
				total = total + calItem(array);
				array = (JSONArray) jsonobject.get("pulses");
				total = total + calItem(array);
				array = (JSONArray) jsonobject.get("wheat");
				total = total + calItem(array);

			} else {
				JSONArray array = (JSONArray) jsonobject.get(item);
				total = total + calItem(array);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;

	}

	/*
	 * function to implement calculating inventory to file
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public double calItem(JSONArray array) {
		double calculation = 0;
		JSONObject jsonobject = (JSONObject) array.get(0);
		long itemWeight = (long) jsonobject.get("itemWeight");
		long itemPrice = (long) jsonobject.get("itemPrice");
		calculation = calculation + (itemWeight * itemPrice);

		return calculation;

	}

}
