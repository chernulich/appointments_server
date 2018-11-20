package com.appointments.application.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * dto for report operations: give me status of event with this UID 
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventUUID {
	UUID uid;
}
