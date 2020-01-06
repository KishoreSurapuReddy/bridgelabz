
package com.bridgelabz.datastructures;

import java.util.Scanner;

public class Calander {
	/*
	 * initialize calander array with size of 5 and 7
	 */
	static int[][] calander = new int[5][7];
	/*
	 * initialize array as monthdays
	 */
	static int[] monthdays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	/*
	 * function to initialize the table fill table with -1
	 */
	public static void initCalander() {
		row();
	}

	/*
	 * taking row
	 */
	public static void row() {
		for (int row = 0; row < calander.length; row++) {
			col(row);
		}
	}

	/*
	 * taking coloumn
	 */
	public static void col(int row) {
		for (int col = 0; col < calander[row].length; col++) {
			calander[row][col] = -1;
		}
	}

	/*
	 * function to displaying calander table
	 */
	public static void displayCalTable(int month) {
		System.out.println("       sun     mon     tue     wed      thu     fri    sat ");
		printRow(month);
	}

	/*
	 * printing row of table
	 */
	public static void printRow(int month) {
		for (int row = 0; row < calander.length; row++) {
			printCol(row, month);
			System.out.println();
		}
	}

	/*
	 * printing coloumn of table
	 */
	public static void printCol(int row, int month) {
		for (int col = 0; col < calander[row].length; col++) {
			/*
			 * if the value of table is monthdays < calander[row][col] < 0 print nothing
			 */
			if (calander[row][col] < 0 || calander[row][col] > monthdays[month - 1]) {
				System.out.print("\t");
			} else if (calander[row][col] > 0) {
				System.out.print("\t" + calander[row][col] + " ");
			}
		}
	}

	/*
	 * function to implement making a calander month
	 */
	public static void makeCalander(int day) {
		int day1 = 1;
		for (int col = day; col < calander[0].length; col++) {
			calander[0][col] = day1;
			day1++;
		}
		for (int row = 1; row < calander.length; row++) {
			for (int col = 0; col < calander[row].length; col++) {
				calander[row][col] = day1;
				day1++;
			}
		}
	}

	/*
	 * function to implement day of week
	 */
	static int dayOfWeek(int year, int month, int day) {
		int y0 = year - (14 - month) / 12;
		int x = y0 + (y0 / 4) - (y0 / 100) + (y0 / 400);
		int m0 = month + 12 * ((14 - month) / 12) - 2;
		int d0 = (day + x + (31 * m0) / 12) % 7;
		return d0;
	}

	/*
	 * function to implement display calander
	 */
	public static void displayCalander(int month, int year) {
		int day = 1;
		int d = dayOfWeek(year, month, day);
		initCalander();
		makeCalander(d);
		displayCalTable(month);

	}

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
		displayCalander(month, year);

	}

}
