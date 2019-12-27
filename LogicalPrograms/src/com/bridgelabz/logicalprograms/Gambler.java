package com.bridgelabz.logicalprograms;

import java.util.Random;
import java.util.Scanner;

public class Gambler {
	public static void main(String[] args) {
		Util util = new Util();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the stack :");
		int stack = sc .nextInt();
		System.out.println("enter goal :");
		int goal = sc.nextInt();
		util.calculate(stack, goal);
	}

}
