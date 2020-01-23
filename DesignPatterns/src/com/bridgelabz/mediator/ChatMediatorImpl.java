/*purpose:implementing ChatMediator interface 
 * @author kishorereddy
 * @version 1.0
 * @since 23/01/2020
 * @file ChatMediatorImpl.java
*/
package com.bridgelabz.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
	List<User> users;

	public ChatMediatorImpl() {
		users = new ArrayList<User>();
	}
    //function to implement send message to users
	@Override
	public void sendMessage(String message, User user) {
		for(User u : users) {
			if(u != user) {
				u.receiveMessage(message);
			}
		}
		
	}
    //add users
	@Override
	public void addUser(User user) {
		this.users.add(user);
		
	}

}
