package com.nucleus.requestModels;

import com.nucleus.models.Group;
import com.nucleus.models.Specialty;
import com.nucleus.models.Subject;

public class TeacherReport {

	private Subject subject;
	private Group group; 
	private Specialty specialty;
	private String shift;
	private String dataType;
	
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
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
