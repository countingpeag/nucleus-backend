package com.nucleus.models;

import java.util.List;

public class StatisticsForm {

	private List<Specialty> specialities;
	private List<Subject> subjects;
	private String shift;
	
	public List<Specialty> getSpecialities() {
		return specialities;
	}
	public void setSpecialities(List<Specialty> specialities) {
		this.specialities = specialities;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
}
