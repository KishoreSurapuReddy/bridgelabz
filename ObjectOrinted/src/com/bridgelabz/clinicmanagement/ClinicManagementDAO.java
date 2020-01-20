/*purpose:ClinicManagementDAO have abstract methods
 * @author kishorereddy
 * @version 1.0
 * @since 15/01/2020
 * @file ClinicManagementDAO.java
 */
package com.bridgelabz.clinicmanagement;

import java.util.List;
//interface class
public interface ClinicManagementDAO {
	//abstract methods
	public void addDoctor(Doctor doctor);
	public void addPatient(Patient patient);
	public void takeAppointment(String doctorname);
	public void updateDoctor(int doctorId);
	public void updatePatient(int patientId);
	public Doctor viewDoctor(int doctorId);
	public List<Doctor> viewAllDoctors();
	public List<Patient> viewAllPatients();
    public Patient viewPatient( int patientId );

}
