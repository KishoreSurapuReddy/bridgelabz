package com.bridgelabz.clinicmanagement;

public class Patient {
	String patientName;
	int patientId;
	long phoneNumber;
	int age;
	
	public Patient() {
		
	}
	public Patient(String patientName, int patientId, long phoneNumber, int age) {
		
		this.patientName = patientName;
		this.patientId = patientId;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
