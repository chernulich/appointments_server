package com.appointments.model;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.text.StyledEditorKit.ForegroundAction;

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
	private Map<String, Map<UUID, AppointmentCreation>> appointmentsToCreate = new ConcurrentHashMap<String, Map<UUID, AppointmentCreation>>();
	
	public AppointmentsModel() {
		super();
	}

	/**
	 * Attendee tries to create event; should return that the event was merely put into queue; 
	 */
	@Override
	public boolean create(AppointmentCreation appEvent) {	
		
		String organiserName = appEvent.getOrganizer();

		if (!appointmentsToCreate.containsKey(organiserName)) {
			
			appointmentsToCreate.put(organiserName, new TreeMap<UUID, AppointmentCreation>());
				
		}
		
		appointmentsToCreate.get(organiserName).put(appEvent.getUid(), appEvent);
		
		Boolean created = true; // unknown how to reflect successful addition to appointmentsToCreate; 
			
		return created;

	}

	@Override
	public AppointmentCreation read(String organiserName, UUID uid) {
		
		return appointmentsToCreate.get(organiserName).get(uid);
		
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
		
		Map<UUID, AppointmentCreation> mapOfPendingCreations = appointmentsToCreate.get(organiserName);

		if (mapOfPendingCreations.size() == 0) return null; 
		
		for (Entry<UUID, AppointmentCreation> entry : mapOfPendingCreations.entrySet()) {
			if (entry.getValue().isCreated() == false) return entry.getValue();
		}
		
		return null; 
	
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
	public Boolean organiserReport(String organiserName, AppointmentCreation appEvent) {
		
		UUID UUID = appEvent.getUid();
		
		if (!appointmentsToCreate.containsKey(organiserName)) { appointmentsToCreate.put(organiserName, new TreeMap<UUID, AppointmentCreation>());}
		
		appointmentsToCreate.get(organiserName).put(UUID, appEvent);
		
		return true; // unknown how to reflect successful report; 
	}

	private void displayMapByOrganiser(String organiserName) {
		
		for(Entry<UUID, AppointmentCreation> entry : appointmentsToCreate.get(organiserName).entrySet()){
			System.out.println("UUID "+entry.getKey()+" entry "+entry.getValue().toString());
		}
		
	}
	
	private void displayMap() {
		//TODO:full map display
	}

}
