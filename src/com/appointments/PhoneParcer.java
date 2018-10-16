package com.appointments;

import java.util.Locale;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

/**
 * Parces a phone number into attribute string
 */
public class PhoneParcer {
	public static String parcePhoneNumber(String number) {

		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();
		try {
			PhoneNumber parsed = phoneUtil.parse(number, "CH");
			return parsedString(geocoder, parsed);
		} catch (NumberParseException e) {
			System.err.println("NumberParseException was thrown: " + e.toString());
		}
		return null;
	}
	public static void printPhoneNumber(String number) {

		System.out.println(parcePhoneNumber(number));

	}

	
	
	private static String parsedString(PhoneNumberOfflineGeocoder geocoder, PhoneNumber parsed) {
		return "COUNTRY CODE " + parsed.getCountryCode() + ""
				+ "; NATIONAL NUMBER " + parsed.getNationalNumber() + 
				"; LOCATION " + geocoder.getDescriptionForNumber(parsed, Locale.ENGLISH);
	}
}
