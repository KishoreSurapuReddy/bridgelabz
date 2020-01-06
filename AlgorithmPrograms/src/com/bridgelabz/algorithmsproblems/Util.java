package com.bridgelabz.algorithmsproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
	/*
	 * Function for anagramdetection
	 */

	/**
	 * @param string1
	 * @param string2
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
	 * 
	 * @param string
	 * 
	 * @param toCheck
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

	/**
	 * @param arr
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
	/**
	 * @param arr
	 * @param l
	 * @param r
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

	/**
	 * @param number
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

	/**
	 * @param arr
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

	/*
	 * funtion for genericbinarysearch
	 */

	public static <T extends Comparable<T>> int index(T[] items, T item) {
		return genericbinarySearch(items, item, 0, items.length - 1);
	}

	public static <T extends Comparable<T>> int genericbinarySearch(T[] items, T key, int low, int high) {
		if (key == null) {
			return -1;
		}

		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;

		if (key.compareTo(items[mid]) > 0) {
			return genericbinarySearch(items, key, mid + 1, high);
		} else if (key.compareTo(items[mid]) < 0) {
			return genericbinarySearch(items, key, low, mid - 1);
		} else {
			return mid;
		}
	}

	/*
	 * function for genericinsertionsort
	 */

	public static <T extends Comparable<T>> T[] genericInsertionSort(T[] items) {

		int size = items.length;
		for (int i = 1; i < size; i++) {
			for (int j = i; j > 0; --j) {
				if (items[j - 1].compareTo(items[j]) > 0) {
					T temp = items[j - 1];
					items[j - 1] = items[j];
					items[j] = temp;

				}
			}
		}

		return items;

	}

	/*
	 * function for genericbubblesort
	 */
	public static <T extends Comparable<T>> T[] genericBubbleSort(T[] items) {
		int size = items.length;

		while (size > 0) {
			int lastModifiedIndex = 0;
			for (int i = 1; i < size; i++) {
				if (items[i - 1].compareTo(items[i]) > 0) {
					T temp = items[i - 1];
					items[i - 1] = items[i];
					items[i] = temp;
				}
				lastModifiedIndex = i;
			}
			size = lastModifiedIndex;
		}
		return items;

	}

	/*
	 * function for genericmergesort
	 */
	public static <T extends Comparable<T>> void merge(T[] items, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			merge(items, l, m);
			merge(items, m + 1, r);

			genericMergeSort(items, l, m, r);
		}

	}

	private static <T> T[] genericMergeSort(T[] items, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		T[] left = (T[]) new Comparable[n1];
		T[] right = (T[]) new Comparable[n2];

		for (int i = 0; i < n1; i++) {
			left[i] = items[l + i];
		}

		for (int j = 0; j < n2; j++) {
			right[j] = items[m + 1 + j];
		}

		int leftIndex = 0, rightIndex = 0;

		// the index we will start at when adding the subarrays back into the main array
		int currentIndex = l;

		// compare each index of the subarrays adding the lowest value to the
		// currentIndex
		while (leftIndex < left.length && rightIndex < right.length) {
			if (((Comparable) left[leftIndex]).compareTo(right[rightIndex]) <= 0) {
				items[currentIndex] = left[leftIndex];
				leftIndex++;
			} else {
				items[currentIndex] = right[rightIndex];
				rightIndex++;
			}
			currentIndex++;
		}

		// copy remaining elements of leftArray[] if any
		while (leftIndex < left.length)
			items[currentIndex++] = left[leftIndex++];

		// copy remaining elements of rightArray[] if any
		while (rightIndex < right.length)
			items[currentIndex++] = right[rightIndex++];
		return items;
	}

}
