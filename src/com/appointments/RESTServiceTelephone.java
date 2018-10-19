package com.appointments;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/")
public class RESTServiceTelephone {

	@POST
	@Path("/phone")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phoneREST(InputStream incomingData) {
		StringBuilder phoneBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				phoneBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		
		String phone = phoneBuilder.toString();
		PhoneParcer.printPhoneNumber(phone);
 

		System.out.println("phone");
		
		// return HTTP response 200 in case of success
		return Response.status(200).entity(PhoneParcer.parcePhoneNumber(phone)).build();
	}

	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";

		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}

}