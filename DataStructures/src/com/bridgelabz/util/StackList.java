package com.bridgelabz.util;

public class StackList<T extends Comparable<T>> {

	Node top;
	int size = 0;
	int push = 0;
	int pop = 0;

	public StackList() {
		top = null;
	}

	/*
	 * function to implement push the element to the stack
	 * 
	 * @param character
	 */
	public void pushCharacter(T character) {
		Node newNode = new Node(character);

		if (top == null) {
			top = newNode;
			newNode.next = null;
		} else {
			newNode.next = top;
			top = newNode;
		}
		size++;

	}

	/*
	 * function to implement pop the element from the stack
	 * 
	 * @param character
	 * 
	 * @return pop element
	 */
	@SuppressWarnings("unused")
	public void popCharacter() {
		Node current;
		if (isEmptyStack()) {
			System.out.println("stack is empty and we can not pop ");

		}
		while (top != null) {
			System.out.println(top.data);
			if (top.data.equals('(')) {
				push++;
			} else {
				pop++;
			}
			current = top;
			top = top.next;
			current = null;
		}

	}

	/*
	 * function to implement peek the top of element from stack
	 */
	public Object peekStack() {
		if (top == null) {
			System.out.println("stack is empty");
			return null;
		}

		return top.data;

	}

	/*
	 * function to implement size of stack
	 * @return size of stack
	 */
	public int sizeOfStack() {

		return size;

	}

	/*
	 * function to implement weather stack is empty or not
	 * @return weather empty or not
	 */
	public boolean isEmptyStack() {
		if (top.data == null) {
			return true;
		}

		return false;
	}

	public boolean balancedStack() {
		boolean isbalanced = false;
		if (push == pop) {
			isbalanced = true;
		}
		return isbalanced;
	}

}
