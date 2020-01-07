
/*Purpose:Add the elements into the list at particular position and print 
 * the list
 * 
*/
package com.bridgelabz.datastructures;

/**
 * @author kishorereddy
 *
 */
public class HashingFunction {
	@SuppressWarnings("unchecked")
	static Utility<Integer> list[] = new Utility[11];

	/*
	 * function to implement adding elements to array
	 */

	public static void hashingFunction() {

		for (int index = 0; index < list.length; index++) {

			list[index] = new Utility<Integer>();
		}
	}

	/*
	 * function to implement adding number in list at particular position
	 */
	/**
	 * @param number
	 */
	public static void putNumber(int number) {

		list[number % 11].addOrderedElement(number);
	}

	/*
	 * function to implement search number in list
	 */
	public static boolean search(int number) {

		return list[number % 11].searchElement(number);

	}

	public static void main(String[] args) {

		Utility<Integer> util = new Utility<Integer>();

		System.out.println("enter the number how manynumbers want to add:");
		/*
		 * taking user input
		 */
		try {
			int number = util.scanner.nextInt();

			for (int index = 0; index < number; index++) {

				System.out.println("enter " + index + " number :");

				util.addOrderedElement(util.scanner.nextInt());
			}
		} catch (Exception e) {
			
			System.out.println("enter digits only..");
		}

		hashingFunction();

		for (int index = 0; index < Utility.sizeOfList(); index++) {

			putNumber(util.pop(index));
		}

		util.printList();

	}

}
