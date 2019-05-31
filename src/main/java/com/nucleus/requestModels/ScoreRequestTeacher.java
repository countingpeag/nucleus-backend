package com.nucleus.requestModels;

import com.nucleus.models.Group;
import com.nucleus.models.Specialty;
import com.nucleus.models.Subject;

public class ScoreRequestTeacher {

	private Specialty specialty;
	private Subject subject;
	private Group group;
	private String shift;
	
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
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
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
}
