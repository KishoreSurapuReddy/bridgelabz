/*purpose:Student class to maintain student details
 * @author kishorereddy
 * @version 1.0
 * @since 22/01/2020
 * @file Student.java
*/
package com.bridgelabz.prototype;

public class Student {
	private String studentName;
	private int studentId;
	private String address;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Student() {
	}
	@Override
	public String toString() {
		return " [studentName=" + studentName + ", studentId=" + studentId + ", address=" + address + "]";
	}
	
	

}
