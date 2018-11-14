package com.appointments.controller;

import com.appointments.application.dto.AppointmentEvent;
import com.appointments.application.dto.EventUUID;

public interface IAppointmentsControllerOrganiser {
	
	public AppointmentEvent IncomingNewEvent(AppointmentEvent event); // get

	public EventUUID IncomingReport(EventUUID uuid); // get

	public AppointmentEvent IncomingChangeEvent(AppointmentEvent event); // get

	public EventUUID IncomingDeleteEvent(EventUUID uuid); // get
	
	public void EventReport(AppointmentEvent appEvent); // post
	
}
