/*purpose:it is used to show the main menu
 * @author kishorereddy
 * @version 1.0
 * @since 15/01/2020
 * @file ClinicManagementMain.java
 */
package com.bridgelabz.clinicmanagement;

import java.util.List;

public class ClinicManagementMain {
	ClinicManagementDAOImpl clinic = new ClinicManagementDAOImpl();
	Doctor doctor;
	Patient patient;
	public void doctorMenu() {
		System.out.println("----------------------");
		System.out.println("    DOCTOR MENU     ");
		System.out.println("  1.addDoctor       ");
		System.out.println("  2.view Doctor     ");
		System.out.println("  3.view all doctors");
		System.out.println("  4.update Doctor   ");
		System.out.println("  5.viewAppointmentPatient ");
		System.out.println("  6.Back            ");
		System.out.println("enter the choice ");
		int choice = clinic.scanner.nextInt();
		switch(choice) {
		case 1:
			int loop = 1;
			while(loop == 1) {
			doctor = new Doctor();
			System.out.println("enter name of doctor :");
			String name = clinic.scanner.next();
			System.out.println("enter doctor id :");
			int id = clinic.scanner.nextInt();
			System.out.println("enter doctor specialization :");
			String specialization = clinic.scanner.next();
			System.out.println("enter doctor availability timings :");
			String time = clinic.scanner.next();
			doctor = new Doctor(name, id, specialization, time);
			clinic.addDoctor(doctor);
			System.out.println("if u want to add another doctor details press 1 or press any key");
			loop = clinic.scanner.nextInt();
			}
			doctorMenu();
			break;
		case 2:
			System.out.println("enter doctor id :");
			int id = clinic.scanner.nextInt();
			doctor = clinic.viewDoctor(id);
			System.out.println(doctor);
			doctorMenu();
			break;
		case 3:
			List<Doctor> list = clinic.viewAllDoctors();
			System.out.println("doctor name "+"doctor id"+"specilaization"+"availability");
			for(Doctor doctors : list ){
				System.out.println(doctors);
			}
			doctorMenu();
			break;
		case 4:
			System.out.println("enter id of doctor ");
			int doctorid = clinic.scanner.nextInt();
			clinic.updateDoctor(doctorid);
			doctorMenu();
			break;
		case 5:
			List<String> appointmentlist = clinic.appointment;
			for(String details : appointmentlist){
				System.out.println(details);
			}
		case 6:
			menu();
			break;
		default:
			System.out.println("enter the range between 1-6 only..");
			break;
		}
		
	}
	
	public void patientMenu() {
		
		System.out.println("----------------------");
		System.out.println("    PATIENT MENU     ");
		System.out.println("  1.addPatient       ");
		System.out.println("  2.view Patient     ");
		System.out.println("  3.view all patients");
		System.out.println("  4.view all doctors");
		System.out.println("  5.update Patient   ");
		System.out.println("  6.takeAppointment  ");
		System.out.println("  7.Back             ");
		System.out.println("enter the choice ");
		int choice = clinic.scanner.nextInt();
		switch(choice) {
		case 1:
			int loop = 1;
			while (loop == 1) {
				patient = new Patient();
				System.out.println("enter patient name :");
				String name = clinic.scanner.next();
				System.out.println("enter patient id :");
				int id = clinic.scanner.nextInt();
				System.out.println("enter patient phonenumber :");
				long phoneNumber = clinic.scanner.nextLong();
				System.out.println("enter patient age :");
				int age = clinic.scanner.nextInt();
				patient = new Patient(name, id, phoneNumber, age);
				clinic.addPatient(patient);
				System.out.println("if u want to add another patient details press 1 or any key");
				loop = clinic.scanner.nextInt();
			}
			patientMenu();
			break;
		case 2:
			System.out.println("enter patient id :");
			int patientid = clinic.scanner.nextInt();
			patient = clinic.viewPatient(patientid);
			System.out.println(patient);
			patientMenu();
			break;
		case 3:
			List<Patient> list = clinic.viewAllPatients();
			System.out.println("patient name "+"patient id"+"phone number"+"age");
			for(Patient patients : list ){
				System.out.println(patients);
			}
			patientMenu();
			break;
		case 4:
			List<Doctor> listdotors = clinic.viewAllDoctors();
			System.out.println("doctor name "+"doctor id"+"specilaization"+"availability");
			for(Doctor doctors : listdotors ){
				System.out.println(doctors);
			}
			patientMenu();
			break;
		case 5:
			System.out.println("enter patient id :");
			int patientId = clinic.scanner.nextInt();
			clinic.updatePatient(patientId);
			patientMenu();
			break;
		case 6:
			System.out.println("enter the name of doctor :");
			String doctorname = clinic.scanner.next();
			clinic.takeAppointment(doctorname);
			
		case 7:
			menu();
			break;
		default:
			System.out.println("enter the range between 1-7 only..");
			break;
		}
	}
	
	public void menu() {
		

		System.out.println("----------------------");
		System.out.println("      MAIN MENU       ");
		System.out.println("    1.DOCTOR MENU      ");
		System.out.println("    2.PATIENT MENU     ");
		System.out.println("    3.EXIT             ");
		int choice = clinic.scanner.nextInt();
		switch(choice) {
		case 1:
			doctorMenu();
			break;
		case 2:
			patientMenu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("enter the range between 1-3 only..");
		}	
	}

	public static void main(String[] args) {
		ClinicManagementMain clinic = new ClinicManagementMain();
		clinic.menu();

	}
}
