/*purpose:it will create a instance with synchronized global access method
 * @author kishorereddy
 * @version 1.0
 * @since 21/1/2020
 * @file ThreadSafeSingleton.java
*/
package com.bridgelabz.singleton;

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton instance ;
	
	private ThreadSafeSingleton(){
		
	}
	//allowing only one thread
	public static synchronized ThreadSafeSingleton getInstance(){
		if(instance == null){
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

}
