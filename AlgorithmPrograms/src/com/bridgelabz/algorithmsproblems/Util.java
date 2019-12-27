package com.bridgelabz.algorithmsproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
	/*
	 * Function for anagramdetection
	 */
	public static void anagram(String string1, String string2) {
		int count = 0;
		if (string1.length() == string2.length()) {
			for (int i = 0; i < string1.length(); i++) {
				// int count = 0;
				for (int j = 0; j < string2.length(); j++) {
					if (string1.charAt(i) == string2.charAt(j)) {

						count++;

					}
				}
			}
			if (count == string1.length()) {
				System.out.println("given string was anagram");
			} else {
				System.out.println("given string was not anagram!");
			}
		} else {
			System.out.println("length should be equal!");
		}
	}

	/*
	 * Function for BinarySearch
	 */
	public static void binarySearch(String[] string, String toCheck) {
		Arrays.sort(string);
		int find = Arrays.binarySearch(string, toCheck);
		boolean res = find > 0 ? true : false;
		System.out.println(toCheck + " was present on list is :" + res);
	}

	/*
	 * Function for Bubblesort
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("sorted elements :" + arr[i]);
		}
	}

	/*
	 * function for mergesort
	 */
	static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}
		int i = 0;
		int j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	/*
	 * function for finding primenumbers
	 */
	public static void primeNumbersOf(int number) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= number; i++) {
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
				System.out.println("prime numbers of 0 to " + number + " are :" + i);
				list.add(i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (primeAnagram(list.get(i), list.get(j))) {
					System.out.println("anagram num are: " + list.get(i) + " " + list.get(j));
				}
			}
		}

	}

	public static boolean primeAnagram(int number1, int number2) {

		int[] a = countOf(number1);
		int[] b = countOf(number2);
		// System.out.println("a array elements are :"+Arrays.toString(a));
		// System.out.println("b array elements are :"+Arrays.toString(b));
		for (int i = 0; i < b.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	private static int[] countOf(int number) {
		int[] count = new int[10];
		int temp = number;
		while (temp != 0) {
			int r = temp % 10;
			count[r]++;

			temp = temp / 10;
		}
		// System.out.println("count is :"+Arrays.toString(count));
		return count;
	}

	/*
	 * function for insertionsort
	 */
	public static void insertionSort(String[] arr) {

		for (int i = 1; i < arr.length - 1; i++) {
			String key = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1].compareTo(key) > 1) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = key;
		}
		System.out.println("sorted elements are :");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(" " + arr[i]);
		}
	}

}
