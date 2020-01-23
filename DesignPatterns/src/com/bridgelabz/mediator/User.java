/*purpose:declare interface of User
 * @author kishorereddy
 * @version 1.0
 * @since 23/01/2020
 * @file User.java
*/
package com.bridgelabz.mediator;

public abstract class User {
	
	protected ChatMediator mediator;
	protected String name;
	//constructor
	public User(ChatMediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}
	//abstract methods 
	public abstract void sendMessage(String message);
	public abstract void receiveMessage(String message);

}
