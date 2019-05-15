package com.nucleus.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nucleus.dao.AdministratorDAO;
import com.nucleus.dao.CandidateSelectionDAO;
import com.nucleus.dao.GroupDAO;
import com.nucleus.dao.ScoreDAO;
import com.nucleus.dao.SpecialityDAO;
import com.nucleus.dao.StatisticsDAO;
import com.nucleus.dao.StudentDAO;
import com.nucleus.dao.SubjectDAO;
import com.nucleus.models.Administrator;
import com.nucleus.models.StatisticsForm;
import com.nucleus.models.Student;
import com.nucleus.models.Subject;
import com.nucleus.models.ValidationForm;
import com.nucleus.requestModels.AdminRequestModel;
import com.nucleus.requestModels.CandidatesSelection;
import com.nucleus.requestModels.DataStatistics;
import com.nucleus.requestModels.ScoreRequestModel;
import com.nucleus.requestModels.StudentRequestModel;

@Path("/admin")
public class AdministratorServices {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/auth")
	public String authentication(Administrator admin) {
		
		AdministratorDAO admDAO = new AdministratorDAO();
		Administrator administrator = admDAO.getLogin(admin);
		
		if(administrator!=null) {
			JavaJSONWebTokens token = new JavaJSONWebTokens();
			return token.createJWT(Integer.toString(admin.getIdAdministrator()), "administrator", 5000, administrator);
		}
		
		return "false";
	}
	
	@POST
	@Path("/statistics/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataStatistics getStatisticsData(ScoreRequestModel formStatistics, @PathParam("token") String token) {
		
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		StatisticsDAO statisticsdao = new StatisticsDAO();
		DataStatistics data = null;
		
		if(jwt.parseJWT(token)) {
			String shift = formStatistics.getShift();
			int specialityKeyCode = formStatistics.getSpeciality().getSpecialityKeycode();
			int subjectKeyCode = formStatistics.getSubject().getSubjectKeyCode();

			data = statisticsdao.getDataStatistics(subjectKeyCode, specialityKeyCode, shift);
		}

		return data;
	}
	
	@PUT
	@Path("/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String updatePassword(AdminRequestModel adminRequest, @PathParam("token") String token) {
		
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		if(jwt.parseJWT(token)) {
			AdministratorDAO adminDAO = new AdministratorDAO();
			if(adminDAO.updatePassword(adminRequest))
				return "true";
		}
		
		return "false";
	}
	
	@POST
	@Path("/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student getDataValidation(StatisticsForm formValidation, @PathParam("token") String token) {
	
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		Student student =  null;
		if(jwt.parseJWT(token)) {
			System.out.println("hello1");
			return student;
		}
		return student;
	}
	
	@GET
	@Path("/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ValidationForm getValidationOptions(@PathParam("token") String token) {
	
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();

		ValidationForm validationForm = new ValidationForm();
		SpecialityDAO specialityDAO = new SpecialityDAO();
		GroupDAO groupDAO = new GroupDAO();
		
		if(jwt.parseJWT(token)) {
			
			validationForm.setSpecialities(specialityDAO.readAll());
			validationForm.setGroups(groupDAO.readAll());
		}
		
		return validationForm;
	}
	
	@GET
	@Path("/candidatesSelection")
	@Produces(MediaType.APPLICATION_JSON)
	public CandidatesSelection retrieveCandiatesSelection() {
		CandidateSelectionDAO candidateSelection = new CandidateSelectionDAO();
		
		return candidateSelection.getCandidatesSelected();
	}
	
	@POST
	@Path("/students/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentsData(StudentRequestModel validationOptions, @PathParam("token") String token){
		List<Student> list  = null;
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		
		if(jwt.parseJWT(token)) {
			StudentDAO studentDAO = new StudentDAO();
			int specialityKeycode = validationOptions.getSpeciality().getSpecialityKeycode();
			int idGroup = validationOptions.getGroup().getIdGroup();
			String shift = validationOptions.getShift();
			
			list = studentDAO.getValidationStudents(specialityKeycode, idGroup, shift);
		}
		
		return list;
	}
	
	@POST
	@Path("/validation/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean setStudents(List<Student> students, @PathParam("token") String token) {
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		
		if(jwt.parseJWT(token)) {
			StudentDAO studentDAO = new StudentDAO();
			return studentDAO.updateStudentVisibility(students);
		}
		
		return false;
	}
	
	@POST
	@Path("/getStudent/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(StudentRequestModel student1, @PathParam("token") String token) {
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		
		if(jwt.parseJWT(token)) {
			StudentDAO studentDAO = new StudentDAO();
			Student student = studentDAO.getStudentByTuition(Long.parseLong(student1.getTuition().trim()));
			return student;
		}
		
		return null;
	}
	
	@POST
	@Path("/deleteStudent/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteStudent(Student student, @PathParam("token") String token) {
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		
		if(jwt.parseJWT(token)) {
			ScoreDAO scoreDAO = new ScoreDAO();
			
			return scoreDAO.deleteScoreByStudent(student);
		}
		
		return false;
	}
	
	@POST
	@Path("/getSubject/{token}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Subject getSubject(String subjectName, @PathParam("token") String token) {
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		
		if(jwt.parseJWT(token)) {

			SubjectDAO subjectDAO = new SubjectDAO();
			return subjectDAO.getSubjectByName(subjectName.trim());
		}
		
		return new Subject();
	}
	
	@PUT
	@Path("/updateSubject/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateSubject(Subject subject, @PathParam("token") String token) {
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		
		if(jwt.parseJWT(token)) {
			SubjectDAO subjectDAO = new SubjectDAO();
			return subjectDAO.update(subject);
		}
		
		return false;
	}
	
	@POST
	@Path("/addSubject/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addSubject(ArrayList<Subject> subjects, @PathParam("token") String token) {
		JavaJSONWebTokens jwt = new JavaJSONWebTokens();
		
		if(jwt.parseJWT(token)) {
			SubjectDAO subjectDAO = new SubjectDAO();
			
			for(Subject subject: subjects) {
				subject.setSubjectKeyCode(0);
				if(!subjectDAO.create(subject))
					return false;
			}
			return true;
		}
		
		return false;
	}
	
}
