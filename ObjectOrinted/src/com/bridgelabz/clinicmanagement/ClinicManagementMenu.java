package com.bridgelabz.clinicmanagement;

public class ClinicManagementMenu {
	ClinicManagementDAOImpl clinic = new ClinicManagementDAOImpl();
	public void doctor() {
		System.out.println("----------------------");
		System.out.println("  DOCTOR MENU   ");
		System.out.println("  1.addDoctor       ");
		System.out.println("  2.view Doctor     ");
		System.out.println("  3.update Doctor   ");
		System.out.println("  4.viewAppointmentPatient ");
		System.out.println("  5.Back            ");
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
			System.out.println("enter name of doctor ");
			String doctorname = clinic.scanner.next();
			clinic.updateDoctor(doctorname);
			doctor();
			break;
		case 4:
			
		case 5:
			menu();
			break;
		default:
			System.out.println("enter the range between 1-5 only..");
			break;
		}
		
	}
	
	public void patient() {
		
		System.out.println("----------------------");
		System.out.println("    PATIENT MENU     ");
		System.out.println("  1.addPatient       ");
		System.out.println("  2.view Patient     ");
		System.out.println("  3.update Patient   ");
		System.out.println("  4.takeAppointment  ");
		System.out.println("  5.Back             ");
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
			System.out.println("enter patient name :");
			String patientname = clinic.scanner.next();
			clinic.updatePatient(patientname);
			patient();
			break;
		case 4:
			
		case 5:
			menu();
			break;
		default:
			System.out.println("enter the range between 1-5 only..");
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
		ClinicManagementMenu clinic = new ClinicManagementMenu();
		clinic.menu();

	}

}
