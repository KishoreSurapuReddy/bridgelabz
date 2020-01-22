/*purpose:proxy pattern will be used and if serverhost is controlled and 
 * denied if it is in restricted list
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file ProxyInternet.java
*/
package com.bridgelabz.proxypattern;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
	
	private Internet internet = new InternetImpl();
	private static List<String> list;
	
	static {
		list = new ArrayList<String>();
		list.add("abc.com");
		list.add("xyz.com");
		list.add("pqr.com");
	}
	@Override
	public void connectTo(String serverhost) throws Exception {
		if(list.contains(serverhost)) {
			throw new Exception("Access denied.");
		}
		internet.connectTo(serverhost);
		
	}

}
