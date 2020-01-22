/*purpose:To find voltage and by using adapter we will convert volts according 
 * to our needs
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file AdapterPatternTest.java
*/
package com.bridgelabz.adapter;

public class AdapterPatternTest {

	public static void main(String[] args) {
		testClassAdapter();
		testObjectAdapter();

	}
    //by using object
	private static void testObjectAdapter() {
		SocketAdapter socket = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(socket,3);
		Volt v12 = getVolt(socket, 12);
		Volt v120 = getVolt(socket, 120);
		System.out.println("v3 volts using object adapter :"+v3.getVolts());
		System.out.println("v12 volts using object adapter :"+v12.getVolts());
		System.out.println("v120 volts using object adapter :"+v120.getVolts());
	}
    //by using class
	private static void testClassAdapter() {
		SocketAdapter socket = new SocketClassAdapterImpl();
		Volt v3 = getVolt(socket,3);
		Volt v12 = getVolt(socket, 12);
		Volt v120 = getVolt(socket, 120);
		System.out.println("v3 volts using class adapter :"+v3.getVolts());
		System.out.println("v12 volts using class adapter :"+v12.getVolts());
		System.out.println("v120 volts using class adapter :"+v120.getVolts());
		
	}
	private static Volt getVolt(SocketAdapter socket, int volt) {
		switch(volt) {
		case 3:
			return socket.get3Volt();
		case 12:
			return socket.get12Volt();
		case 120:
			return socket.get120Volt();
		default:
			return socket.get120Volt();
		}
	}


}
