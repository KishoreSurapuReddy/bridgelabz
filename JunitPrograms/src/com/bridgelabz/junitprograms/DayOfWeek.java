package com.bridgelabz.junitprograms;

import java.util.Scanner;

public class DayOfWeek {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the year , month and day ");
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		sc.close();
		System.out.println(Util.dayOfWeek(year, month, day));

	}

}
