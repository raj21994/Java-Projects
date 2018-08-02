package studentDatabaseApp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int courseYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	// Constructor: prompts user to enter students name and year
	public Student() {
		Scanner in =  new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("1 - First Year\n2 - Second Year\n3 - Third Year or Final Year if not sandwich student\n4 - Final Year if sandwich student\nEnter student course year: ");
		this.courseYear = in.nextInt();
		
		System.out.println(firstName + " " + lastName + "\n" + courseYear);
		
		setStudentID();
		
		//System.out.println(firstName + " " + lastName + " " + courseYear + " " + studentID);
	}
	// Generate an ID
	private void setStudentID() {
		// Grade level + ID
		id++;
		this.studentID = courseYear + "" + id;
		
	}
	
	// Enrol in courses
	public void enrol() {
		// Get inside a loop, user hits 0
		do {
			System.out.print("Enter course to enrol (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals ("Q")) {
				courses = courses + "\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
				
			}
			else { 
				break; 
			}
		} while (1 != 0);
		
		//System.out.println("ENROLLED IN: " + courses);
		//System.out.println("TUITION BALANCE: " + tuitionBalance);
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: £" + tuitionBalance + "\n");
	}
	
	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: £");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of £" + payment);
		viewBalance();
	}
	
	// Show status
	public String toString() {
		return "Name: " + firstName + " " + lastName +
				"\nCourse Year: " + courseYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: £" + tuitionBalance;
	}
	
}
