package com.bridgelabz.objectorinted;

import java.io.FileInputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class InventoryOperation {
	
	public static void readInventory() throws IOException {
		String file = "/home/bridgelabsz/Desktop/inventory.json";
		FileInputStream inputstream = new FileInputStream(file);
		
		JsonReader jsonreader = Json.createReader(inputstream);
		
		JsonObject jsonobject = jsonreader.readObject();
		jsonreader.close();
		inputstream.close();
		
		JSonInventoryDataManagement inventory = new JSonInventoryDataManagement();
		inventory.setName(jsonobject.getString("name"));
		inventory.setWeight(jsonobject.getInt("weight"));
		inventory.setPrice(jsonobject.getInt("price"));
		
		System.out.println(inventory.toString());
		
		
	}
	public void writeInventory() {
		
	}
	public static void main(String[] args) throws IOException {
		readInventory();

}
}
