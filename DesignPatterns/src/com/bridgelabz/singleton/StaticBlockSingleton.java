/*purpose:it will create a instance in static block to handle exception
 * @author kishorereddy
 * @version 1.0
 * @since 21/1/2020
 * @file StaticBlockSingleton.java
*/
package com.bridgelabz.singleton;

public class StaticBlockSingleton {
	
	private static StaticBlockSingleton instance ;
	
	private StaticBlockSingleton(){
		
	}
	static{
		try{
			instance = new StaticBlockSingleton();
		}catch(Exception e){
			throw new RuntimeException("exception occured ");
		}
	}
	
	public static StaticBlockSingleton getInstance(){
		return instance;
		
	}

}
