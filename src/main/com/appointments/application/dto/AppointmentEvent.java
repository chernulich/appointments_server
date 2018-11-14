package com.appointments.application.dto;

import biweekly.component.VEvent;

public class AppointmentEvent {
	VEvent event;

	public AppointmentEvent() {
		super();
	}
	
	public AppointmentEvent(VEvent event) {
		super();
		this.event = event;
	}
	
	public VEvent getEvent() {
		return event;
	}

	public void setEvent(VEvent event) {
		this.event = event;
	}


}
