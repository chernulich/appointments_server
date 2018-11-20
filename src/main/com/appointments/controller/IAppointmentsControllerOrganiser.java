package com.appointments.controller;

import com.appointments.application.dto.AppointmentCreation;
import com.appointments.application.dto.EventUUID;

/**
 * Services organiser will reach;
 *
 */
public interface IAppointmentsControllerOrganiser {
	
	public AppointmentCreation IncomingNewEvent(String organiserName); // get

	public EventUUID IncomingReport(String organiserName); // get

	public AppointmentCreation IncomingChangeEvent(String organiserName); // get

	public EventUUID IncomingDeleteEvent(String organiserName); // get
	
	public void EventReport(AppointmentCreation appEvent); // post

	
}
