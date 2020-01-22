package com.bridgeabz.facadepattern;

public class ClientTest {
	
	public static void main(String[] args) {
		FacadePattern facade = new FacadePattern();
		System.out.println(facade.iphone());
		System.out.println(facade.moto());
		System.out.println(facade.nokia());
	}

}
