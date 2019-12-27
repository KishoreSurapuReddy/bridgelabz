package com.bridgelabz.junitprograms;

import java.util.Scanner;

public class TemparetureConversion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the temareture :");
		float temp = sc.nextFloat();
		System.out.println("enter choice 1.fah to cel 2.cel to fah");
		int num = sc.nextInt();
		sc.close();
		if (num == 1) {
			System.out.println(Util.Fah_to_Cel(temp));
		} else if (num == 2) {
			System.out.println(Util.Cel_to_Fah(temp));
		}

	}

}
