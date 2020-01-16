package com.bridgelabz.clinicmanagement;

import java.util.List;

public class ClinicManagementMain {
	ClinicManagementDAOImpl clinic = new ClinicManagementDAOImpl();
	public void doctor() {
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
			clinic.addDoctor();
			doctor();
			break;
		case 2:
			System.out.println("enter doctor name or id or specialization or availability");
			String name = clinic.scanner.next();
			int view = clinic.scanner.nextInt();
			clinic.viewDoctor(name, view, name, name);
			doctor();
			break;
		case 3:
			List<Doctor> list = clinic.viewAllDoctors();
			System.out.println("doctor name "+"doctor id"+"specilaization"+"availability");
			for(Doctor doctors : list ){
				System.out.println(doctors);
			}
			doctor();
			break;
		case 4:
			System.out.println("enter name of doctor ");
			String doctorname = clinic.scanner.next();
			clinic.updateDoctor(doctorname);
			doctor();
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
	
	public void patient() {
		
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
			clinic.addPatient();
			patient();
			break;
		case 2:
			System.out.println("enter patient name or id or phonenumber");
			String name = clinic.scanner.next();
			int id = clinic.scanner.nextInt();
			long number = clinic.scanner.nextLong();
			clinic.viewPatient(name, id, number);
			patient();
			break;
		case 3:
			List<Patient> list = clinic.viewAllPatients();
			System.out.println("patient name "+"patient id"+"phone number"+"age");
			for(Patient patients : list ){
				System.out.println(patients);
			}
			patient();
			break;
		case 4:
			List<Doctor> listdotors = clinic.viewAllDoctors();
			System.out.println("doctor name "+"doctor id"+"specilaization"+"availability");
			for(Doctor doctors : listdotors ){
				System.out.println(doctors);
			}
			patient();
			break;
		case 5:
			System.out.println("enter patient name :");
			String patientname = clinic.scanner.next();
			clinic.updatePatient(patientname);
			patient();
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
			doctor();
			break;
		case 2:
			patient();
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
