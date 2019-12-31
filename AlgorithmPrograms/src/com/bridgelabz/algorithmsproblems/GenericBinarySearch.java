package com.bridgelabz.algorithmsproblems;

import java.util.Arrays;
import java.util.Scanner;

public class GenericBinarySearch {

	public static void main(String[] args) {
		
		  Integer[] items = { 22, 55, 66, 11, 32, 56, 67, 89, 95, 10 };
		 
	      Arrays.sort(items);
	      System.out.print("Sorted Integer Array = ");
	      for (Integer item : items) {
	           System.out.print(item+" ");
	      }
	      System.out.println();
	      Scanner sc = new Scanner(System.in);
	      System.out.println("enter number which do you want to find :");
	      int num = sc.nextInt();
	      sc.close();
	   
	      int foundIndex = Util.index(items, Integer.valueOf(num));
	      System.out.println("\nInteger Array Contains item "+num+" at index = " + foundIndex);
		

	}

}
