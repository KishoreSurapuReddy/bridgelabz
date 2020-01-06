/* Purpose:Deque is used store the elements by two sides and in this we added the 
 * characters to the dequeue in rare end and retrieved characters from front and rare
 * sides of dequeue and compare each character to know weather given string is 
 * palindrome  
 * 
*/
package com.bridgelabz.datastructures;

import java.util.Deque;

/**
 * @author kishorereddy
 *
 */
public class DeQueue {

	public static boolean isPalindrome(Deque<Character> deque) {
		Character name1 = ' ';
		Character name2 = ' ';
		boolean ispalindrome = false;
		int size = deque.size();

		if (size % 2 == 0) {
			while (size != 0) {
				name1 = deque.getFirst();
				name2 = deque.getLast();
				size--;
			}
			if (name1.equals(name2)) {
				ispalindrome = true;
			}

		} else if (size % 2 == 1) {
			System.out.println("deque contains insufficient  character ");
		} else {
			System.out.println("deque contains only one chatracter ");
		}
		return ispalindrome;
	}

	public static void main(String[] args) {
		/*
		 * creating instace of Utility class assigning type as character
		 */
		Utility<Character> util = new Utility<>();
		String name = null;
		try {
			System.out.println("Enter the  String :");
			/*
			 * taking user input
			 */
			name = util.scanner.next();
		} catch (Exception e) {
			System.out.println("enter string type only..");
		}
		for (int index = 0; index < name.length(); index++) {
			util.addRear(name.charAt(index));
		}
		System.out.println(util.deQueueSize());
		System.out.println(util.deQueueToString());
		System.out.println("given string is palindrome :" + isPalindrome(util.deque));

	}

}
