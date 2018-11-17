package com.appointments.application.dto;

import java.rmi.server.UID;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * dto for report operations: give me status of event with this UID 
 */
@Data
public class EventUUID {
	UID UUID;
}
