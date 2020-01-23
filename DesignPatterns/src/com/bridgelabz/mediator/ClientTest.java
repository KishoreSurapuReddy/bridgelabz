/*purpose: Mediator pattern will be mediator between users to transfer data
 * @author kishorereddy
 * @version 1.0
 * @since 23/01/2020
 * @file ClientTest.java
*/
package com.bridgelabz.mediator;

public class ClientTest {

	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "kishore");
		User user2 = new UserImpl(mediator, "sai");
		User user3 = new UserImpl(mediator , "abhi");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		user1.sendMessage("hii hello");

	}

}
