package com.appointments.controller;

import com.appointments.application.dto.AppointmentCreation;
import com.appointments.application.dto.EventUUID;

/**
 * Services organiser will reach;
 *
 */
public interface IAppointmentsControllerOrganiser {
	
	public AppointmentCreation IncomingNewEvent(AppointmentCreation event); // get

	public EventUUID IncomingReport(EventUUID uuid); // get

	public AppointmentCreation IncomingChangeEvent(AppointmentCreation event); // get

	public EventUUID IncomingDeleteEvent(EventUUID uuid); // get
	
	public void EventReport(AppointmentCreation appEvent); // post
	
}
