package com.nucleus.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nucleus.dao.GroupDAO;
import com.nucleus.dao.ScoreDAO;
import com.nucleus.dao.SpecialityDAO;
import com.nucleus.dao.SubjectDAO;
import com.nucleus.dao.TeacherDAO;
import com.nucleus.dao.TeacherReportDAO;
import com.nucleus.models.Teacher;
import com.nucleus.requestModels.ScoresStudents;
import com.nucleus.requestModels.TeacherDataReport;
import com.nucleus.requestModels.TeacherReport;
import com.nucleus.models.Group;
import com.nucleus.models.Score;
import com.nucleus.models.Specialty;
import com.nucleus.models.Subject;

@Path("/teacher")
public class TeacherServices {

	private JavaJSONWebTokens jwt = new JavaJSONWebTokens();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/auth")
	public String authentication(Teacher teacher) {
		TeacherDAO teacherDAO = new TeacherDAO();
		Teacher obj = teacherDAO.getLogin(teacher);
		
		if(obj!=null) {
			JavaJSONWebTokens token = new JavaJSONWebTokens();
			return token.createJWT(Integer.toString(obj.getIdTeacher()), "teacher", 5000, obj);
		}

		return "false";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/subjects/{token}")
	public List<Subject> retrieveSubjectsByTeacher(Teacher teacher, @PathParam("token") String token){
		if(jwt.parseJWT(token)) {
			SubjectDAO subjectDAO = new SubjectDAO();
			return subjectDAO.getSubjectsByTeacher(teacher);
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/specialities")
	public List<Specialty> retrieveSpecialities(Teacher teacher){
		SpecialityDAO specialityDAO = new SpecialityDAO();
		return specialityDAO.getSpecialitiesByTeacher(teacher);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/groups")
	public List<Group> retrieveGroups(){
		GroupDAO groupDAO = new GroupDAO();
		return groupDAO.readAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/scores")
	public List<Score> retrieveScores(ScoresStudents scoreStudents){
		ScoreDAO scoreDAO = new ScoreDAO();
		return scoreDAO.getStudentsByTest(scoreStudents.getSubject(), scoreStudents.getGroup(), scoreStudents.getSpecialty(), scoreStudents.getShift());
	}
	
	@GET
	@Path("/getTeacher/{rfc}/{token}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher retrieveTeacherByName(@PathParam("rfc") String rfc, @PathParam("token") String token) {
		if(jwt.parseJWT(token)) {
			TeacherDAO teacherDAO = new TeacherDAO();
			return teacherDAO.getTeacherByName(rfc);
		}
		return null;
	}
	
	@PUT
	@Path("/saveorupdateTeacher/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean saveOrUpdate(Teacher teacher, @PathParam("token") String token) {
		if(jwt.parseJWT(token)) {
			TeacherDAO teacherDAO = new TeacherDAO();
			return teacherDAO.saveTeacher(teacher);
		}
		return false;
	}
	
	@POST
	@Path("/dataReport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherDataReport retrieveDataToTeacherReport(TeacherReport data) {
		TeacherReportDAO reportDAO = new TeacherReportDAO();
		return reportDAO.getTeacherReportData(data);
	}
	
}
