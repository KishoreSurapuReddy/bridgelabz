/*purpose:To get apecification of Computer 
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file ComputerFactoryTest.java
*/
package com.bridgelabz.factory;

public class ComputerFactoryTest {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
		Computer server = ComputerFactory.getComputer("server", "8 GB", "2 TB", "2.9 GHz");
		
		System.out.println("pc configuration :"+pc);
		System.out.println("server configuration"+server);
	}

}
