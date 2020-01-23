/*purpose:implementation of User interface 
 * @author kishorereddy
 * @version 1.0
 * @since 23/01/2020
 * @file UserImpl.java
*/
package com.bridgelabz.mediator;

public class UserImpl extends User {

	public UserImpl(ChatMediator mediator, String name) {
		super(mediator, name);
	}
    //function to send message
	@Override
	public void sendMessage(String message) {
		System.out.println(this.name+" :sending messgage :"+message);
		mediator.sendMessage(message, this);
		
	}
    //function to receive message
	@Override
	public void receiveMessage(String message) {
		System.out.println(this.name+ " : received message:"+message);
		
	}

}
