package com.bridgelabz.algorithmsproblems;

public class GenericBubbleSort {
	

	public static void main(String[] args) {
		Integer[] items = {5,2,9,4,10,16,25,32,12,45,11,1};
		System.out.println("before sorting array elements are:");
		for(Integer item : items) {
			System.out.print(" "+item);
		}
		System.out.println();
		Integer[] sorted = Util.genericBubbleSort(items);
		System.out.println("after sorting array elements are :");
		for(Integer item : sorted) {
			System.out.print(" "+item);
		}

	}

}
