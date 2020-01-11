package com.bridgelabz.util;

import java.util.Scanner;

import com.bridgelabz.datastructures.Node;

public class OrderedList<T extends Comparable<T>> {

	Node head, tail;

	public int size = 0;

	public Scanner scanner = new Scanner(System.in);

	/*
	 * function for inserting element at particular position in the list
	 * 
	 * @param <T>
	 * 
	 * @param position
	 * 
	 * @param data
	 */
	@SuppressWarnings("hiding")
	public <T> void insertParticularPosition(int position, T data) {
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

		if (head == null) {
			new_node.next = head;
			head = new_node;
		} else {

			while (position != index) {
				node = node.next;
				index++;
			}

			new_node.next = node.next;
			node.next = new_node;

		}
	}

	/*
	 * function for size of list
	 * 
	 * @return size
	 */
	public int sizeOfList() {
		return size;
	}

	/*
	 * function for reading the data from list
	 * 
	 * @return toString
	 */
	public String toString() {
		StringBuffer stringbuffer = new StringBuffer();

		Node node = head;
		stringbuffer.append("[ ");
		while (node != null) {
			stringbuffer.append(node.data);

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
	 * 
	 * @return empty or not
	 */
	public boolean isListEmpty() {
		Node node = head;
		if (node == null) {
			return true;
		}

		return false;

	}

	/*
	 * function for finding the index position
	 * 
	 * @param <T>
	 * 
	 * @param data
	 * 
	 * @return index position
	 */
	@SuppressWarnings("hiding")
	public <T> int index(T data) {
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
	 * 
	 * @param num
	 * 
	 * @param util
	 */
	public static void addRemove(int num, OrderedList<Integer> list) {
		if (list.searchElement(num)) {
			list.removeOrderedElement(num);
			System.out.println("found and removed");
			System.out.println(list);
		} else {
			list.addOrderedElement(num);
			System.out.println("number not found hence added");
			list.printList();
		}
	}

	/*
	 * function for adding elements to list at end position
	 * 
	 * @param <T>
	 * 
	 * @param data
	 */
	@SuppressWarnings("hiding")
	public <T> void addElement(T data) {
		Node new_node = new Node(data);
		if (head == null) {
			head = new_node;
			size++;
		} else {
			Node node = head;
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
	 * @param <T>
	 * 
	 * @param find
	 */
	@SuppressWarnings("hiding")
	public <T> void removeElement(T find) {
		Node node = head;
		Node previous = null;
		if (head.data.equals(find)) {
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
	 * 
	 * @param <T>
	 * 
	 * @param position
	 * 
	 * @return pop element
	 */
	@SuppressWarnings("unchecked")
	public T pop(int position) {
		int index = 0;
		Node node = head;
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
	 * 
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
	 * 
	 * @param find
	 * 
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
	 * @param <T>
	 * @param data the item which to be added
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> void addOrderedElement(T data) {

		Node node = head;
		Node new_node = new Node(data);
		size++;
		if (head == null) {
			// System.out.println("1st");
			head = new_node;
			head.next = tail;
			tail = head;
		} else if (((Comparable<T>) data).compareTo((T) head.data) < 0) {
			// System.out.println("2nd");
			new_node.next = head;
			head = new_node;
		} else {
			if (((Comparable<T>) data).compareTo((T) tail.data) > 0) {
				tail.next = new_node;
				tail = new_node;
				return;
			}
			Node prev = null;
			while (((Comparable<T>) data).compareTo((T) node.data) > 0 && node.next != null) {
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
	 * @param <T>
	 * @param item
	 */
	@SuppressWarnings("hiding")
	public <T> void removeOrderedElement(T item) {
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
