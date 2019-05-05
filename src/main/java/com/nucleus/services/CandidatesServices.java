package com.nucleus.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nucleus.dao.CandidatesDAO;
import com.nucleus.models.Candidate;

@Path("/candidates")
public class CandidatesServices {

	@GET
	@Path("/retrieve/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidate> retrieveCandidates(@PathParam("token") String token) {
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		if(jwt.parseJWT(token)) {
			CandidatesDAO candidateDAO = new CandidatesDAO();
			return candidateDAO.getAllCandidates();
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCandidate(Candidate candi)
	{	
		CandidatesDAO candidateDAO = new CandidatesDAO();
		boolean res = candidateDAO.saveCandidates(candi);

		if(res == true)
			return Response.ok().entity("successful").build();
		else 
			return Response.status(500).entity("fail").build();
		
	}
}
