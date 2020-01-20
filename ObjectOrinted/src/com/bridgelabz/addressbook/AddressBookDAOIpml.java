/*purpose:it will implement abstract methods 
 * @author kishorereddy
 * @version 1.0
 * @since 14/01/2020
 * @file AddressBookDAOImpl.java
 */
package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.filesystem.FileSystem;

public class AddressBookDAOIpml implements AddressDAO {
	Scanner scanner = new Scanner(System.in);
	String addressFile = "/home/bridgelabsz/Desktop/address.json";
	FileSystem file = new FileSystem();
	/*
	 * function to implement adding person
	 */
	@Override
	public void addPerson(Person person) throws IOException, ParseException {

		writeDetails(person.getFirstName(), person.getLastName(), person.getAddress(), person.getCity(),
				person.getState(), person.getZipCode(), person.getPhoneNumber());

	}
	/*
	 * function to implement delete person
	 */
	@Override
	public void deletePerson(String firstName) throws IOException, ParseException {
		String fileReader = addressFile;
		JSONObject jsonobject = file.readFile(fileReader);
		jsonobject.remove(firstName);
		String filewriter = addressFile;
		file.writeFile(filewriter, jsonobject);
	}
	/*
	 * function to implement update person
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void editPerson(String firstName) throws IOException, ParseException {
		try {
			String fileReader = addressFile;
			JSONObject jsonobject = file.readFile(fileReader);
			if (jsonobject.get(firstName) != null) {
				JSONArray jsonarray = (JSONArray) jsonobject.get(firstName);
				JSONObject json = (JSONObject) jsonarray.get(0);
				json.forEach((key, value) -> {
					if (!key.equals(firstName)) {
						System.out.println(key + "\t\t" + value);
						int num = 0;
						try {
							System.out.println("enter 1 to edit the details or press any key");
							num = scanner.nextInt();
						} catch (Exception e) {
							System.out.println("enter digits only..");
						}
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
				String filewriter = addressFile;
				file.writeFile(filewriter, json);
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

		try {
			String fileReader = addressFile;
			JSONObject jsonobject = file.readFile(fileReader);
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
		String fileReader = addressFile;
		JSONObject jsonobject = file.readFile(fileReader);
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
		String filewriter = addressFile;
		file.writeFile(filewriter, jsonobject);
	}
	/*
	 * function to implement search person
	 */
	@Override
	public void searchEntries(String firstname) throws IOException, ParseException {
		try {
			String fileReader = addressFile;
			JSONObject jsonobject = file.readFile(fileReader);
			JSONArray jsonarray = (JSONArray) jsonobject.get(firstname);
			System.out.println(jsonarray);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}