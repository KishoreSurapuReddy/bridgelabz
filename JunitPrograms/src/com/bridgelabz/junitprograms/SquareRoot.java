package com.bridgelabz.junitprograms;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number :");
		double c = sc.nextDouble();
		sc.close();
		System.out.println(Util.squareRootOf(c));

	}

}
