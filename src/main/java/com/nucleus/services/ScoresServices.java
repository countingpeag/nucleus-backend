package com.nucleus.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nucleus.models.Score;
import com.nucleus.requestModels.ScoreRequestModel;

@Path("/scores")
public class ScoresServices {

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Score> getScores(ScoreRequestModel scoreRequest){
		System.out.println(scoreRequest.getSpeciality().getSpecialityName());
		List<Score> scores = new ArrayList<Score>();
		return scores;
	}
}
