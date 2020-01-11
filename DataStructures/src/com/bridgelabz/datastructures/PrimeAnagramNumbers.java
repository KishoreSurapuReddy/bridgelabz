
/*Purpose:finding primenumbers of range and store into two dimentionalarray
 * and retrieve elements from array and store into stack by using linkedlist
 * @author kishorereddy
*/
package com.bridgelabz.datastructures;

public class PrimeAnagramNumbers {

	public static void main(String[] args) {
		Utility<Integer> util = new Utility<Integer>();
		System.out.println("enter range of number to find prime numbers :");
		int range = util.scanner.nextInt();
		Utility.findPrimeNumbers(range);
		util.twoDimentionalArray();

	}

}
