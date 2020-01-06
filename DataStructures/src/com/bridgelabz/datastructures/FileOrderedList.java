
/*Purpose:Read the data from the user and added into the list in ascending order
 * and take a another user input if it is found remove from the list, if it 
 * was not found added to list at particular position
*/

/**
 * @author kishorereddy
 *
 */
package com.bridgelabz.datastructures;

public class FileOrderedList {

	/**
	 * Main function to test the class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * creating the instance of utility class to access the function in it
		 */
		Utility<Integer> util = new Utility<>();

		int number = 0;
		try {
			System.out.println("enter the number how many numbers want to add :");
			number = util.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter in digits only...");
		}
		// asking the user to assign the size of list

		System.out.println("enter number :");

		for (int index = 0; index < number; index++) {
			System.out.println("enter " + index + " no");
			/*
			 * taking the user inputs from the keyboard and adding the elements through this
			 * function
			 */
			try {
				util.addOrderedElement(util.scanner.nextInt());
			} catch (Exception e) {
				System.out.println("enter only int type of data...");
			}
		}
		// printing the list
		util.printList();
		// asking user to enter the element to search in the list
		int searchnum = 0;
		try {
			System.out.println("enter number to search :");
			searchnum = util.scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter only int type of data...");
		}
		/*
		 * calling function for adding and removing elements from list
		 */
		Utility.addRemove(searchnum, util);
		util.scanner.close();

	}
}
