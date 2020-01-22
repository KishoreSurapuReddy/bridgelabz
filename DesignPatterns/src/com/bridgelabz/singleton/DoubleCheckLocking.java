/*purpose:it will create a instance with synchronized access method
 * @author kishorereddy
 * @version 1.0
 * @since 21/1/2020
 * @file DoubleCheckLocking.java
*/
package com.bridgelabz.singleton;

public class DoubleCheckLocking {
	
	private static DoubleCheckLocking instance;
	
	private DoubleCheckLocking(){
		
	}
	public static DoubleCheckLocking getInstance(){
		if(instance == null){
			synchronized(DoubleCheckLocking.class){
				if(instance == null){
					instance = new DoubleCheckLocking();
				}
			}
		}
		return instance;
	}

}
