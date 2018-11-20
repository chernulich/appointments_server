package com.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.application.dto.AppointmentCreation;
import com.appointments.application.dto.EventUUID;
import com.appointments.model.AppointmentsModel;
import com.appointments.model.IAppointmentsModel;



@RestController  
@RequestMapping(value="/organiser")
public class AppointmentsControllerOrganizer implements IAppointmentsControllerOrganiser {

	@Autowired 
	private IAppointmentsModel model;  //https://stackoverflow.com/a/52526618
	
	@Override
	@GetMapping(value="/create/", produces = "application/json")
	public AppointmentCreation IncomingNewEvent(@RequestParam(value="orgname") String organiserName) {
		
		System.out.println(organiserName);
		
		return model.pendingToCreate(organiserName);
		
	}

	@Override
	@GetMapping(value="/read", produces = "application/json")
	public EventUUID IncomingReport(@RequestParam(value="orgname") String organiserName) {
		
		return new EventUUID(model.pendingToReport(organiserName));
	}

	@Override
	@GetMapping(value="/update", produces = "application/json")
	public AppointmentCreation IncomingChangeEvent(@RequestParam(value="orgname") String organiserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(value="/delete", produces = "application/json")
	public EventUUID IncomingDeleteEvent(@RequestParam(value="orgname") String organiserName) {
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
