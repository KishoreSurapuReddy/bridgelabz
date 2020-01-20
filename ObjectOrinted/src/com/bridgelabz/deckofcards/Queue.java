package com.bridgelabz.deckofcards;

import com.bridgelabz.deckofcards.Node;


public class Queue {
	Node head;

	/*
	 * function to implement enqueue in Queue
	 */
	public void enQueue(String item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	/*
	 * function to implement dequeue in queue
	 */
	public void deQueue() {
		Node node = head;
		if (node == null) {
			System.out.println("queue is empty..");
		} else {
			while (node != null) {
				System.out.println("sorted deck :" + node.data);
				node = node.next;
			}
		}
	}

}
