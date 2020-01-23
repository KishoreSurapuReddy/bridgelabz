/*purpose:To maintain student details 
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file StudentClonable.java
*/
package com.bridgelabz.prototype;

import java.util.ArrayList;

public class StudentClonable {
	ArrayList<Student> list;

	public StudentClonable() {
		list = new ArrayList<Student>();
	}

	public StudentClonable(ArrayList<Student> list) {
		this.list = list;
	}

	public ArrayList<Student> getList() {
		return list;
	}
	
	public void loadData(){
		for(int i =0 ; i < 2;i++){
			Student student = new Student();
			student.setStudentName("kishore");
			student.setStudentId(123);
			student.setAddress("hyderabad");
			list.add(student);
		}
	}
	protected ArrayList<Student> clone(){
		ArrayList<Student> student = new ArrayList<>();
		//StudentClonable student = new StudentClonable();
		for(Student s : list){
			student.add(s);
		}
		return student;
		
	}

}
