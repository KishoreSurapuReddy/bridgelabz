package com.bridgelabz.util;

import java.util.Scanner;

public class BinarySearchTree {

	public Scanner scanner = new Scanner(System.in);

	class Node {
		int key;
		Node left, right;

		// constructor for Node class
		public Node(int data) {
			key = data;
			left = right = null;
		}
	}

	Node head;

	/*
	 * function to implement insert node to binary search tree
	 * @param item
	 */
	public void insertNode(int item) {
		head = insertInOrder(head, item);
	}

	/*
	 * fuction to implement insert node at particular position
	 * @param root
	 * @param item
	 * @return node
	 */
	public Node insertInOrder(Node root, int item) {

		if (root == null) {
			root = new Node(item);
			return root;
		}

		if (item < root.key) {
			root.left = insertInOrder(root.left, item);
		} else if (item > root.key) {
			root.right = insertInOrder(root.right, item);
		}
		return root;
	}
	/*
	 * function to implemet making tree as ordered
	 */
	public void inOrder() {
		makeOrdered(head);
	}

	public void makeOrdered(Node root) {
		if (root != null) {
			makeOrdered(root.left);
			System.out.println(" " + root.key);
			makeOrdered(root.right);
		}

	}

	/*
	 * function to find factorial of number
	 * @param num
	 * @return factorial
	 */
	public int factorial(int num) {
		int start = 1;
		for (int index = 1; index <= num; index++) {
			start = start * index;
		}
		return start;
	}

	/*
	 * function to implement finding noof trees generate by nodes
	 * @param number
	 * @return noof trees formed
	 */
	public int noOfTrees(int number) {
		int numerator = factorial(2 * number);
		int denominator = factorial((number + 1)) * factorial(number);
		return number = numerator / denominator;

	}

}