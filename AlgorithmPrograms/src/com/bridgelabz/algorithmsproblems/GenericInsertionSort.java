package com.bridgelabz.algorithmsproblems;

public class GenericInsertionSort {

	public static void main(String[] args) {
		Integer[] items = {2,5,4,9,22,51,36,1,45,26,15};
		System.out.println("before sorting :");
		for(Integer item : items) {
			System.out.print(" "+item);
		}
		System.out.println();
		Integer[] sorted = Util.genericInsertionSort(items);
		for(Integer item : sorted) {
			System.out.print(" "+item);
		}

	}

}
