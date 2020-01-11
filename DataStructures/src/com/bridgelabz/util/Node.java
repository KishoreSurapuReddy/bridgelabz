/*
 * it will initialize the node in the list
 * @author kishorereddy
 */
package com.bridgelabz.util;

public class Node {

	Object data;
	Node next;
	Node left, right;
	Node prev;

	// constructor for Node class
	public Node(Object data) {
		super();
		this.data = data;
		this.next = null;
		this.left = this.right = null;
	}

}
