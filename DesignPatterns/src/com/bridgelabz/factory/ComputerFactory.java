/*purpose:FactoryPattern to interact with interfaces according to user requirement
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file ComputerFactory.java
*/
package com.bridgelabz.factory;

public class ComputerFactory {
	//by user type it will instantiate
	public static Computer getComputer(String type , String ram , String hdd , String cpu){
		if("PC".equalsIgnoreCase(type)){
			return new PC(ram, hdd, cpu);
		}else if("SERVER".equalsIgnoreCase(type)){
			return new Server(ram, hdd, cpu);
		}
		return null;
	}

}
