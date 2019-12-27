package com.bridgelabz.basicprograms;

import java.util.Scanner;

public class ReplaceString {
	public static void main(String[] args) {
		Util util = new Util();
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter the username : for replacement");
		String UserName = sc.next();
		System.out.println(util.stringReplace(UserName));
		
	}

}
