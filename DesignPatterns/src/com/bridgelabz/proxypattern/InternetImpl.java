/*purpose:implementing abstract method
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file InternetImpl.java
*/
package com.bridgelabz.proxypattern;

public class InternetImpl implements Internet {

	@Override
	public void connectTo(String serverhost) {
		
		System.out.println("Connecting to "+serverhost);
		
	}

}
