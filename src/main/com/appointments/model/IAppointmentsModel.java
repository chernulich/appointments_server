package com.appointments.model;

import com.appointments.application.dto.AppointmentCreation;

import biweekly.component.VEvent;

public interface IAppointmentsModel {
	public boolean create(AppointmentCreation appEvent);
	public void read();
	public void update();
	public void delete();
	
	public AppointmentCreation pendingToCreate(String organiserName);
	public long pendingToRead(String organiserName);
	public VEvent pendingToUpdate(String organiserName);
	public long pendingToDelete(String organiserName);
	
	public void report(String organiserName, AppointmentCreation appEvent);

}
