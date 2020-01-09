package com.bridgelabz.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author kishorereddy
 *
 * @param <T>
 */
public class Utility<T extends Comparable<T>> {

	public static Node head, left, right; // head of list
	/*
	 * initialize the size of list as zero
	 */
	private static int size = 0;

	private static Node tail;
	/*
	 * creating the scanner object
	 */
	Scanner scanner = new Scanner(System.in);
	/*
	 * initializing stack capacity
	 */
	private int capacity = 10;
	/*
	 * creating the stack with character type
	 */
	static Stack<Character> stack = new Stack<Character>();
	/*
	 * initialize the top of stack as zero
	 */
	static int top = 0;
	/*
	 * creating the queue with string type
	 */
	static Queue<String> queue = new LinkedList<String>();
	/*
	 * initialize the bank amount with 100000
	 */
	private int bankAmount = 100000;

	/*
	 * creating dequeue with character type
	 */
	Deque<Character> deque = new ArrayDeque<Character>();

	int rear = -1;
	int front = -1;

	/*
	 * initialize calander array with size of 5 and 7
	 */
	static int[][] calander = new int[5][7];
	/*
	 * initialize array as monthdays
	 */
	static int[] monthdays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	/*
	 * function for inserting element at particular position in the list
	 */
	/**
	 * @param <T>
	 * @param position
	 * @param data
	 */
	public static <T> void insertParticularPosition(int position, T data) {
		if (position > size || position < 0) {
			/*
			 * if the position was not in given range
			 */
			System.out.println("we can not insert at this position ");
			return;
		}
		int index = 0;
		Node node = head;
		Node new_node = new Node(data);
		// checking if head is null or not
		if (head == null) {
			new_node.next = head;
			head = new_node;
		} else {
			// head will move until the given position is equal to index
			while (position != index) {
				node = node.next;
				index++;
			}
			// adding new_node at particular position
			new_node.next = node.next;
			node.next = new_node;

		}
	}

	/*
	 * function for size of list
	 *
	 */
	/**
	 * @return size
	 */
	public static int sizeOfList() {
		return size;
	}

	/*
	 * function for reading the data from list
	 * 
	 * @return toString
	 */
	public String toString() {
		StringBuffer stringbuffer = new StringBuffer();
		// created StringBuffer to store the values from list
		Node node = head;
		stringbuffer.append("[ ");
		while (node != null) {
			stringbuffer.append(node.data);
			// add data to StringBuffer
			node = node.next;
			stringbuffer.append(" , ");

		}
		stringbuffer.append(" ]");

		return stringbuffer.toString();

	}

	/*
	 * function for printing list elements
	 */

	public void printList() {
		System.out.println(toString());
	}

	/*
	 * function for know weather list is empty or not
	 */
	/**
	 * @return empty or not
	 */
	public static boolean isListEmpty() {
		Node node = head;
		if (node == null) {
			return true;
		}

		return false;

	}

	/*
	 * function for finding the index position
	 */
	/**
	 * @param <T>
	 * @param data
	 * @return index position
	 */
	public static <T> int index(T data) {
		int index = 0;
		Node node = head;
		while (!node.data.equals(data)) {
			node = node.next;
			index++;
		}
		return index;

	}

	/*
	 * function for finding element in list if it is found it will removed if it is
	 * not found it will be added
	 */
	/**
	 * @param num
	 * @param util
	 */
	static void addRemove(int num, Utility<Integer> util) {
		if (util.searchElement(num)) {
			util.removeOrderedElement(num);
			System.out.println("found and removed");
			System.out.println(util);
		} else {
			util.addOrderedElement(num);
			System.out.println("number not found hence added");
			util.printList();
		}
	}

	/*
	 * function for adding elements to list at end position
	 * 
	 */
	/**
	 * @param data
	 */
	public void addElement(T data) {
		// creating a new_node
		Node new_node = new Node(data);
		if (head == null) {
			head = new_node;
			// if list is null making new_node has head
			size++;
		} else {
			Node node = head;
			// taking head into particular node
			while (node.next != null) {
				node = node.next;
			}
			node.next = new_node;
			size++;
		}
	}

	/*
	 * function for removing particular element
	 * 
	 */
	/**
	 * @param find
	 */
	public void removeElement(T find) {
		Node node = head;
		Node previous = null;
		if (head.data.equals(find)) {
			// if node data is equal to element it will removed from list
			head = head.next;
			size -= 1;
		}
		while (!node.data.equals(find)) {
			previous = node;
			node = node.next;
		}
		node = node.next;
		previous.next = node;
		node = null;
		size -= 1;

	}

	/*
	 * function for removing the particular position and
	 */
	/**
	 * @param position
	 * @return pop element
	 */
	@SuppressWarnings("unchecked")
	public T pop(int position) {
		int index = 0;
		Node node = head;
		// if the position was starting it will delete that node
		if (position == 0) {
			head = head.next;
			size--;
			return (T) node.data;
		}
		Node prev = null;
		while (index != position) {
			prev = node;
			node = node.next;
			index++;
		}
		prev.next = node.next;
		size -= 1;
		return (T) node.data;
	}

	/*
	 * function for removing the last index element of list
	 */
	/**
	 * @return pop element
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		Node node = head;
		if (size == 1) {
			head = head.next;
			size--;
			return (T) node.data;
		}
		while (node.next != null) {
			node = node.next;
		}
		T res = (T) node.data;
		node = node.next;
		size--;
		return res;
	}

	/*
	 * function for searching the element in the list
	 */
	/**
	 * @param find
	 * @return if it is present or not
	 */
	public boolean searchElement(T find) {
		Node node = head;
		while (node != null) {
			if (node.data.equals(find)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	/**
	 * function to add a new item in the list
	 * 
	 * @param data the item which to be added
	 */
	@SuppressWarnings("unchecked")
	public void addOrderedElement(T data) {

		Node node = head;
		Node new_node = new Node(data);
		size++;
		if (head == null) {
			// System.out.println("1st");
			head = new_node;
			head.next = tail;
			tail = head;
		} else if (data.compareTo((T) head.data) < 0) {
			// System.out.println("2nd");
			new_node.next = head;
			head = new_node;
		} else {
			if (data.compareTo((T) tail.data) > 0) {
				tail.next = new_node;
				tail = new_node;
				return;
			}
			Node prev = null;
			while (data.compareTo((T) node.data) > 0 && node.next != null) {
				prev = node;
				node = node.next;
			}
			prev.next = new_node;
			new_node.next = node;
		}
	}

	/**
	 * Function to remove the item from the list
	 * 
	 * @param item
	 */
	public void removeOrderedElement(T item) {
		Node node = head;
		Node prev = null;
		if (head.data.equals(item)) {
			head = head.next;
			size -= 1;
			return;
		} else if (tail.data.equals(item)) {
			while (!node.next.data.equals(tail.data)) {
				node = node.next;
			}
			node.next = null;
			tail = node;
			return;
		} else {
			while (!node.data.equals(item)) {
				prev = node;
				node = node.next;
			}
			node = node.next;
			prev.next = node;
			node = null;
			size -= 1;
		}
	}

	/*
	 * function to implement push the element to the stack
	 */
	/**
	 * @param character
	 */
	public void push(T character) {

		try {
			stack.push((Character) character);
			top++;
		} catch (Exception e) {
			System.out.println("stack is full");
		}

		if (stack.capacity() == stack.size()) {
			stack.ensureCapacity(capacity * 2);
		}

	}

	/*
	 * function to implement pop the element from the stack
	 */
	/**
	 * @param character
	 * @return pop element
	 */
	public T popCharacter(char character) {
		if (isEmptyStack()) {
			System.out.println("stack is empty and we can not pop ");
			return null;
		}
		@SuppressWarnings("unchecked")
		T popElement = (T) stack.pop();
		return popElement;

	}

	/*
	 * function to implement peek the top of element from stack
	 */
	/**
	 * @return top of stack element
	 */
	public T peekStack() {

		@SuppressWarnings("unchecked")
		T peekElement = (T) stack.peek();
		return peekElement;

	}

	/*
	 * function to implement size of stack
	 */
	/**
	 * @return size of stack
	 */
	public static int sizeOfStack() {

		return stack.size();

	}

	/*
	 * function to implement return the stack data
	 */
	/**
	 * @return stack data
	 */
	public static String toStringStack() {

		return stack.toString();

	}

	/*
	 * function to implement weather stack is empty or not
	 */
	/**
	 * @return weather empty or not
	 */
	public boolean isEmptyStack() {

		return stack.empty();
	}

	/*
	 * function to implement adding in queue
	 */
	public void enQueue() {
		int count = 0;
		try {
			System.out.println("enter how many customers are there :");
			count = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter in digits only...");
		}
		try {
			for (int index = 0; index <= count; index++) {
				System.out.println("  Enter your Name :  ");
				queue.add(scanner.next());
			}
		} catch (Exception e) {
			System.out.println("enter the name only...");
		}

	}

	/*
	 * function to implement deposit amount
	 */
	/**
	 * @param customername
	 * @param amount
	 * @return total amount
	 */
	private int depositCash(String customername, int amount) {

		bankAmount += amount;
		return bankAmount;

	}

	/*
	 * function to implement withdraw cash
	 */
	/**
	 * @param customername
	 * @param amount
	 * @return total amount
	 */
	private int withDrawCash(String customername, int amount) {

		bankAmount -= amount;

		return bankAmount;

	}

	/*
	 * function to implement dequeue in queue
	 */
	/**
	 * @return dequeue element
	 */
	public String deQueue() {
		do {
			String customername = null;

			for (int index = queue.size(); index > 0; index--) {
				customername = queue.peek();
			}

			int choice = 0;
			int amount = 0;
			System.out.println("Welcome to " + customername);

			try {
				System.out.println("select the choice 1.WithdrawMoney 2.DepositMoney ");
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Enter details correctly... ");
			}

			switch (choice) {

			case 1:
				try {
					System.out.println("Enter the amount to withdraw :");
					amount = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("enter amount digits...");
				}

				if (amount <= 50000) {
					System.out.println(customername + " has withdraw from account ");
					withDrawCash(customername, amount);
					System.out.println(customername + " withdraw amount is :" + amount);
					System.out.println("Final bank amount is : " + bankAmount);
					break;

				} else {
					System.out.println("daily withdraw amount limit is < 50000 only");
				}

			case 2:

				try {
					System.out.println("Enter the amount to depost :");
					amount = scanner.nextInt();

				} catch (Exception e) {
					System.out.println("enter amount in digits...");
				}

				System.out.println(customername + " has deposited amount into bank ");
				depositCash(customername, amount);
				System.out.println(customername + " deposited amount is :" + amount);
				System.out.println("Final bank amount is : " + bankAmount);
				break;

			default:

				System.out.println("Select only range between 1 - 2");
				break;
			}
			return queue.remove();

		} while (true);

	}

	/*
	 * function to implement queue size
	 */
	/**
	 * @return size of queue
	 */
	public int queueSize() {

		return queue.size();

	}

	/*
	 * function to implement queue is empty or not
	 */
	/**
	 * @return queue is empty or not
	 */
	public boolean isQueueEmpty() {

		return queue.isEmpty();

	}

	/*
	 * function to implement add character to dequeue in rear end
	 */
	/**
	 * @param data
	 */
	public void addRear(char data) {
		if (rear == -1) {
			rear = 0;
			front = 0;
		}
		deque.addLast(data);
		rear++;
	}

	/*
	 * function to implement add character to dequeue in front end
	 */
	/**
	 * @param data
	 */
	public void addFront(char data) {
		if (front == -1) {
			front = 0;
			rear = 0;
		}
		deque.addFirst(data);
		front++;
	}

	/*
	 * function to implement remove character at front end
	 */
	/**
	 * @param data
	 */
	public void removeFront(char data) {

		if (front == -1) {
			System.out.println("we can not remove element");
		} else {
			deque.removeFirst();
		}

	}

	/*
	 * function to implement remove character at rear end
	 */
	/**
	 * @param data
	 */
	public void removeRear(char data) {
		if (rear == -1) {
			System.out.println("we can not remove element");
		} else {
			deque.removeLast();
		}

	}

	/*
	 * function to implement return the size of dequeue
	 */
	/**
	 * @return size of dequeue
	 */
	public int deQueueSize() {

		return deque.size();

	}

	/*
	 * function to implement toString() to get the data
	 */
	/**
	 * @return data
	 */
	@SuppressWarnings("unchecked")
	public T deQueueToString() {

		return (T) deque.toString();

	}

	/*
	 * function to implement dequeue is empty or not
	 */
	/**
	 * @return isDequeueEmpty or not
	 */
	public boolean isDequeEmpty() {

		return deque.isEmpty();

	}

	/*
	 * function to implement finding primenumbers of range
	 */
	/**
	 * 
	 */
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> anagramnumbers = new ArrayList<Integer>();

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
				// System.out.println("prime numbers are :"+number);
				list.add(number);
			}

		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (primeAnagram(list.get(i), list.get(j))) {
					anagramnumbers.add(list.get(i));
					anagramnumbers.add(list.get(j));
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
	 */
	/**
	 * @param number1
	 * @param number2
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
	 */
	/**
	 * @param number
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
	public static void twoDimentionalArray() {
		// int rowno = 12;
		// int colno = 13;
		// int[][] twodArray = new int[rowno][colno];
		int index = 0;
		for (int row = 0; row < rowno; row++) {
			for (int col = 0; col < colno; col++) {
				twodArray[row][col] = anagramnumbers.get(index);
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
	 */
	public static void pushStack(int twodArray2) {

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

	public static void popStack() {
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
	 */
	public static void enQueuePrime(int twodArray2) {

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
	public static void deQueuePrime() {

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

}
