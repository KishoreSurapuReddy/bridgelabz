package com.bridgelabz.prototype;

import java.util.ArrayList;

public class ProtoType {

	public static void main(String[] args) {
		StudentClonable student = new StudentClonable();
		student.loadData();
		
		ArrayList<Student> list1 = student.clone();
		list1.remove(1);
		System.out.println(student.getList());
		System.out.println(list1);

	}

}
