package com.appointments.controller;

import com.appointments.application.dto.AppointmentCreation;
import com.appointments.application.dto.EventUUID;


/**
 * Service for appointments attendee; 
 * this are the endpoints attendee will reach when; 
 * @author shtirlitz
 *
 */
public interface IAppointmentsControllerAttendee {
	
	public Boolean CreateEvent(AppointmentCreation appEvent);  // post
	
	public AppointmentCreation ReportEvent(long uuid); // get
	
	public AppointmentCreation ChangeEvent(AppointmentCreation event); // post 
	
	public boolean DeleteEvent(EventUUID eventUUID); 	// post

	
}
