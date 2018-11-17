package com.appointments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.application.dto.AppointmentEvent;
import com.appointments.application.dto.EventUUID;
import com.appointments.model.AppointmentsModel;



@RestController  
@RequestMapping(value="/attendee")
public class AppointmentsControllerAttendee implements IAppointmentsControllerAttendee {


	@Autowired 
	private AppointmentsModel model;  	//https://stackoverflow.com/a/52526618
	
	@Override
	@PostMapping(value="/create", produces = "application/json")
	public Boolean  CreateEvent(@RequestBody AppointmentEvent appEvent) {
		
		//TODO: implement https://stackoverflow.com/questions/37844101/can-you-configure-spring-controller-specific-jackson-deserialization
		// as I can't deserialize VEvent because of multiple constructors; 
		
		String organiserName = appEvent.getEvent().getOrganizer().getCommonName();
		return model.create(organiserName, appEvent.getEvent());
	}

	@Override
	@GetMapping(value="/read", produces = "application/json")
	public AppointmentEvent ReportEvent(@RequestParam(value="uuid") long uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping(value="/update", produces = "application/json")
	public AppointmentEvent ChangeEvent(@RequestBody AppointmentEvent event) {
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
		// TODO Auto-generated method stub
		return "Hello world";
	}

}
