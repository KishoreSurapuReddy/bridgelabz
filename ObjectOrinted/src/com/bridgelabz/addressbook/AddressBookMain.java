package com.bridgelabz.addressbook;
public class AddressBookMain {
	AddressBookDAOIpml address = new AddressBookDAOIpml();
	public void menu() {
		System.out.println("------------------------");
		System.out.println("       ADDRESSBOOK      ");
		System.out.println("       1.Add Person     ");
		System.out.println("       2.update person  ");
		System.out.println("       3.delete person  ");
		System.out.println("       4.print entries  ");
		System.out.println("       5.exit           ");
		System.out.println("select the choice ");
		int choice = 0;
		try {
			choice = address.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter digits only..");
		}
		switch(choice) {
		case 1:
			address.addPerson();
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
			AddressBook[] data = address.printEntries();
			System.out.println("firstname"+"\t"+"lastname"+"\t"+"address"+"\t"+"city"+"\t"+"state"+"\t"+"zipcode"+"\t"+"phonenumber");
			for(AddressBook details : data ) {
				System.out.println("   "+details);
			}
			menu();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("enter choice between 1-5 only");
			menu();
			break;
		}
	}


	public static void main(String[] args) {
		
		AddressBookMain main = new AddressBookMain();
		main.menu();
	}

}
