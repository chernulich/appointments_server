package com.appointments.model;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;

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
	private Map<String, Map<UUID, Boolean>> appointmentsCreated = new TreeMap<String, Map<UUID, Boolean>>();

	public AppointmentsModel() {
		super();
	}

	/**
	 * Attendee tries to create event; should return that the event was merely put into queue; 
	 */
	@Override
	public boolean create(AppointmentCreation appEvent) {
		
		UUID uid = UUID.randomUUID();
		
		appEvent.setUid(uid);
		
		String organiserName = appEvent.getOrganizer();

		if (!appointmentsToCreate.containsKey(organiserName)) {
			
			appointmentsToCreate.put(organiserName, new LinkedList<AppointmentCreation>());
				
		}
		
		appointmentsToCreate.get(organiserName).add(appEvent);
		
		Boolean created = true; // should accept being created at Organiser side; so it's a call to appointmentsCreated;
		//TODO: null pointer error if we query appointmentsCreated now; 
			
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
	public UUID pendingToReport(String organiserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VEvent pendingToUpdate(String organiserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID pendingToDelete(String organiserName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Organiser reports on event status;
	 */
	@Override
	public void report(String organiserName, AppointmentCreation appEvent) {
		
		UUID UUID = appEvent.getUid();

		Boolean created = appointmentsCreated.get(organiserName).get(UUID);
		
		if (! created ) appointmentsCreated.get(organiserName).put(UUID, Boolean.TRUE);
		
		if ( created ) appointmentsToCreate.get(organiserName).remove(); 
		/* this will work only on one event; for multiple events ther's a chance that report will be on any other event and not the latest; 
		*/
	}

}
