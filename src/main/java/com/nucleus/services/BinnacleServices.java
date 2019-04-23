
package com.nucleus.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nucleus.models.Binnacle;

@Path("/binnacle")
public class BinnacleServices {

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addRecord(Binnacle record) {
		
		System.out.println(record.getBinnacleAction());
		System.out.println(record.getBinnacleDate());
		System.out.println(record.getIdAdministrator());
	}
	
	@GET
	@Path("/records/{adminName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Binnacle> getBinnacle(@PathParam("adminName") String adminName){
		
		System.out.println(adminName);
		List<Binnacle> list= new ArrayList<Binnacle>();
		
		return list;
	}
}
