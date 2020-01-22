/*purpose:implementing abstract methods and by object we will get values
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file SocketObjectAdapterImpl.java
*/
package com.bridgelabz.adapter;

public class SocketObjectAdapterImpl implements SocketAdapter {
	//instance of Socket
	Socket socket = new Socket();

	@Override
	public Volt get120Volt() {
		return socket.getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt volt = socket.getVolt();
		return convertVolt(volt, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt volt = socket.getVolt();
		return convertVolt(volt, 40);
	}
	
	public Volt convertVolt(Volt volt , int i) {
		return new Volt(volt.getVolts() / i);
	}

}
