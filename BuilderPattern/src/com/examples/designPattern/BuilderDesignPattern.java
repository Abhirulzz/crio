package com.examples.designPattern;

import java.io.Serializable;

public class BuilderDesignPattern {

	public static void main(String[] args) {
		Appointment appt = null;

	      Scheduler pimScheduler = new Scheduler();

	      AppointmentBuilder apptBuilder = new AppointmentBuilder();
	      appt = pimScheduler.createAppointment(apptBuilder, "CSS Meetup", "A B C D");
	      System.out.println(appt);

	      MeetingBuilder mtgBuilder = new MeetingBuilder();
	      appt = pimScheduler.createAppointment(mtgBuilder, "HTML Meetup", "D E F G");
	      System.out.println(appt);
	      
	      appt = pimScheduler.createAppointment(mtgBuilder, "Java Meeting", "X Y Z");
	      System.out.println(appt);
	   }

	}

	
	class Scheduler {
	   public Appointment createAppointment(AppointmentBuilder builder, String description, String attendees) {
	      if (builder == null) {
	         builder = new AppointmentBuilder();
	      }/*from w  ww.j  a  v  a2  s  .c o  m*/
	      builder.buildAppointment();
	      builder.buildDescription(description);
	      builder.buildAttendees(attendees);
	      return builder.getAppointment();
	   }
	}

	class Appointment {
	   private String description;
	   private String attendees;

	   public String getDescription() {
	      return description;
	   }

	   public void setDescription(String newDescription) {
	      description = newDescription;
	   }

	   public void setAttendees(String newAttendees) {
	      attendees = newAttendees;
	   }

	   public String toString() {
	      return "Description: " + description + "\n" + "Attendees: " + attendees;
	   }
	}

	class AppointmentBuilder {

	   protected Appointment appointment;

	   protected int requiredElements;

	   public void buildAppointment() {
	      appointment = new Appointment();
	   }

	   public void buildDescription(String newDescription) {
	      appointment.setDescription(newDescription);
	   }

	   public void buildAttendees(String attendees) {
	      appointment.setAttendees(attendees);
	   }

	   public Appointment getAppointment() {
	      return appointment;
	   }

	   public int getRequiredElements() {
	      return requiredElements;
	   }
	}

	interface Contact extends Serializable {
	   public String getFirstName();

	   public String getLastName();

	   public String getTitle();

	   public String getOrganization();

	   public void setFirstName(String newFirstName);

	   public void setLastName(String newLastName);

	   public void setTitle(String newTitle);

	   public void setOrganization(String newOrganization);
	}

	class ContactImpl implements Contact {
	   private String firstName;
	   private String lastName;
	   private String title;
	   private String organization;

	   public ContactImpl(String newFirstName, String newLastName, String newTitle, String newOrganization) {
	      firstName = newFirstName;
	      lastName = newLastName;
	      title = newTitle;
	      organization = newOrganization;
	   }

	   public String getFirstName() {
	      return firstName;
	   }

	   public String getLastName() {
	      return lastName;
	   }

	   public String getTitle() {
	      return title;
	   }

	   public String getOrganization() {
	      return organization;
	   }

	   public void setFirstName(String newFirstName) {
	      firstName = newFirstName;
	   }

	   public void setLastName(String newLastName) {
	      lastName = newLastName;
	   }

	   public void setTitle(String newTitle) {
	      title = newTitle;
	   }

	   public void setOrganization(String newOrganization) {
	      organization = newOrganization;
	   }

	   public String toString() {
	      return firstName + " " + lastName;
	   }
	}

	class MeetingBuilder extends AppointmentBuilder {
	   public Appointment getAppointment() {
	      super.getAppointment();
	      return appointment;
	   }
	}

	

