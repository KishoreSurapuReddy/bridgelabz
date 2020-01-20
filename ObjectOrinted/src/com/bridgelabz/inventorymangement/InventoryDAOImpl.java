/*purpose:implementing abstract methods
 * @author kishorereddy
 * @version 1.0
 * @since 15/01/2020
 * @file InventoryDAOImpl.java
 */
package com.bridgelabz.inventorymangement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgelabz.filesystem.FileSystem;

public class InventoryDAOImpl implements InventoryDAO {
	FileSystem file = new FileSystem();
	Scanner scanner = new Scanner(System.in);
	/*
	 * function to implement adding inventory to file
	 */
	@Override
	public void addInventory(InventoryManagement inventory, String inventoryname) {
		
		try {
			writeInventory(inventoryname, inventory.getItemName(), inventory.getItemWeight(), inventory.getItemPrice());
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
		try {
			String readFile = "/home/bridgelabsz/Desktop/inventory.json";
			JSONObject jsonobject = file.readFile(readFile);
			JSONArray array = new JSONArray();
			JSONObject json = new JSONObject();
			json.put("itemName", itemName);
			json.put("itemWeight", itemWeight);
			json.put("itemPrice", itemPrice);
			array.add(json);
			System.out.println(array);
			jsonobject.put(item, array);
			String writeFile =  "/home/bridgelabsz/Desktop/inventory.json";
			file.writeFile(writeFile,jsonobject);
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
		try {
			String readFile = "/home/bridgelabsz/Desktop/inventory.json";
			JSONObject jsonobject = file.readFile(readFile);
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
	@Override
	public double calItem(JSONArray array) {
		double calculation = 0;
		JSONObject jsonobject = (JSONObject) array.get(0);
		double itemWeight =  (double) jsonobject.get("itemWeight");
		double itemPrice = (double) jsonobject.get("itemPrice");
		calculation = calculation + (itemWeight * itemPrice);
		return calculation;
	}

}
