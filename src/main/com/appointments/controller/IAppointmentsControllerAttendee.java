package com.appointments.controller;

import com.appointments.application.dto.AppointmentEvent;
import com.appointments.application.dto.EventUUID;


/**
 * Service for appointments attendee; 
 * @author shtirlitz
 *
 */
public interface IAppointmentsControllerAttendee {
	
	public boolean CreateEvent(AppointmentEvent event);  // post
	
	public AppointmentEvent ReportEvent(long uuid); // get
	
	public AppointmentEvent ChangeEvent(AppointmentEvent event); // post 
	
	public boolean DeleteEvent(EventUUID eventUUID); 	// post

	
	
}
