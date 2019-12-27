package com.bridgelabz.algorithmsproblems;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {5,2,16,25,42,35,12,3,6,18};
		int l =0;
		System.out.print("array elements are :");
		for(int i=0;i<arr.length;i++) {
			
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		Util.mergeSort(arr, l,arr.length-1);
		System.out.print("after sorting :");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}
}
