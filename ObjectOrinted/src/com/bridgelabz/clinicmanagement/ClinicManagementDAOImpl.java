/*purpose:it will implement the abstract methods
 * @author kishorereddy
 * @version 1.0
 * @since 15/01/2020
 * @file ClinicManagementDAOImpl.java
 */
package com.bridgelabz.clinicmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicManagementDAOImpl implements ClinicManagementDAO {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Doctor> doctorlist = new ArrayList<Doctor>();
	ArrayList<Patient> patientlist = new ArrayList<Patient>();
	ArrayList<Patient> temp = new ArrayList<Patient>();
	ArrayList<Doctor> tempdoctor = new ArrayList<Doctor>();
	List<String> appointment = new ArrayList<>();
	Doctor doctor;
	Patient patient;
	/*
	 * function to implement adding doctor details
	 */
	@Override
	public void addDoctor(Doctor doctor) {
			doctorlist.add(doctor);
	}
	/*
	 * function to implement adding patient details
	 */
	@Override
	public void addPatient(Patient patient) {
			patientlist.add(patient);
		
	}
	/*
	 * function to implement taking doctor appointment
	 */
	@Override
	public void takeAppointment(String doctorname) {
		for(Doctor list : doctorlist){
			if(list.getDoctorName().equals(doctorname)){
				System.out.println("enter patient id :");
				int id = scanner.nextInt();
				for(Patient patientlist : patientlist){
					if(patientlist.getPatientId()==id){
						List<String> details;
						int loop = 1;
						while(loop == 1){
							int size = 1;
							details = new ArrayList<>();
							if(size <= 5){
								System.out.println("enter patient name ");
								String patientname = scanner.next();
								details.add(patientname);
								System.out.println("enter patient phonenumber");
								String number = scanner.next();
								details.add(number);
								System.out.println("enter patient age ");
								String age = scanner.next();
								details.add(age);
								appointment.addAll(details);
								size++;
							}else{
								System.out.println("appointments are closed..");
							}
							System.out.println("enter 1 to add another patient or press any other key");
							int key = scanner.nextInt();
							loop = key;
						}
					}else{
						System.out.println("enter correct details..");
					}
				}
			}else{
				System.out.println("enter correct details..");
			}
		}
		
	}
	/*
	 * function to implement updating doctor details
	 */
	@Override
	public void updateDoctor(int doctorId) {
		tempdoctor = new ArrayList<Doctor>();
		for(Doctor list : doctorlist) {
			if(list.getDoctorId() == doctorId) {
				System.out.println("enter choice 1.name 2.specialization 3.timings");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					System.out.println("enter the name :");
					String doctorname = scanner.next();
					list.setDoctorName(doctorname);
					break;
				case 2:
					System.out.println("enter specialization :");
					String specialization = scanner.next();
					list.setSpecialization(specialization);
					break;
				case 3:
					System.out.println("enter timings :");
					String time = scanner.next();
					list.setAvailability(time);
					break;
				default :
					System.out.println("enter the range between 1-3 only..");
					break;
				}
				tempdoctor.add(list);
			}else {
				tempdoctor.add(list);
			}
			
		}
		doctorlist.addAll(tempdoctor);
		
	}
	/*
	 * function to implement adding patient details
	 */
	@Override
	public void updatePatient(int patientId) {
		temp = new ArrayList<Patient>();
		for(Patient list : patientlist) {
			if(list.getPatientId() == patientId) {
				System.out.println("enter choice 1.name 2.phonenumber 3.age ");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					System.out.println("enter patient name :");
					String name = scanner.next();
					list.setPatientName(name);;
					break;
				case 2:
					System.out.println("enter patient phone number");
					long phonenumber = scanner.nextLong();
					list.setPhoneNumber(phonenumber);
					break;
				case 3:
					System.out.println("enter patient age :");
					int age = scanner.nextInt();
					list.setAge(age);
					break;
				default:
					System.out.println("enter the range between 1-3 only ");
					break;
				}
				temp.add(list);
			}else {
				temp.add(list);
			}
		}
		patientlist.addAll(temp);
	}
	/*
	 * function to implement view doctor details
	 */
	@Override
	public Doctor viewDoctor(int doctorId) {
		doctor = new Doctor();
		for(Doctor list : doctorlist) {
			if(list.getDoctorId()==doctorId ) {
				doctor.setDoctorName(list.getDoctorName());
				doctor.setDoctorId(list.getDoctorId());
				doctor.setSpecialization(list.getSpecialization());
				doctor.setAvailability(list.getAvailability());
			}
		}
		return doctor;
	}
	/*
	 * function to implement view patient details
	 */
	@Override
	public Patient viewPatient( int patientId) {
		patient = new Patient();
		for(Patient list : patientlist) {
			if(list.getPatientId()== patientId) {
				patient.setPatientName(list.getPatientName());
				patient.setPatientId(list.getPatientId());
				patient.setPhoneNumber(list.getPhoneNumber());
				patient.setAge(list.getAge());
			}
		}
		return patient;
		
	}
	/*
	 * function to implement view all doctor details
	 */
	@Override
	public List<Doctor> viewAllDoctors() {
		return doctorlist;
		
	}
	/*
	 * function to implement view all patient details
	 */
	@Override
	public List<Patient> viewAllPatients() {
		return patientlist;
		
	}
}
