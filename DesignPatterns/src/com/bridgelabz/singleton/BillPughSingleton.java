/*purpose:it will be used to access the instance of class
 * @author kishorereddy
 * @version 1.0
 * @since 21/1/2020
 * @file BillPughSingleton.java
*/
package com.bridgelabz.singleton;

public class BillPughSingleton {
	
	private BillPughSingleton(){
		System.out.println("billpughsingleton");
	}
	private static class BillPughInner{
		private static final BillPughSingleton instance = new BillPughSingleton();
	}
	public static BillPughSingleton getInstance(){
		return BillPughInner.instance;
	}

}
