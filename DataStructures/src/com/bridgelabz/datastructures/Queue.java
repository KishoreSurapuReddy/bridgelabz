/*
 *Purpose:take a queue and and customers into it and according to queue
 * and customer option performing withdraw and deposit and finally display total
 *  of bank amount and make queue as balanced
*/
package com.bridgelabz.datastructures;

/**
 * @author kishorereddy
 *
 */
public class Queue {

	public static void main(String[] args) {
		/*
		 * instance of Utility class
		 */
		Utility<String> util = new Utility<String>();
		System.out.println("---------------------");
		System.out.println("  Welcome to Bank    ");
		/*
		 * calling enqueue function
		 */
		util.enQueue();
		do {
			/*
			 * calling dequeue function
			 */
		util.deQueue();
		System.out.println("final Queue is :" +Utility.queue);
		}
		/*
		 * Repeat until queue get null
		 */
		while(!util.queueIsEmpty());
	}

}
