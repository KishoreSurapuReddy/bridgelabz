package com.bridgelabz.deckofcards;
import com.bridgelabz.deckofcards.Node;
public class Queue {
	 Node head;
	public  void enQueue(String item) {
		Node newNode = new Node(item);
		if(head == null) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}
	public void deQueue() {
		Node node = head ;
		if(node == null) {
			System.out.println("queue is empty..");
		}else {
			while(node != null) {
				System.out.println("sorted deck :"+node.data);
				node = node.next;
			}
		}
	}

}
