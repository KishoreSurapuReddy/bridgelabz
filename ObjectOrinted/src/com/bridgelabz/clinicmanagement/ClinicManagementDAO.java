package com.bridgelabz.clinicmanagement;

import java.util.List;

public interface ClinicManagementDAO {
	
	public void addDoctor();
	public void addPatient();
	public void takeAppointment(String doctorname);
	public void updateDoctor(String doctorName);
	public void updatePatient(String patientName);
	public Doctor viewDoctor(String doctorName ,int doctorId , String specilazition , String availability);
	public List<Doctor> viewAllDoctors();
	public List<Patient> viewAllPatients();
    public Patient viewPatient(String patientName , int patientId , long phoneNumber );

}
