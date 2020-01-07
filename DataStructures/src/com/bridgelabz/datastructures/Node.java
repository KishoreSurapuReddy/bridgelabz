/*
 * it will initialize the node in the list
*/
package com.bridgelabz.datastructures;

/**
 * @author kishorereddy
 *
 */
public class Node {
	// constructor for Node class
	//
	Object data;
	Node next;
	Node left,right;
	
	public Node(Object data) {
		super();
		this.data = data;
		this.next = null;
		this.left = this.right = null;
	}

}
