package com.bridgelabz.addressbook;

import java.util.Scanner;

public  class AddressBookDAOIpml implements AddressDAO {
	static AddressBook[] array = new AddressBook[2];
	AddressBook[] collection = new AddressBook[2];
	static AddressBook[] temp = new AddressBook[2];
	//AddressBook[] newaddress = new AddressBook[1];
	Scanner scanner = new Scanner(System.in);
	AddressBook addressbook ;

	@Override
	public void addPerson() {
		array = new AddressBook[1];
		for (int position = 0; position < array.length; position++) {
			String firstName = null;
			String lasttName = null;
			String address = null;
			String city = null;
			String state = null;
			int zipCode = 0;
			long phoneNumber = 0;
			try {
				System.out.println("Enter the person details: ");
				System.out.println("Enter FirstName :");
				firstName = scanner.next();
				System.out.println("Enter LastName :");
				lasttName = scanner.next();
				System.out.println("Enter Address :");
				address = scanner.next();
				System.out.println("Enter City :");
				city = scanner.next();
				System.out.println("Enter State :");
				state = scanner.next();
				System.out.println("Enter ZipCode :");
				zipCode = scanner.nextInt();
				System.out.println("Enter PhoneNumber :");
				phoneNumber = scanner.nextLong();
			} catch (Exception e) {
				System.out.println("enter correct data");
			}
			addressbook = new AddressBook(firstName,lasttName,address,city,state,zipCode,phoneNumber);
			array[position] = addressbook;
		}
		System.out.println("successfully record added..");
	}

	@Override
	public void deletePerson(String firstName) {
		int index = 0;
		temp =  new AddressBook[2];
		for(AddressBook item : array) {
			if(item.getFirstName().equals(firstName)) {
				
			}else {
				temp[index] = item;
			}
			index++;
		}
		array = new AddressBook[2];
		for(int position =0 ; position < array.length ; position++) {
			array[position] = temp[position];
		}
		System.out.println("successfully address is deleted..");
		
	}
	

	@Override
	public void editPerson(String firstName) {
		int index = 0;
		temp = new AddressBook[2];
		for(AddressBook item : array) {
			if(item.getFirstName().equals(firstName)) {
				int choice = 0;
				try {
					System.out.println("select the choice to update 1.address 2.city 3.state 4.zipcode 5.phonenumber");
					choice = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("enter digits only..");
				}
				switch(choice) {
				case 1:
					System.out.println("enter address to update");
					item.setAddress(scanner.next());
					break;
				case 2:
					System.out.println("enter city to update ");
					item.setCity(scanner.next());
					break;
				case 3:
					System.out.println("enter state to update ");
					item.setState(scanner.next());
					break;
				case 4:
					System.out.println("enter zipcode to update ");
					item.setZipCode(scanner.nextInt());
					break;
				case 5:
					System.out.println("enter phonenumber to update ");
					item.setPhoneNumber(scanner.nextLong());
					break;
				default :
					System.out.println("select only range between 1-5");
					break;
				}
				temp[index] = item;
			}else {
				temp[index] = item ;
			}
			index++;
		}
		array = new AddressBook[2];
		for(int position = 0 ; position < temp.length ; position++) {
			array[position] = temp[position];
		}
		System.out.println("successfully updated ");
	}

	
	@Override
	public AddressBook sortEntriesByZipCode(int zipCode) {
		return addressbook;
		
	}

	@Override
	public AddressBook[] printEntries() {
		return array;
		
	}

	@Override
	public void createNewAddressBook() {
		for(int index = 0 ; index < collection.length ; index ++) {
			collection = array;
		}
		addPerson();
		collection = array;
	}

	@Override
	public void openExistingAddressBook(AddressBook addressbook) {
		for(int position = 0 ; position < collection.length ; position++) {
			AddressBook selectedbook = collection[position];
			if(addressbook.equals(selectedbook)) {
				System.out.println(addressbook.getFirstName()+"   "
						+addressbook.getLastName()+"   "+
						addressbook.getAddress()+"    "+
						addressbook.getCity()+"   "+
						addressbook.getState()+"   "+
						addressbook.getZipCode()+"    "+
						addressbook.getPhoneNumber());
			}
		}
		
	}

	@Override
	public void saveAddressBook() {
		
	}

	@Override
	public void saveAsAddressBook() {
		System.out.println("enter the name of address book");
		
	}
	public void noofAddressBooks(AddressBook newaddress2) {
		AddressBook[] addressbooks = new AddressBook[5];
		for(int position = 0 ; position < addressbooks.length ; position++) {
			addressbooks[position] = newaddress2;
		}
	}

	//@Override
	/*public <T extends Comparable<T>>T[] sortEntriesByName(T[] array) {
		for(int count = 1 ; count < array.length ; count++) {
			for(int index = count ; index > 0 ;index--) {
				if(array[index-1].compareTo(array[index]) > 0) {
					String temp = (String) array[index];
					array[index] = array[index-1];
					array[index-1] = (T) temp;
				}
			}
		}
		
		return array;
	}*/
}
