package com.nucleus.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nucleus.dao.StatisticsDAO;
import com.nucleus.models.StatisticsForm;
import com.nucleus.requestModels.DataStatistics;
import com.nucleus.requestModels.ScoreRequestTeacher;

@Path("/statistics")
public class StatisticsServices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StatisticsForm getStatisticsData() {
		
		StatisticsDAO statistics = new StatisticsDAO();
		return statistics.getDataStatisticsOptions();
	}
	
	@POST
	@Path("/dataTeacher")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DataStatistics statisticsDataForTeachers(ScoreRequestTeacher request) {
		StatisticsDAO statisticsDAO = new StatisticsDAO();
		return statisticsDAO.retrieveDataStatisticsForTeacher(request.getSubject(), request.getSpecialty(), request.getGroup(), request.getShift());
	}
}
