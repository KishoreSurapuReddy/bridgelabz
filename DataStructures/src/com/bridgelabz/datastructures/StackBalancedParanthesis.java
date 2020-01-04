/*
 *Purpose: it will take the arithmetic expression and it will check the each
 *  character in expression if it is '(' added to stack , if it is ')' 
 *  pop from stack
*/
/**
 * @author kishorereddy
 * 
 */
package com.bridgelabz.datastructures;

public class StackBalancedParanthesis {

	public static boolean checkCharacter(String expression) {
		/*
		 * creating the instance of Utility class to access the functions
		 */
		Utility<Character> util = new Utility<>();

		for (int index = 0; index < expression.length(); index++) {
			/*
			 * adding the each character to character
			 */
			char character = expression.charAt(index);

			if (character == '(') {
				/*
				 * compare each character with '(' if it is match with char it will push into
				 * stack
				 */
				util.push(character);

			} else {

				if (character == ')') {
					/*
					 * compare each character with ')' if it is match with char it will pop from
					 * stack
					 */
					util.popCharacter(character);
				}
			}
		}
		/*
		 * return stack is empty or not
		 */
		return util.isEmptyStack();

	}

	public static void main(String[] args) {
		/*
		 * given string expression
		 */
		String expression = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/*((4+3)";
		/*
		 * printing the stack
		 */
		System.out.println(Utility.toStringStack());
		/*
		 * assign the stack result to result
		 */
		boolean result = checkCharacter(expression);
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
