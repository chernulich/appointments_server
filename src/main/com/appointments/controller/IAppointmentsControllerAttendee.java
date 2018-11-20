package com.appointments.controller;

import java.util.UUID;

import com.appointments.application.dto.AppointmentCreation;


/**
 * Service for appointments attendee; 
 * this are the endpoints attendee will reach when; 
 * @author shtirlitz
 *
 */
public interface IAppointmentsControllerAttendee {
	
	public Boolean CreateEvent(AppointmentCreation appEvent);  // post
	
	public AppointmentCreation ReportEvent(String organiserName, UUID eventUUID); // get
	
	public AppointmentCreation ChangeEvent(AppointmentCreation event); // post 
	
	public boolean DeleteEvent(String organiserName, UUID eventUUID); 	// post



	
}
