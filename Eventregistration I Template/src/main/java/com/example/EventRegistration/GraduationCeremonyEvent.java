package com.example.EventRegistration;


import java.util.ArrayList;
import java.util.List;

public class GraduationCeremonyEvent implements CollegeEvent{

    String name="Graduation Ceremony";
  String address="Auditorium";
  String time="12:00PM";
  String date="04/09/2024";
  int count=0;
  List<Attendee> eventAttendees=new ArrayList<>();

  Attendee attendee;

    @Override
    public void registerStudent(Attendee user) {
     eventAttendees.add(user);
     count++;

    }

    @Override
    public List<Attendee> getAllAttendees() {
        return eventAttendees;
    }

    @Override
    public void printEventDetails() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Time: " + time);
        System.out.println("Date: " + date);
        System.out.println("Total Attendees: " + count);

    }

    @Override
    public int getAttendeeCount() {
        return count;
    }

    @Override
    public void setAttendee(Attendee attendee) {
     this.attendee = attendee;
    }

    /*
    1. Create the following attributes:
        a. name (initialize it as "Graduation Ceremony".
        b. address (String)
        c. time (String)
        d. date (String)
        e. count (int) (initially 0)
        f. eventAttendees (List of Attendee)
        NOTE: Initialize the address, time and date attributes with some values.
    2. Inject Attendee with attribute name "attendee" with setter injection.
    3. Make this class an implementation of CollegeEvent interface and override the interface methods.
    */


}
