package com.bridgelabz.util;

import java.util.Scanner;

public class DeQueueList<T extends Comparable<T>> {
	Node left, right;
	Node prev;
	int size = 0;

	public DeQueueList() {
		left = right = null;
	}

	public Scanner scanner = new Scanner(System.in);

	/*
	 * function to implement add character to dequeue in rear end
	 * @param data
	 */
	public void addRear(char data) {
		Node newNode = new Node(data);
		if (left == null) {
			left = right = newNode;
			left.prev = null;
			right.next = null;
		} else {
			right.next = newNode;
			newNode.prev = right;
			right = newNode;
		}
		size++;
	}

	/*
	 * function to implement add character to dequeue in front en
	 * @param data
	 */
	public void addFront(char data) {
		Node newNode = new Node(data);
		left.prev = newNode;
		newNode.next = left;
		newNode.prev = null;
		left = newNode;
		size++;

	}

	/*
	 * function to implement remove character at front end
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public T removeFront() {
		Node prevnode;
		if (left == null) {
			System.out.println("dequeue is empty ");
		} else {
			System.out.println(left.data);
			T charcter = (T) left.data;
			prevnode = left;
			left = left.next;
			prevnode.next = null;
			return charcter;
		}
		return null;

	}

	/*
	 * function to implement remove character at rear end 
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public T removeRear() {
		Node prevnode;
		if (right == null) {
			System.out.println("deQueue is empty");
		} else {
			System.out.println(right.data);
			T character = (T) right.data;
			prevnode = right;
			right = right.prev;
			prevnode.prev = null;
			return (T) character;
		}
		return null;

	}

	/*
	 * function to implement return the size of dequeue 
	 * @return size of dequeue
	 */
	public int deQueueSize() {

		return size;

	}

	/*
	 * function to implement dequeue is empty or not
	 * @return isDequeueEmpty or not
	 */
	public boolean isDequeEmpty() {
		boolean isDeQueue = false;
		if (left != null) {
			isDeQueue = true;
		}

		return isDeQueue;

	}

	/*
	 * funcrtion to implement given string is palindrome or not
	 */
	public boolean isPalindrome() {
		Character name1 = ' ';
		Character name2 = ' ';
		boolean ispalindrome = false;
		int size = deQueueSize();

		if (size % 2 == 0) {
			while (size != 0) {
				name1 = (Character) removeFront();
				name2 = (Character) removeRear();
				size--;
			}
			if (name1.equals(name2)) {
				ispalindrome = true;
			}

		} else if (size % 2 == 1) {
			System.out.println("deque contains insufficient  character ");
		} else {
			System.out.println("deque contains only one chatracter ");
		}
		return ispalindrome;
	}

}
