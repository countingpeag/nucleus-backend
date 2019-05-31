package com.nucleus.requestModels;

import com.nucleus.models.Specialty;
import com.nucleus.models.Subject;

public class ScoreRequestModel {

	private Specialty speciality;
	private Subject subject;
	private String shift;
	
	public Specialty getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Specialty speciality) {
		this.speciality = speciality;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
}
