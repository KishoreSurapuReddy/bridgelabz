package com.bridgelabz.datastructures;

import java.util.Scanner;

/**
 * @author kishorereddy
 *
 * @param <T>
 */
public class Utility<T extends Comparable<T>> {

	Node head, left, right;
	/*
	 * initialize calander array with size of 5 and 7
	 */
	Scanner scanner = new Scanner(System.in);
	static int[][] calander = new int[5][7];
	/*
	 * initialize array as monthdays
	 */
	static int[] monthdays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	/*
	 * function to implement finding primenumbers of range
	 */
	static int[] array = new int[200];
	static int[] anagramnumbers = new int[200];

	public static void findPrimeNumbers(int range) {
		for (int number = 0; number <= range; number++) {
			int count = 0;
			if (number == 0 && number == 1) {

			} else {
				for (int divisiblenum = 1; divisiblenum <= number; divisiblenum++) {
					if (number % divisiblenum == 0) {
						count++;
					}
				}
			}
			if (count == 2) {
				System.out.println(number);
				int position = 0;
				array[position] = number;
				position++;
			}

		}

		for (int index = 0; index < array.length; index++) {
			for (int indexplusone = index + 1; indexplusone < array.length; indexplusone++) {
				if (primeAnagram(array[index], array[indexplusone])) {
					int position = 0;
					anagramnumbers[position] = array[index];
					position++;
					anagramnumbers[position] = array[indexplusone];
					position++;
				}
			}
		}

		/*
		 * for(int i =0;i<anagramnumbers.size();i++) {
		 * System.out.println("anagram "+anagramnumbers.get(i)); }
		 */
	}

	/*
	 * function to implement finding anagrams
	 * 
	 * @param number1
	 * 
	 * @param number2
	 * 
	 * @return number
	 */
	public static boolean primeAnagram(int number1, int number2) {

		int[] a = countOf(number1);
		int[] b = countOf(number2);

		for (int i = 0; i < b.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * function to implement count of int number
	 * 
	 * @param number
	 * 
	 * @return count
	 */
	private static int[] countOf(int number) {
		int[] count = new int[10];
		int temp = number;
		while (temp != 0) {
			int r = temp % 10;
			count[r]++;

			temp = temp / 10;
		}
		// System.out.println("count is :"+Arrays.toString(count));
		return count;
	}

	/*
	 * initializing size of twodimentionalarray
	 */
	static int rowno = 12;
	static int colno = 13;
	static int[][] twodArray = new int[rowno][colno];

	/*
	 * function to implement twodimentionalarray
	 */
	public void twoDimentionalArray() {
		int index = 0;
		for (int row = 0; row < rowno; row++) {
			for (int col = 0; col < colno; col++) {
				twodArray[row][col] = anagramnumbers[index];
				index++;
			}
		}

		for (int row = 0; row < rowno; row++) {
			for (int col = 0; col < colno; col++) {
				System.out.println(" anagram numbers are : " + twodArray[row][col]);

				pushStack(twodArray[row][col]);
				enQueuePrime(twodArray[row][col]);
			}
		}
		popStack();
		deQueuePrime();
	}

	/*
	 * function to implement pushing node into stack
	 * 
	 * @param twodArray2
	 */
	public void pushStack(int twodArray2) {

		Node new_node = new Node(twodArray2);

		if (head == null) {
			head = new_node;
		} else {
			// Node node = head;
			new_node.next = head;
			head = new_node;
		}

	}
	/*
	 * function to implement retrieving elememnt from stack
	 */

	public void popStack() {
		StringBuffer string = new StringBuffer();
		Node node = head;
		if (head == null) {
			System.out.println("stack is empty ");
		}
		string.append("[");
		while (node != null) {
			string.append(node.data);
			node = node.next;
			string.append(" ,");
		}
		string.append("]");
		System.out.println("stack elements are :" + string.toString());
	}

	/*
	 * function to implement enqueue of prime numbers
	 * 
	 * @param twodArray2
	 */
	public void enQueuePrime(int twodArray2) {

		Node new_node = new Node(twodArray2);
		if (right == null) {
			left = right = new_node;
		} else {
			right.next = new_node;
			right = new_node;

		}

	}

	/*
	 * function to implement dequeue of prime numbers
	 */
	public void deQueuePrime() {

		StringBuffer string = new StringBuffer();
		Node node = left;
		if (left == null) {
			System.out.println("queue is empty ");
		}
		string.append("[");
		while (node != null) {
			string.append(node.data);
			node = node.next;
			string.append(" ,");
		}
		string.append("]");
		System.out.println("queue elements are :" + string.toString());

	}

	/*
	 * function to initialize the table fill table with -1
	 */
	public void initCalander() {
		row();
	}

	public void row() {
		for (int row = 0; row < calander.length; row++) {
			col(row);
		}
	}

	/*
	 * taking coloumn
	 * 
	 * @param row
	 */
	public void col(int row) {
		for (int col = 0; col < calander[row].length; col++) {
			calander[row][col] = -1;
		}
	}

	/*
	 * function to displaying calander table
	 * 
	 * @param month
	 */
	public void displayCalTable(int month) {
		System.out.println("       sun     mon     tue     wed      thu     fri    sat ");
		printRow(month);
	}

	/*
	 * printing row of table
	 * 
	 * @param month
	 */
	public void printRow(int month) {
		for (int row = 0; row < calander.length; row++) {
			printCol(row, month);
			System.out.println();
		}
	}

	/*
	 * printing coloumn of table
	 * 
	 * @param row
	 * 
	 * @param month
	 */
	public void printCol(int row, int month) {
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
	 * 
	 * @param day
	 */
	public void makeCalander(int day) {
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
	 * 
	 * @param year
	 * 
	 * @param month
	 * 
	 * @param day
	 * 
	 * @return weed day
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
	 * 
	 * @param month
	 * 
	 * @param year
	 */
	public void displayCalander(int month, int year) {
		int day = 1;
		int d = dayOfWeek(year, month, day);
		initCalander();
		makeCalander(d);
		displayCalTable(month);

	}

}
