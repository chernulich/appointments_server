package com.appointments.model;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import biweekly.component.VEvent;
import biweekly.property.Uid;

public class AppointmentsModel implements IAppointmentsModel {

	private Map<String, Queue<VEvent>> appointmentsToCreate = new TreeMap<String, Queue<VEvent>>();
	
	private Map<String, Map<Uid, Boolean>> appointmentsCreated = new TreeMap<String, Map<Uid, Boolean>>();

	public AppointmentsModel() {
		super();
	}

	@Override
	public boolean create(String organiserName, VEvent event) {
		
		Uid UUID = event.getUid();

		if (appointmentsToCreate.containsKey(organiserName)) {
			
			appointmentsToCreate.get(organiserName).add(event);
			
		} else {
			
			appointmentsToCreate.put(organiserName, new LinkedList<VEvent>());
			
		}
		
		Boolean created = appointmentsCreated.get(organiserName).get(UUID);
		
		if ( created ) appointmentsToCreate.get(organiserName).remove(event);
			
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

	@Override
	public VEvent pendingToCreate(String organiserName) {
		
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

	@Override
	public void report(String organiserName, VEvent event) {
		
		Uid UUID = event.getUid();

		Boolean created = appointmentsCreated.get(organiserName).get(UUID);
		
		if (! created ) appointmentsCreated.get(organiserName).put(UUID, Boolean.TRUE);
		
	}

}
