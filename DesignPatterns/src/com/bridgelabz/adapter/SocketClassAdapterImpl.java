/*purpose:implementing abstract methods by class we will get values
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file SocketAdapterImpl.java
*/
package com.bridgelabz.adapter;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get120Volt() {
		return getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt volt = getVolt();
		return convertVolt(volt, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt  volt = getVolt();
		return convertVolt(volt, 40);
	}
	
	public Volt convertVolt(Volt volt , int i) {
		return new Volt(volt.getVolts() / i);
		
	}

}
