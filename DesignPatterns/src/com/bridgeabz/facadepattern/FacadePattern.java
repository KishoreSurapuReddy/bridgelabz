package com.bridgeabz.facadepattern;

public class FacadePattern {
	IPhone iphone;
	Moto moto;
	Nokia nokia;
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
