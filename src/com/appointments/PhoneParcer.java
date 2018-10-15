package com.appointments;

import java.util.Locale;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

public class PhoneParcer {
	
	public static void printPhoneNumber(String number) {

		System.out.println("\nPHONE NUMBER IS " + number);
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();
		try {
			PhoneNumber parsed = phoneUtil.parse(number, "CH");
			parsedPrint(geocoder, parsed);
		} catch (NumberParseException e) {
			System.err.println("NumberParseException was thrown: " + e.toString());
		}

	}

	private static void parsedPrint(PhoneNumberOfflineGeocoder geocoder, PhoneNumber parsed) {
		System.out.println("COUNTRY CODE " + parsed.getCountryCode());
		System.out.println("NATIONAL NUMBER " + parsed.getNationalNumber());
		System.out.println("LOCATION " + geocoder.getDescriptionForNumber(parsed, Locale.ENGLISH));
	}
}
