package com.bridgelabz.algorithmsproblems;

import java.util.Scanner;

public class AnagramDetection {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the  two strings :");
		String str = sc.next();
		String str2 = sc.next();
		sc.close();
		Util.anagram(str, str2);

	}

}
