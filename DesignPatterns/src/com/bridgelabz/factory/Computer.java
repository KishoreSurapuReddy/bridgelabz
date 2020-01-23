/*purpose:declare interface with abstract methods
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file Computer.java
*/
package com.bridgelabz.factory;

public abstract class Computer {
	//abstract methods
	public abstract String getRam();
	public abstract String getHdd();
	public abstract String getCpu();
	@Override
	public String toString() {
		return " Ram =" + getRam() + ", Hdd =" + getHdd() + ",Cpu=" + getCpu();
	}
	
	
}
