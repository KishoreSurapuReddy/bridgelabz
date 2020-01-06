package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class Util {
	static Scanner sc;

	/*
	 * function for distancecalculation
	 */

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public static double distanceOf(double x, double y) {
		double res = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return res;
	}

	/*
	 * function for quadraticequation
	 */

	/**
	 * @param a
	 * @param b
	 * @param c
	 */
	static void quadraticEquiation(double a, double b, double c) {

		double delta = b * b - 4.0 * a * c;

		if (delta > 0) {
			double root1 = (-b + Math.sqrt(delta)) / (2 * a);
			double root2 = (-b - Math.sqrt(delta) / (2 * a));
			System.out.println("the roots are : " + root1 + "and " + root2);

		} else if (delta == 0) {
			double root1 = -b / (2 * a);
			System.out.println("the roots are :" + root1);

		} else {
			System.out.println("there were no roots ");
		}

	}

	/*
	 * function for sumofintegers
	 */

	/**
	 * @param arr
	 */
	static void sumOfInteger(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					// System.out.println("sum is:"+sum);
					if (sum == 0) {
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
						count++;
					}
				}
			}
		}
		System.out.println("no-of distinct triplets are " + count);
		return;
	}

	/*
	 * function for twodimentionalarray
	 */

	/**
	 * @param arr
	 */
	static void twoDimentionArray(int[][] arr) {
		System.out.println("elements are :");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(" " + arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	/*
	 * function for temareture of windchill
	 */

	/**
	 * @param t
	 * @param v
	 * @return
	 */
	static double temparetureOf(double t, double v) {
		double w = 0;
		if (t <= 50 && v > 120 || v < 3) {
			System.out.println("enter the correct values i.e t<50 and 120>v>3");
		} else {
			double a = 35.74 + (0.6215 * t);
			double b = ((0.4275 * t) - 35.75) * Math.pow(v, 0.16);
			w = a + b;
		}
		return w;

	}

}
