package com.example.EventRegistration;

public class StudentAttendee implements Attendee {
     String name;
     int batch;
     String department;

    @Override
    public void setAttendeeDetails(String name, String department, int batch) {
      this.name = name;
      this.department = department;
      this.batch = batch;
    }

    @Override
    public void printRegistrationConfirmation() {
     System.out.println("Hi "+ name + ",your registration confirmation is successful.");
    }

    @Override
    public String getAttendeeName() {
        return name;
    }
    /*
    1. Create the following attributes:
        a. name (String)
        b. batch (int)
        c. department (String)
    2. Make this class an implementation of Attendee interface and override the interface methods.
    */

}
