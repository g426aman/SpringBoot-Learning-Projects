package com.example.EventRegistration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


@SpringBootApplication
public class EventRegistrationApplication {

	public static void main(String[] args) {
		// Import scanner and take ClassPathXmlApplicationContext.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Graduation Ceremony Registration Application");
		// Take the college event bean from the application context.
		CollegeEvent event =context.getBean("event", CollegeEvent.class);
		// Print the event details.
        event.printEventDetails();
		while (true) {
			System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
			int input = scanner.nextInt();
			if (input == 1) {
				System.out.println("Enter your name: ");
				scanner.nextLine();
				String name = scanner.nextLine();


				System.out.print("Enter your department: ");
				String department = scanner.nextLine();


				System.out.println("Enter your batch year: ");
				int batch = scanner.nextInt();
				scanner.nextLine();


				StudentAttendee studentAttendee=context.getBean("student", StudentAttendee.class);
				studentAttendee.setAttendeeDetails(name, department, batch);

				event.registerStudent(studentAttendee);

				studentAttendee.printRegistrationConfirmation();




				/*
				 1. Take attendee details from the console.
				 2. Get studentAttendee bean from context and set the attendee details
				 3. Register the attendee for the event.
				 4. Print the registration confirmation.
				 */

			} else if(input == 2) {
				break;
			} else {
				System.out.println("Invalid Choice");
				return;
			}
		}

		// Get the number of attendees and print along with the statement below
		System.out.println("No. of attendees registered are: " + event.getAttendeeCount());
		System.out.println("The list of attendees are:");
		// Print all the attendee names with their reference ids as given in the sample output..

		for(Attendee attendee : event.getAllAttendees()) {
			System.out.println(attendee.getAttendeeName() + "Reference id: @" + attendee.toString().split("@")[1]);
		}
		context.close();
	}

}
