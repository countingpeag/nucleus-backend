package com.nucleus.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nucleus.models.Student;
import com.nucleus.requestModels.StudentRequestModel;

@Path("/students")
public class StudentServices {

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents(StudentRequestModel scoreRequest){
		System.out.println(scoreRequest.getGroup().getGroupName());
		List<Student> students = new ArrayList<Student>();
		return students;
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateStudents(Student student){
		System.out.println(student.getStudentName());
	}
	
}
