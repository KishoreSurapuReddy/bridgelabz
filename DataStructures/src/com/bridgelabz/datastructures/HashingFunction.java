
/*Purpose:Add the elements into the list at particular position and print 
 * the list
 *  @author kishorereddy
*/
package com.bridgelabz.datastructures;

import com.bridgelabz.util.OrderedList;

public class HashingFunction {
	@SuppressWarnings("unchecked")
	static OrderedList<Integer> list[] = new OrderedList[11];

	/*
	 * function to implement adding elements to array
	 */

	public static void hashingFunction() {

		for (int index = 0; index < list.length; index++) {

			list[index] = new OrderedList<Integer>();
		}
	}

	/*
	 * function to implement adding number in list at particular position
	 * @param slotnumber
	 */
	public static void putNumber(int slotnumber) {

		list[slotnumber % 11].addOrderedElement(slotnumber);
	}

	/*
	 * function to implement search number in list
	 */
	public static boolean search(int slotnumber) {

		return list[slotnumber % 11].searchElement(slotnumber);

	}

	public static void main(String[] args) {

		OrderedList<Integer> list = new OrderedList<Integer>();

		System.out.println("enter the number how manynumbers want to add:");
		/*
		 * taking user input
		 */
		try {
			int number = list.scanner.nextInt();

			for (int index = 0; index < number; index++) {

				System.out.println("enter " + index + " number :");

				list.addOrderedElement(list.scanner.nextInt());
			}
		} catch (Exception e) {
			
			System.out.println("enter digits only..");
		}

		hashingFunction();

		for (int index = 0; index < list.sizeOfList(); index++) {

			putNumber(list.pop(index));
		}

		list.printList();

	}

}
