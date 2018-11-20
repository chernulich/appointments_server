package com.appointments.controller;

import java.util.UUID;

import com.appointments.application.dto.AppointmentCreation;

/**
 * Services organiser will reach;
 *
 */
public interface IAppointmentsControllerOrganiser {
	
	public AppointmentCreation IncomingNewEvent(String organiserName); // get

	public UUID IncomingReport(String organiserName); // get

	public AppointmentCreation IncomingChangeEvent(String organiserName); // get

	public UUID IncomingDeleteEvent(String organiserName); // get
	
	public Boolean EventReport(AppointmentCreation appEvent); // post

	
}
