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
import com.appointments.model.IAppointmentsModel;



@RestController  
@RequestMapping(value="/attendee")
public class AppointmentsControllerAttendee implements IAppointmentsControllerAttendee {


	@Autowired 
	private IAppointmentsModel model;  	//https://stackoverflow.com/a/52526618
	
	@Override
	@PostMapping(value="/create", produces = "application/json")
	public Boolean  CreateEvent(@RequestBody AppointmentCreation appEvent) {
				
		return model.create(appEvent);
		
	}

	@Override
	@GetMapping(value="/read", produces = "application/json")
	public AppointmentCreation ReportEvent(@RequestParam(value="uuid") long uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping(value="/update", produces = "application/json")
	public AppointmentCreation ChangeEvent(@RequestBody AppointmentCreation event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping(value="/delete", produces = "application/json")
	public boolean DeleteEvent(@RequestBody EventUUID uuid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@GetMapping(value="/test")
	public String test() {
		return "Hello world";
	}

}
