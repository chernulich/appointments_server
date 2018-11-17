package com.appointments.controller;

import java.io.IOException;

import com.appointments.application.dto.AppointmentEvent;
import com.appointments.application.dto.EventUUID;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


/**
 * Service for appointments attendee; 
 * @author shtirlitz
 *
 */
public interface IAppointmentsControllerAttendee {
	
	public Boolean CreateEvent(AppointmentEvent appEvent);  // post
	
	public AppointmentEvent ReportEvent(long uuid); // get
	
	public AppointmentEvent ChangeEvent(AppointmentEvent event); // post 
	
	public boolean DeleteEvent(EventUUID eventUUID); 	// post

	
}
