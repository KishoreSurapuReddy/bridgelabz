/*purpose:To check serverhost
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file ClientTest.java
*/
package com.bridgelabz.proxypattern;

public class ClientTest {

	public static void main(String[] args) {
		Internet internet = new ProxyInternet();
		try {
			internet.connectTo("abc.com");
			internet.connectTo("google.com");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
