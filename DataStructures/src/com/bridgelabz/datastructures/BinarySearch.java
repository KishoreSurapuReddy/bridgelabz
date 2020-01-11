
/*Purpose:creating a binary tree and inserting nodes to the tree and
 * finding the number of binary search trees are formed by using nodes
 * @author kishorereddy
*/
package com.bridgelabz.datastructures;

import com.bridgelabz.util.BinarySearchTree;

public class BinarySearch {

	public static void main(String[] args) {

		BinarySearchTree binary = new BinarySearchTree();

		System.out.println("enter the number how many nodes want to add :");
		int number = 0;
		try {
			number = binary.scanner.nextInt();
			System.out.println("enter the nodes :");
			for (int index = 1; index <= number; index++) {
				binary.insertNode(binary.scanner.nextInt());
			}
		} catch (Exception e) {
			System.out.println("enter int type of data only...");
		}
		binary.inOrder();
		int total = binary.noOfTrees(number);
		System.out.println("number of trees formed using " + number + " is " + total);

	}

}
