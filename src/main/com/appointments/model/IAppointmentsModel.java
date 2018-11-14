package com.appointments.model;

import biweekly.component.VEvent;

public interface IAppointmentsModel {
	public boolean create(String organiserName, VEvent event);
	public void read();
	public void update();
	public void delete();
	
	public VEvent pendingToCreate(String organiserName);
	public long pendingToRead(String organiserName);
	public VEvent pendingToUpdate(String organiserName);
	public long pendingToDelete(String organiserName);
	
	public void report(String organiserName, VEvent event);
}
