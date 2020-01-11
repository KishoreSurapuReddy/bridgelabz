/*
 *Purpose: it will take the arithmetic expression as a input and it will check the each
 *  character in expression if it is '(' added to stack , if it is ')' 
 *  pop from stack
*/
/**
 * @author kishorereddy
 * 
 */
package com.bridgelabz.datastructures;

import com.bridgelabz.util.StackList;

public class StackBalancedParanthesis {

	public static void main(String[] args) {

		StackList<Character> stack = new StackList<Character>();

		/*
		 * given string expression
		 */
		String expression = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/*(4+3)";

		for (int index = 0; index < expression.length(); index++) {
			/*
			 * adding the each character to character
			 */
			char character = expression.charAt(index);

			if (character == '(' || character == ')') {
				/*
				 * compare each character with '(' if it is match with char it will push into
				 * stack
				 */
				stack.pushCharacter(character);
			}
		}
		stack.popCharacter();
		/*
		 * assign the stack result to result
		 */
		boolean result = stack.balancedStack();

		if (result == true) {
			/*
			 * if stack is empty expression was balanced
			 */
			System.out.println("given arthemetic expression was balanced ");
		} else {
			/*
			 * if stack not empty expression was not balanced
			 */
			System.out.println(" given arthemetic expression was not balanced");
		}

	}

}
