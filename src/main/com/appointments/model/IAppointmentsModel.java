package com.appointments.model;

import java.util.UUID;

import com.appointments.application.dto.AppointmentCreation;

import biweekly.component.VEvent;

public interface IAppointmentsModel {
	public boolean create(AppointmentCreation appEvent);
	public void read();
	public void update();
	public void delete();
	
	public AppointmentCreation pendingToCreate(String organiserName);
	public UUID pendingToReport(String organiserName);
	public VEvent pendingToUpdate(String organiserName);
	public UUID pendingToDelete(String organiserName);
	
	public void report(String organiserName, AppointmentCreation appEvent);

}
