
package com.bridgelabz.datastructures;

import java.util.Scanner;

public class Calander {
	
	public static void main(String[] args) {
		/*
		 * taking user input for month and year
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the month :");
		int month = sc.nextInt();
		System.out.println("enter the year :");
		int year = sc.nextInt();
		sc.close();
		Utility.displayCalander(month, year);

	}

}
