package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class Distance {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the elements of x and y :");
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		sc.close();
		System.out.println("distance from ("+x+","+y+") to (0,0) " +Util.distanceOf(x, y));

	}

}
