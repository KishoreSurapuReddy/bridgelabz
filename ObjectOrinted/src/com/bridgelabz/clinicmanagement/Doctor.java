/*purpose:it will contain doctor information
 * @author kishorereddy
 * @version 1.0
 * @since 15/01/2020
 * @file Doctor.java
 */
package com.bridgelabz.clinicmanagement;

public class Doctor {
	String doctorName;
	int doctorId;
	String specialization;
	String availability;
	
	public Doctor() {
		
	}
	
	public Doctor(String doctorName, int doctorId, String specialization, String availability) {
		this.doctorName = doctorName;
		this.doctorId = doctorId;
		this.specialization = specialization;
		this.availability = availability;
	}

	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String toString() {
		return getDoctorName()+"  "+getDoctorId()+"  "+getSpecialization()+ "  "+getAvailability();
	}

}
