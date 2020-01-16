/*Purpose: create address and add person to it and also update the person and 
 * we can also delete the person from address book 
 * @author kishorereddy
*/
package com.bridgelabz.addressbook;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class AddressBookMain {
	AddressBookDAOIpml address = new AddressBookDAOIpml();
	AddressBook select1;
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
		switch(choice) {
		case 1:
			try {
				address.addPerson();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menu();
			break;
		case 2:
			System.out.println("enter the first name to which record to modify:");
			String name = address.scanner.next();
			address.editPerson(name);
			menu();
			break;
		case 3:
			System.out.println("enter the first name to which record to delete ");
			String deletename = address.scanner.next();
			address.deletePerson(deletename);
			menu();
			break;
		case 4:
			address.saveAddressBook();
			menu();
			break;
		case 5:
			System.out.println("enter the first name :");
			String firstname = address.scanner.next();
			address.searchEntries(firstname);
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
		
		AddressBookMain main = new AddressBookMain();
		main.menu();
	}


}
