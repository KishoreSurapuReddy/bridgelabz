
/*Purpose:Read the data from the user and added into the list in ascending order
 * and take a another user input if it is found remove from the list, if it 
 * was not found added to list at particular position
 * 
 * @author kishorereddy
 */
package com.bridgelabz.datastructures;

import com.bridgelabz.util.OrderedList;

public class FileOrderedList {

	/**
	 * Main function to test the class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		OrderedList<Integer> list = new OrderedList<Integer>();

		int number = 0;
		try {
			System.out.println("enter the number how many numbers want to add :");
			number = list.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter in digits only...");
		}

		System.out.println("enter number :");

		for (int index = 0; index < number; index++) {
			System.out.println("enter " + index + " no");
			// taking the user inputs from the keyboard and adding the elements through this
			// function
			try {
				list.addOrderedElement(list.scanner.nextInt());
			} catch (Exception e) {
				System.out.println("enter only int type of data...");
			}
		}
		// printing the list
		list.printList();
		// asking user to enter the element to search in the list
		int searchnum = 0;
		try {
			System.out.println("enter number to search :");
			searchnum = list.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter only int type of data...");
		}
		// calling function for adding and removing elements from list
		OrderedList.addRemove(searchnum, list);
		list.scanner.close();

	}
}
