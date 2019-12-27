package com.bridgelabz.algorithmsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumbers {
	
	public static void primeNumbers(int num) {
		ArrayList<Integer> list  = new ArrayList<Integer>();
		for (int i = 0; i <= num; i++) {
			int count = 0;
			if (i == 0 && i == 1) {

			} else {
				for (int j = 1; j <= i; j++) {
					if (i % j == 0) {
						count++;
					}
				}
			}
			if (count == 2) {
				System.out.println("prime numbers of 0 to " + num + " are :" + i);
				list.add(i);
			}
		}
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if(anagram(list.get(i),list.get(j))) {
					System.out.println("anagram num are: "+list.get(i)+" "+list.get(j));
				}
			}
		}

		
	}

	public static boolean anagram(int n1, int n2) {
		
		int[] a = count(n1);
		int[] b = count(n2);
		//System.out.println("a array elements are :"+Arrays.toString(a));
		//System.out.println("b array elements are :"+Arrays.toString(b));
		for(int i=0;i< b.length;i++) {
			if(a[i]!=b[i]) {
				return false;
			}
		}
		return true;
		}

	private static int[] count(int n) {
		int[] count = new int[10];
		int temp = n;
		while(temp != 0) {
			int r = temp%10;
			count[r]++;
			
			temp = temp/10;
		}
		//System.out.println("count is :"+Arrays.toString(count));
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number to find primenumbers :");
		int num = sc.nextInt();
		primeNumbers(num);
	}

}
