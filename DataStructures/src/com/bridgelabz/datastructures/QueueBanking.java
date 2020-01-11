/*
 *Purpose:take a queue and add customers into it and according to queue
 * and customer option performing withdraw and deposit operation and finally display total
 *  of bank amount and make queue as balanced
 *  @author kishorereddy
*/
package com.bridgelabz.datastructures;

import com.bridgelabz.util.QueueList;

public class QueueBanking {

	public static void main(String[] args) {
		/*
		 * instance of Utility class
		 */
		QueueList queue = new QueueList();
		System.out.println("---------------------");
		System.out.println("  Welcome to Bank    ");
		System.out.println("how many memebers are in queue:");
		int members = queue.scanner.nextInt();
		for (int memeber = 1; memeber <= members; memeber++) {
			System.out.println("enter the name :");
			queue.enQueue(queue.scanner.next());
		}
		do {
			queue.deQueue();
		}
		/*
		 * Repeat until queue get null
		 */
		while (!queue.isQueueEmpty());
	}

}
