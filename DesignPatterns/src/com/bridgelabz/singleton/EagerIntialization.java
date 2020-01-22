/*purpose:it will create a instance
 * @author kishorereddy
 * @version 1.0
 * @since 21/1/2020
 * @file EagerIntialization.java
*/
package com.bridgelabz.singleton;

public class EagerIntialization {
	//creating instance
	private static final EagerIntialization instance = new EagerIntialization();
	
	private EagerIntialization(){
		
	}
	//method to get instance
	public static EagerIntialization getInstace(){
		
		return instance;
		
	}

}

