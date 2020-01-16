package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddressBookDAOIpml implements AddressDAO {
	Scanner scanner = new Scanner(System.in);

	/*
	 * function to implement adding person
	 */
	@Override
	public void addPerson() throws IOException, ParseException {
		AddressBook address = new AddressBook();
		System.out.println("enter the first name :");
		address.setFirstName(scanner.next());
		System.out.println("enter last name :");
		address.setLastName(scanner.next());
		System.out.println("enter address :");
		address.setAddress(scanner.next());
		System.out.println("enter city :");
		address.setCity(scanner.next());
		System.out.println("enter state :");
		address.setState(scanner.next());
		System.out.println("enter zipcode :");
		address.setZipCode(scanner.nextInt());
		System.out.println("enter phonenumber :");
		address.setPhoneNumber(scanner.nextLong());

		writeDetails(address.getFirstName(), address.getLastName(), address.getAddress(), address.getCity(),
				address.getState(), address.getZipCode(), address.getPhoneNumber());

	}

	/*
	 * function to implement delete person
	 */
	@Override
	public void deletePerson(String firstName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("/home/bridgelabsz/Desktop/address.json");
		Object object = parser.parse(file);
		JSONObject jsonobject = (JSONObject) object;
		jsonobject.get(firstName);
		jsonobject.remove(firstName);
		FileWriter filewriter = new FileWriter("/home/bridgelabsz/Desktop/address.json");
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}

	/*
	 * function to implement update person
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void editPerson(String firstName) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/address.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			if (jsonobject.get(firstName) != null) {
				JSONArray jsonarray = (JSONArray) jsonobject.get(firstName);
				JSONObject json = (JSONObject) jsonarray.get(0);
				json.forEach((key, value) -> {
					if (!key.equals(firstName)) {
						System.out.println(key + "\t\t" + value);
						System.out.println("enter 1 to edit the details or press any key");
						int num = scanner.nextInt();
						if (num == 1) {
							System.out.println("enter the details :");
							if (key.equals("zipCode") || key.equals("phoneNumber")) {
								json.put(key, scanner.nextInt());
							} else {
								json.put(key, scanner.next());
							}
						}
					}
				});
				System.out.println("after change :");
				json.forEach((key, value) -> System.out.println(key + "\t\t" + value));
				FileWriter filewriter = new FileWriter("/home/bridgelabsz/Desktop/address.json");
				filewriter.write(json.toJSONString());
				filewriter.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * function to implement save addressbook
	 */
	@Override
	public void saveAddressBook() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/address.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			System.out.println("enter the name of address book :");
			String name = scanner.next();
			FileWriter filewriter = new FileWriter("/home/bridgelabsz/Desktop/" + name + ".json");
			filewriter.write(jsonobject.toJSONString());
			filewriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * function to implement write person 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void writeDetails(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNumber) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("/home/bridgelabsz/Desktop/address.json");
		Object object = parser.parse(file);
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("firstName", firstName);
		jsonobj.put("lastName", lastName);
		jsonobj.put("address", address);
		jsonobj.put("city", city);
		jsonobj.put("state", state);
		jsonobj.put("zipCode", zipCode);
		jsonobj.put("phoneNumber", phoneNumber);
		jsonarray.add(jsonobj);
		System.out.println(jsonarray);
		jsonobject.put(firstName, jsonarray);
		FileWriter filewriter = new FileWriter("/home/bridgelabsz/Desktop/address.json");
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}

	/*
	 * function to implement search person
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void searchEntries(String firstname) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			FileReader file = new FileReader("/home/bridgelabsz/Desktop/address.json");
			Object object = parser.parse(file);
			JSONObject jsonobject = (JSONObject) object;
			JSONArray jsonarray = (JSONArray) jsonobject.get(firstname);
			if (jsonarray != null) {
				Iterator iterator = jsonarray.iterator();
				while (iterator.hasNext()) {
					JSONObject json = (JSONObject) iterator.next();
					json.forEach((key, value) -> System.out.println(key + "\t\t" + value));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
