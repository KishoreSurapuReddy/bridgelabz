/*purpose:it will have abstract methods
 * @author kishorereddy
 * @version 1.0
 * @since 14/01/2020
 * @file AddressDAO.java
 */
package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface AddressDAO {
	//abstract methods
	public void addPerson(Person person ) throws IOException, ParseException;
	public void deletePerson(String firstName) throws FileNotFoundException, IOException, ParseException;
	public void editPerson(String firstName) throws IOException, ParseException;
	public void writeDetails(String firstName , String lastName , String address , String city , String state , int zipCode ,long phoneNumber ) throws FileNotFoundException, IOException, ParseException;
	public void searchEntries(String firstname) throws IOException, ParseException;
	public void saveAddressBook() throws IOException, ParseException;

}
