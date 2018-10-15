package com.appointments;

/**
 * @author Crunchify.com
 * 
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/")
public class AppointmentsRESTService {
	
	
	@Path("/getJson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJSON() {
		String string = "";
		Response response = null;
		try {
			InputStream crunchifyInputStream = new FileInputStream("C:\\Users\\Shtirlitz\\Desktop\\Internety_test\\qryTransactions.json");
			InputStreamReader crunchifyReader = new InputStreamReader(crunchifyInputStream);
			BufferedReader br = new BufferedReader(crunchifyReader);
			String line;
			while ((line = br.readLine()) != null) {
				string += line + "\n";
			}
			response = Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity(string).build();
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
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