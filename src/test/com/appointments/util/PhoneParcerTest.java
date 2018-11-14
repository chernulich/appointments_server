package com.appointments.util;

import com.appointments.util.PhoneParcer;

/**
 * Library for parsing phone numbers
 * https://github.com/googlei18n/libphonenumber
 */
public class PhoneParcerTest {
	
	public static void main(String[] args) {

		PhoneParcer.printPhoneNumber("+7 999 078 69 99");
		PhoneParcer.printPhoneNumber("+972 054 878 29 39");
		PhoneParcer.printPhoneNumber("+7 495 379 69 49");
		PhoneParcer.printPhoneNumber("+7 831 604 24 39");
		
	}

	
}
