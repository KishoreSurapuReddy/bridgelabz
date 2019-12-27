package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class SumOfInteger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in );
		System.out.println("enter the size of array :");
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0;i<arr.length;i++) {
			System.out.println("enter the elements :");
			arr[i]=sc.nextInt();
		}
		sc.close();
		Util.sumOfInteger(arr);
	}

}
