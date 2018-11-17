package com.appointments.model;

import java.rmi.server.UID;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.appointments.application.dto.AppointmentEvent;

import biweekly.component.VEvent;


@Component("AppointmentsModel")
public class AppointmentsModel implements IAppointmentsModel {

	private Map<String, Queue<AppointmentEvent>> appointmentsToCreate = new TreeMap<String, Queue<AppointmentEvent>>();
	
	private Map<String, Map<UID, Boolean>> appointmentsCreated = new TreeMap<String, Map<UID, Boolean>>();

	public AppointmentsModel() {
		super();
	}

	@Override
	public boolean create(AppointmentEvent appEvent) {
		
		UID uid = new UID();
		
		appEvent.setUid(uid);
		
		String organiserName = appEvent.getOrganiser();

		if (appointmentsToCreate.containsKey(organiserName)) {
			
			appointmentsToCreate.get(organiserName).add(appEvent);
			
		} else {
			
			appointmentsToCreate.put(organiserName, new LinkedList<AppointmentEvent>());
			
		}
		
		Boolean created = true;
		
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

	@Override
	public AppointmentEvent pendingToCreate(String organiserName) {
		
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
	public void report(String organiserName, AppointmentEvent appEvent) {
		
		UID UUID = appEvent.getUid();

		Boolean created = appointmentsCreated.get(organiserName).get(UUID);
		
		if (! created ) appointmentsCreated.get(organiserName).put(UUID, Boolean.TRUE);
		
	}

}
