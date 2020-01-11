package com.bridgelabz.util;

import java.util.Scanner;

import com.bridgelabz.datastructures.Node;

public class QueueList {

	Node left, right;

	int size = 0;

	/*
	 * initialize the bank amount with 100000
	 */
	private int bankAmount = 100000;

	public Scanner scanner = new Scanner(System.in);

	/*
	 * function to implement enQueue
	 * 
	 * @param customer
	 */
	public void enQueue(String customer) {
		Node newNode = new Node(customer);

		if (left == null) {
			left = right = newNode;
		} else {
			right.next = newNode;
			right = newNode;
		}
		size++;

	}

	/*
	 * function to implement dequeue
	 */
	public void deQueue() {

		@SuppressWarnings("unused")
		Node current;

		if (left == null) {
			System.out.println("queue is empty");
		} else {
			do {
				while (left != null) {
					String customername = (String) left.data;
					System.out.println("customer name :" + customername);
					int choice = 0;
					int amount = 0;
					try {
						System.out.println("select the choice 1.WithdrawMoney 2.DepositMoney ");
						choice = scanner.nextInt();
					} catch (Exception e) {
						System.out.println("Enter details correctly... ");
					}

					switch (choice) {

					case 1:
						try {
							System.out.println("Enter the amount to withdraw :");
							amount = scanner.nextInt();
						} catch (Exception e) {
							System.out.println("enter amount digits...");
						}

						if (amount <= 50000) {
							System.out.println(customername + " has withdraw from account ");
							withDrawCash(customername, amount);
							System.out.println(customername + " withdraw amount is :" + amount);
							System.out.println("Final bank amount is : " + bankAmount);
							break;

						} else {
							System.out.println("daily withdraw amount limit is < 50000 only");
						}

					case 2:

						try {
							System.out.println("Enter the amount to depost :");
							amount = scanner.nextInt();

						} catch (Exception e) {
							System.out.println("enter amount in digits...");
						}

						System.out.println(customername + " has deposited amount into bank ");
						depositCash(customername, amount);
						System.out.println(customername + " deposited amount is :" + amount);
						System.out.println("Final bank amount is : " + bankAmount);
						break;

					default:

						System.out.println("Select only range between 1 - 2");
						break;
					}
					current = left;
					left = left.next;
					current = null;

				}
			} while (true);
		}
	}

	/*
	 * function to implement isQueueEmpty
	 * 
	 * @return empty or not
	 */
	public boolean isQueueEmpty() {
		if (left == null) {
			return true;
		}
		return false;

	}

	/*
	 * function to implment size of queue
	 */
	public int sizeOfQueue() {
		return size;

	}

	/*
	 * function to implement deposit amount
	 * 
	 * @param customername
	 * 
	 * @param amount
	 * 
	 * @return total amount
	 */
	public int depositCash(String customername, int amount) {

		bankAmount += amount;
		return bankAmount;

	}

	/*
	 * function to implement withdraw cash
	 * 
	 * @param customername
	 * 
	 * @param amount
	 * 
	 * @return total amount
	 */
	public int withDrawCash(String customername, int amount) {

		bankAmount -= amount;

		return bankAmount;

	}


}
