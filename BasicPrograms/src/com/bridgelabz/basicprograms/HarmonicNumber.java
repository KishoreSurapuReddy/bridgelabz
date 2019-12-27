package com.bridgelabz.basicprograms;

import java.util.Scanner;

public class HarmonicNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the N number: ");
		int number = sc.nextInt();
		sc.close();
		System.out.println(Util.harmonicNumber(number));

	}

}
