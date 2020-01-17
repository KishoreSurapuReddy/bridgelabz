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
    
	@Override
	public void addDoctor() {
		int loop = 1;
		while (loop == 1) {
			doctor = new Doctor();
			System.out.println("enter name of doctor :");
			String name = scanner.next();
			System.out.println("enter doctor id :");
			int id = scanner.nextInt();
			System.out.println("enter doctor specialization :");
			String specialization = scanner.next();
			System.out.println("enter doctor availability timings :");
			String time = scanner.next();
			doctor = new Doctor(name, id, specialization, time);
			doctorlist.add(doctor);
			System.out.println("if u want to add another doctor details press 1 or press any key");
			loop = scanner.nextInt();
		}
	}

	@Override
	public void addPatient() {
		int loop = 1;
		while (loop == 1) {
			patient = new Patient();
			System.out.println("enter patient name :");
			String name = scanner.next();
			System.out.println("enter patient id :");
			int id = scanner.nextInt();
			System.out.println("enter patient phonenumber :");
			long phoneNumber = scanner.nextLong();
			System.out.println("enter patient age :");
			int age = scanner.nextInt();
			patient = new Patient(name, id, phoneNumber, age);
			patientlist.add(patient);
			System.out.println("if u want to add another patient details press 1 or any key");
			loop = scanner.nextInt();
		}
		
	}

	@Override
	public void takeAppointment(String doctorname) {
		for(Doctor list : doctorlist){
			if(list.getDoctorName().equals(doctorname)){
				System.out.println("enter patient id :");
				int id = scanner.nextInt();
				for(Patient patientlist : patientlist){
					if(patientlist.getPatientId()==id){
						List<String> details;
						int i = 1;
						while(i == 1){
							int n = 1;
							details = new ArrayList<>();
							if(n <= 5){
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
								n++;
							}else{
								System.out.println("appointments are closed..");
							}
							System.out.println("enter 1 to add another patient or press any other key");
							int key = scanner.nextInt();
							i = key;
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

	@Override
	public void updateDoctor(String doctorName) {
		tempdoctor = new ArrayList<Doctor>();
		for(Doctor list : doctorlist) {
			if(list.getDoctorName().equals(doctorName)) {
				System.out.println("enter choice 1.id 2.specialization 3.timings");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					System.out.println("enter the id :");
					int id = scanner.nextInt();
					list.setDoctorId(id);
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

	@Override
	public void updatePatient(String patientName) {
		temp = new ArrayList<Patient>();
		for(Patient list : patientlist) {
			if(list.getPatientName().equals(patientName)) {
				System.out.println("enter choice 1.id 2.phonenumber 3.age ");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					System.out.println("enter patient id :");
					int id = scanner.nextInt();
					list.setPatientId(id);
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

	@Override
	public Doctor viewDoctor(String doctorName, int doctorId, String specilazition, String availability) {
		doctor = new Doctor();
		for(Doctor list : doctorlist) {
			if(list.getDoctorName().equals(doctorName)||list.getDoctorId()==doctorId || list.getSpecialization().equals(specilazition)||list.getAvailability().equals(availability)) {
				doctor.setDoctorName(list.getDoctorName());
				doctor.setDoctorId(list.getDoctorId());
				doctor.setSpecialization(list.getSpecialization());
				doctor.setAvailability(list.getAvailability());
			}
		}
		System.out.println(doctor);
		return doctor;
		
	}

	@Override
	public Patient viewPatient(String patientName, int patientId, long phoneNumber) {
		patient = new Patient();
		for(Patient list : patientlist) {
			if(list.getPatientName().equals(patientName)||list.getPatientId()==patientId||list.getPhoneNumber()==phoneNumber) {
				patient.setPatientName(list.getPatientName());
				patient.setPatientId(list.getPatientId());
				patient.setPhoneNumber(list.getPhoneNumber());
				patient.setAge(list.getAge());
			}
		}
		System.out.println(patient);
		return patient;
		
	}

	@Override
	public List<Doctor> viewAllDoctors() {
		return doctorlist;
		
	}

	@Override
	public List<Patient> viewAllPatients() {
		return patientlist;
		
	}


}
