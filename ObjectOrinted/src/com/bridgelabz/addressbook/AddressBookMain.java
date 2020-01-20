/*Purpose: create address and add person to it and also update the person and 
 * we can also delete the person from address book 
 * @author kishorereddy
 * @version 1.0
 * @since 14/01/2020
 * @file AddressBookMain.java
 */
package com.bridgelabz.addressbook;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class AddressBookMain {
	AddressBookDAOIpml address = new AddressBookDAOIpml();
	Person select1;
	public void menu() throws IOException, ParseException {
		System.out.println("------------------------");
		System.out.println("       ADDRESSBOOK      ");
		System.out.println("       1.Add Person     ");
		System.out.println("       2.update person  ");
		System.out.println("       3.delete person  ");
		System.out.println("       4.save addressbook ");
		System.out.println("       5.search entries ");
		System.out.println("       6.exit           ");
		System.out.println("select the choice ");
		int choice = 0;
		try {
			choice = address.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter digits only..");
		}
		switch (choice) {
		case 1:
			int loop = 1;
			while (loop == 1) {
				Person person = new Person();
				try {
					System.out.println("enter the first name :");
					person.setFirstName(address.scanner.next());
					System.out.println("enter last name :");
					person.setLastName(address.scanner.next());
					System.out.println("enter address :");
					person.setAddress(address.scanner.next());
					System.out.println("enter city :");
					person.setCity(address.scanner.next());
					System.out.println("enter state :");
					person.setState(address.scanner.next());
				} catch (Exception e1) {
					System.out.println("enter string type of data..");
				}
				try {
					System.out.println("enter zipcode :");
					person.setZipCode(address.scanner.nextInt());
					System.out.println("enter phonenumber :");
					person.setPhoneNumber(address.scanner.nextLong());
				} catch (Exception e1) {
					System.out.println("enter intger type of data... ");
				}
				try {
					address.addPerson(person);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					System.out.println("if you want to add another person details press 1 or press any key");
					loop = address.scanner.nextInt();
				} catch (Exception e) {
					System.out.println("enter digits only...");
				}
			}
			menu();
			break;
		case 2:
			String name = null;
			try {
				System.out.println("enter the first name to which record to modify:");
				name = address.scanner.next();
			} catch (Exception e) {
				System.out.println("enter string type of data...");
			}
			address.editPerson(name);
			menu();
			break;
		case 3:
			String deletename = null;
			try {
				System.out.println("enter the first name to which record to delete ");
				deletename = address.scanner.next();
			} catch (Exception e) {
				System.out.println("enter string type of data..");
			}
			address.deletePerson(deletename);
			menu();
			break;
		case 4:
			address.saveAddressBook();
			menu();
			break;
		case 5:
			try {
				System.out.println("enter the first name :");
				String firstname = address.scanner.next();
				address.searchEntries(firstname);
			} catch (Exception e) {
				System.out.println("enter String type of data..");
			}
			menu();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("enter choice between 1-5 only");
			menu();
			break;
		}
	}

	public static void main(String[] args) throws IOException, ParseException {

		AddressBookMain address = new AddressBookMain();
		address.menu();
	}

}
