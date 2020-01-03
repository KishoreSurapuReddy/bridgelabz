package com.bridgelabz.datastructures;

import java.util.Scanner;

public class Utility<T extends Comparable<T>> {

	public static Node head; // head of list
	private static int size = 0;
	private static Node tail;
	Scanner scanner = new Scanner(System.in);

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
	public static int size() {
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
	public static boolean isEmpty() {
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
		while (node.next != null) {
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

}
