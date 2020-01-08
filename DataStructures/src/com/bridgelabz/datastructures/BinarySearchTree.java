
/*Purpose:creating a binary tree and inserting nodes to the tree and
 * finding the number of binary search trees are formed by using nodes
 * 
*/
package com.bridgelabz.datastructures;

/**
 * @author kishorereddy
 *
 */
public class BinarySearchTree {

	class Node {
		// constructor for Node class
		//
		int key;
		Node left, right;

		public Node(int data) {
			key = data;
			left = right = null;
		}

	}

	static Node root;

	public BinarySearchTree() {
		root = null;
	}

	/*
	 * function to implement insert node to binary search tree
	 */
	/**
	 * @param item
	 */
	public void insertNode(int item) {
		root = insertInOrder(root, item);
	}

	/*
	 * fuction to implement insert node at particular position
	 */
	/**
	 * @param root
	 * @param item
	 * @return node
	 */
	private Node insertInOrder(Node root, int item) {

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
		makeOrdered(root);
	}

	private void makeOrdered(Node root) {
		if (root != null) {
			makeOrdered(root.left);
			System.out.println(" " + root.key);
			makeOrdered(root.right);
		}

	}

	/*
	 * function to find factorial of number
	 */
	/**
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
	 */
	/**
	 * @param number
	 * @return noof trees formed 
	 */
	public int noOfTrees(int number) {
		int numerator = factorial(2 * number);
		int denominator = factorial((number + 1)) * factorial(number);
		return number = numerator / denominator;

	}

	public static void main(String[] args) {
		Utility<Integer> util = new Utility<Integer>();
		BinarySearchTree binary = new BinarySearchTree();
		System.out.println("enter the number how many nodes want to add :");
		int number = 0;
		try {
			number = util.scanner.nextInt();
			System.out.println("enter the nodes :");
			for (int index = 1; index <= number; index++) {
				binary.insertNode(util.scanner.nextInt());
			}
		} catch (Exception e) {
			System.out.println("enter int type of data only...");
		}
		binary.inOrder();
		int total = binary.noOfTrees(number);
		System.out.println(total);

	}

}
