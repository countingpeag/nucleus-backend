package com.nucleus.models;

import java.util.List;

public class ValidationForm {
	
	private List<Speciality> specialities;
	private List<Group> groups;
	private String shift;
	
	public List<Speciality> getSpecialities() {
		return specialities;
	}
	public void setSpecialities(List<Speciality> specialities) {
		this.specialities = specialities;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
}
