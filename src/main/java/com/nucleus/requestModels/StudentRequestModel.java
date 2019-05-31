package com.nucleus.requestModels;

import com.nucleus.models.Group;
import com.nucleus.models.Specialty;

public class StudentRequestModel {

	private Specialty speciality;
	private Group group;
	private String shift;
	private String tuition;
	
	public Specialty getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Specialty speciality) {
		this.speciality = speciality;
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
	public String getTuition() {
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	
}
