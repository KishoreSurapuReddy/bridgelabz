/* Purpose:Deque is used store the elements by two sides and in this we added the 
 * characters to the dequeue in rare end and retrieved characters from front and rare
 * sides of dequeue and compare each character to know weather given string is 
 * palindrome  
 * @author kishorereddy
*/
package com.bridgelabz.datastructures;

import com.bridgelabz.util.DeQueueList;

public class DeQueue {

	public static void main(String[] args) {

		DeQueueList<Character> dequeue = new DeQueueList<Character>();
		String name = null;
		try {
			System.out.println("Enter the  String :");
			/*
			 * taking user input
			 */
			name = dequeue.scanner.next();
		} catch (Exception e) {
			System.out.println("enter string type only..");
		}
		for (int index = 0; index < name.length(); index++) {
			dequeue.addRear(name.charAt(index));
		}
		System.out.println(dequeue.deQueueSize());
		System.out.println("given string is palindrome :" + dequeue.isPalindrome());

	}

}
