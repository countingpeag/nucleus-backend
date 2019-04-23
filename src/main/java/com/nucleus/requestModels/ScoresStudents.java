package com.nucleus.requestModels;

import com.nucleus.models.Group;
import com.nucleus.models.Speciality;
import com.nucleus.models.Subject;

public class ScoresStudents {

	private Subject subject;
	private Group group; 
	private Speciality specialty;
	private String shift;
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Speciality getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Speciality specialty) {
		this.specialty = specialty;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}

}