/*purpose:it will create a instance useful for global access
 * @author kishorereddy
 * @version 1.0
 * @since 21/1/2020
 * @file LazyIntialization.java
*/
package com.bridgelabz.singleton;

public class LazyIntialization {
	
	private static LazyIntialization instance;
	
	private LazyIntialization(){
		
	}
	
	public static LazyIntialization getInstance(){
		if(instance == null ){
			instance = new LazyIntialization();
		}
		return instance;
	}

}
