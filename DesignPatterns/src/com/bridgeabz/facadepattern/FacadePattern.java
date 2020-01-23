/*purpose:Facadepattern to interact with interfaces
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file FacadePattern.java
*/
package com.bridgeabz.facadepattern;

public class FacadePattern {
	Phone iphone;
	Phone moto;
	Phone nokia;
	public FacadePattern() {
		iphone = new IPhone();
		moto = new Moto();
		nokia = new Nokia();
	}
	public String iphone() {
		return iphone.mobile();
	}
	public String moto() {
		return moto.mobile();
	}
	public String nokia() {
		return nokia.mobile();
	}

}
