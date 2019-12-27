package com.bridgelabz.basicprograms;

import java.util.Scanner;

public class powerOfTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the num:");
		int number = sc.nextInt();
		System.out.println("Enter the power :");
		int power = sc.nextInt();
		sc.close();
		System.out.println(number+" power of "+power+" is :"+Util.powerOfTwo(number, power));

	}

}
