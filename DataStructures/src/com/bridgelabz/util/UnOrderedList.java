package com.bridgelabz.util;

import java.util.Scanner;

import com.bridgelabz.datastructures.Node;

public class UnOrderedList<T extends Comparable<T>> {

	Node head;

	public int size = 0;

	/*
	 * creating the scanner object
	 */
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
	 * function for adding elements to list at end position
	 * 
	 * @param data
	 */
	public void addElement(T data) {

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
	 * @param find
	 */
	public void removeElement(T find) {
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

}
