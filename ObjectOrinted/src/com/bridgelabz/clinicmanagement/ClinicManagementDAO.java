package com.bridgelabz.clinicmanagement;

public interface ClinicManagementDAO {
	
	public void addDoctor();
	public void addPatient();
	public void takeAppointment();
	public void updateDoctor(String doctorName);
	public void updatePatient(String patientName);
	public Doctor viewDoctor(String doctorName ,int doctorId , String specilazition , String availability);
    public Patient viewPatient(String patientName , int patientId , long phoneNumber );
    
}
