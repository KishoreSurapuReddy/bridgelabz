/*purpose:it will used to create instance
 * @author kishorereddy
 * @version 1.0
 * @since 21/1/2020
 * @file SerializedSingleTon
*/
package com.bridgelabz.singleton;

public class SerializedSingleTon {
	
	private SerializedSingleTon(){
		
	}
	private static class SerializedInner{
		private static final SerializedSingleTon instance = new SerializedSingleTon();
	}

	public static SerializedSingleTon getInstance(){
		
		return SerializedInner.instance;
		
	}
}
