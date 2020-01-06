package com.bridgelabz.junitprograms;

public class Util {
	/*
	 * Function for monthly payment
	 */

	/**
	 * @param year
	 * @param prin
	 * @param rate
	 * @return
	 */
	static double monthlyPayment(double year, double prin, double rate) {
		double n = 12 * year;
		double r = rate / (12 * 100);
		double payment = (prin * r) / 1 - Math.pow(1 + r, -n);
		return payment;
	}

	/*
	 * Function for dayOfWeek
	 */

	/**
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	static int dayOfWeek(int year, int month, int day) {
		int y0 = year - (14 - month) / 12;
		int x = y0 + (y0 / 4) - (y0 / 100) + (y0 / 400);
		int m0 = month + 12 * ((14 - month) / 12) - 2;
		int d0 = (day + x + (31 * m0) / 12) % 7;
		return d0;
	}

	/*
	 * Function for squareRoot
	 * 
	 */

	/**
	 * @param c
	 * @return
	 */
	static double squareRootOf(double c) {
		double t = c;
		double epsilon = 1e-15;
		while (Math.abs(t - c / t) > epsilon * t) {
			t = (c / t + t) / 2;
		}
		return t;

	}

	// converting Fahrenheit to Celsius
	static float Fah_to_Cel(float temp) {

		return ((temp - 32) * 5 / 9);
	}

	// converting Celsius to Fahrenheit
	static float Cel_to_Fah(float temp) {

		return ((temp * 9 / 5) + 32);
	}

	/*
	 * Function for toBinary
	 */

	/**
	 * @param num
	 * @return
	 */
	static int[] toBinary(int num) {
		String str = "";
		while (num != 0) {
			str = num % 2 + str;
			num = num / 2;
		}
		while (str.length() % 4 != 0) {
			str = 0 + str;
		}
		return stringTointArray(str);
	}

	static int[] stringTointArray(String str) {
		int[] binary = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			binary[i] = str.charAt(i) - 48;
		}
		return binary;
	}

	/*
	 * Function for toDecimal
	 */

	/**
	 * @param binary
	 * @return
	 */
	static int toDecimal(int[] binary) {

		int dec = 0;
		int j = 0;
		for (int i = binary.length - 1; i >= 0; i--) {
			if (binary[i] == 1) {
				dec = dec + (int) Math.pow(2, j);
			}
			j++;
		}
		return dec;
	}

	/*
	 * Function for powerofTwo
	 */

	/**
	 * @param d
	 * @return
	 */
	static boolean powerOfTwo(int d) {
		int i = 0;
		int temp = (int) Math.pow(2, i);

		while (temp < d) {
			if (temp == d) {
				return true;
			}
			i++;
		}
		return false;

	}

}
