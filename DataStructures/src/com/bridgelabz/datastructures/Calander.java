/*Purpose:To print the calander based on the input month and year
 *  @author kishorereddy
*/
package com.bridgelabz.datastructures;

import java.util.Scanner;

public class Calander {
	
	public static void main(String[] args) {
		Utility<Integer> util = new Utility<Integer>();
		/*
		 * taking user input for month and year
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the month :");
		int month = sc.nextInt();
		System.out.println("enter the year :");
		int year = sc.nextInt();
		sc.close();
		util.displayCalander(month, year);

	}

}
