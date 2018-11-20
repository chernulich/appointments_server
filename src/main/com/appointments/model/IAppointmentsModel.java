package com.appointments.model;

import java.util.UUID;

import com.appointments.application.dto.AppointmentCreation;

import biweekly.component.VEvent;

public interface IAppointmentsModel {
	public boolean create(AppointmentCreation appEvent);
	public AppointmentCreation read(String organiserName, UUID uid);
	public void update();
	public void delete();
	
	public AppointmentCreation pendingToCreate(String organiserName);
	public UUID pendingToReport(String organiserName);
	public VEvent pendingToUpdate(String organiserName);
	public UUID pendingToDelete(String organiserName);
	
	public Boolean organiserReport(String organiserName, AppointmentCreation appEvent);

}
