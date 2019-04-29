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
import javax.ws.rs.core.Response;

import com.nucleus.dao.CandidatesDAO;
import com.nucleus.models.Candidate;
import com.nucleus.models.Health;
import com.nucleus.models.Preference;


@Path("/candidates")
public class CandidatesServices {

	@GET
	@Path("/retrieve/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidate> retrieveCandidates(@PathParam("token") String token) {
		/*List<Candidate> candidates = new ArrayList<Candidate>();
		Health health = new Health();
		Preference pre = new Preference();
		health.setInsuranceNumber("123456789");
		Candidate candidate1 = new Candidate();
		candidate1.setCandidateName("omar");
		candidate1.setHealth(health);
		candidate1.setPreference(pre);
		Candidate candidate2 = new Candidate();
		candidate2.setCandidateName("erick");
		candidate2.setHealth(health);
		candidate2.setPreference(pre);
		candidates.add(candidate1);
		candidates.add(candidate2);
		return candidates;*/
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
		System.out.println(candi.getCandidateName());
		System.out.println(candi.getCandidateCellPhone());
		System.out.println(candi.getCandidatePersonalPhone());
		if(res == true)
			return Response.ok().entity("successful").build();
		else 
			return Response.status(500).entity("fail").build();
		
	}
}
