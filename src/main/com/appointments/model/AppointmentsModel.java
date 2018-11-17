package com.appointments.model;

import java.rmi.server.UID;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.appointments.application.dto.AppointmentCreation;

import biweekly.component.VEvent;


/**
 * Mediator between organizer and attendee; 
 */
@Component("AppointmentsModel")
public class AppointmentsModel implements IAppointmentsModel {

	/**
	 * Map for storing pending events to create by user name; attendees add data into it
	 */
	private Map<String, Queue<AppointmentCreation>> appointmentsToCreate = new TreeMap<String, Queue<AppointmentCreation>>();
	
	/**
	 * Map for storing event creation results; organizers add data into it; 
	 */
	private Map<String, Map<UID, Boolean>> appointmentsCreated = new TreeMap<String, Map<UID, Boolean>>();

	public AppointmentsModel() {
		super();
	}

	/**
	 * Attendee tries to create event; should return that the event was merely put into queue; 
	 */
	@Override
	public boolean create(AppointmentCreation appEvent) {
		
		UID uid = new UID();
		
		appEvent.setUid(uid);
		
		String organiserName = appEvent.getOrganizer();

		if (!appointmentsToCreate.containsKey(organiserName)) {
			
			appointmentsToCreate.put(organiserName, new LinkedList<AppointmentCreation>());
				
		}
		
		appointmentsToCreate.get(organiserName).add(appEvent);
		
		Boolean created = true; // should accept being created at Organiser side; so it's a call to appointmentsCreated;
		//TODO: null pointer error if we query appointmentsCreated now; 
		
		if ( created ) appointmentsToCreate.get(organiserName).remove(appEvent);
			
		return created;

	}

	@Override
	public void read() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	/**
	 * Organiser gets events that he has to create; 
	 */
	@Override
	public AppointmentCreation pendingToCreate(String organiserName) {
		
		return appointmentsToCreate.get(organiserName).peek();
		
	}

	@Override
	public long pendingToRead(String organiserName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VEvent pendingToUpdate(String organiserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long pendingToDelete(String organiserName) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Organiser reports on event status;
	 */
	@Override
	public void report(String organiserName, AppointmentCreation appEvent) {
		
		UID UUID = appEvent.getUid();

		Boolean created = appointmentsCreated.get(organiserName).get(UUID);
		
		if (! created ) appointmentsCreated.get(organiserName).put(UUID, Boolean.TRUE);
		
	}

}
