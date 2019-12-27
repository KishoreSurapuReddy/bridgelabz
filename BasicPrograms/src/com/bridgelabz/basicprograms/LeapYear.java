package com.bridgelabz.basicprograms;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the year :");
		int year = sc.nextInt();
		sc.close();
		Util.leapYear(year);

	}

}
