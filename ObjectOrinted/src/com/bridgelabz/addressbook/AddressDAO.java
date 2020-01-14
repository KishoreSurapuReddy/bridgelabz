package com.bridgelabz.addressbook;

public interface AddressDAO {
	public void addPerson();
	public void deletePerson(String firstName);
	public void editPerson(String firstName);
	public AddressBook sortEntriesByName(String array);
	public AddressBook sortEntriesByZipCode(int zipCode);
	public AddressBook[] printEntries();
	public void createNewAddressBook();
	public void openExistingAddressBook(AddressBook[] addressbook);
	public void saveAddressBook();
	public void saveAsAddressBook();

}
