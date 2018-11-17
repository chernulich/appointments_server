package com.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.application.dto.AppointmentCreation;
import com.appointments.application.dto.EventUUID;
import com.appointments.model.AppointmentsModel;



@RestController  
@RequestMapping(value="/organiser")
public class AppointmentsControllerOrganizer implements IAppointmentsControllerOrganiser {

	@Autowired 
	private AppointmentsModel model;  //https://stackoverflow.com/a/52526618
	
	@Override
	@GetMapping(value="/new", produces = "application/json")
	public AppointmentCreation IncomingNewEvent(AppointmentCreation event) {
		
		return null;
	}

	@Override
	@GetMapping(value="/report", produces = "application/json")
	public EventUUID IncomingReport(EventUUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(value="/change", produces = "application/json")
	public AppointmentCreation IncomingChangeEvent(AppointmentCreation event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(value="/cancel", produces = "application/json")
	public EventUUID IncomingDeleteEvent(EventUUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping(value="/report", produces = "application/json")
	public void EventReport(@RequestBody AppointmentCreation appEvent) {
		
		String organizerName = appEvent.getOrganizer();
		
		model.report(organizerName, appEvent);
	
	}

}
