/*purpose:declare interface of ChatMediator
 * @author kishorereddy
 * @version 1.0
 * @since 23/01/2020
 * @file ChatMediator.java
*/
package com.bridgelabz.mediator;

public interface ChatMediator {
	//abstract methods
	public void sendMessage(String message , User user);
	public void addUser(User user);

}
