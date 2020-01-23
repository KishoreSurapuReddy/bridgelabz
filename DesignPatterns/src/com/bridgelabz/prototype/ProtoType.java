/*purpose:Prototype pattern will be used to copy the original object to 
 * other object 
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file ProtoType.java
*/
package com.bridgelabz.prototype;

import java.util.ArrayList;

public class ProtoType {

	public static void main(String[] args) {
		StudentClonable student = new StudentClonable();
		student.loadData();
		//coping object to new object
		ArrayList<Student> list1 = student.clone();
		list1.remove(1);
		System.out.println(student.getList());
		System.out.println(list1);

	}

}
