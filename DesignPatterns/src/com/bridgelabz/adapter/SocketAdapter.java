/*purpose: abstract methods for Volts
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file SocketAdapter.java
*/
package com.bridgelabz.adapter;

public interface SocketAdapter {
	//abstract methods
	public Volt get120Volt();
	public Volt get12Volt();
	public Volt get3Volt();

}
