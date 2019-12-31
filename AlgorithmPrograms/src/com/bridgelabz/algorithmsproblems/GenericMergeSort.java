package com.bridgelabz.algorithmsproblems;

public class GenericMergeSort {

	public static void main(String[] args) {
		Integer[] items = { 2, 5, 1, 6, 15, 22, 4, 12, 26, 45, 23, 3, 8 };
		System.out.println("before sorting array elements  are :");
		for (Integer item : items) {
			System.out.print(" " + item);
		}

		int l = 0;
		int size = items.length;
		Util.merge(items, l, size-1);
		System.out.println("\nafter sorting array elements  are :");
		for (Integer elements : items) {
			System.out.print(" " + elements);
		}

	}

}
