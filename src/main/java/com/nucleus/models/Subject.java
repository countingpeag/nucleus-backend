package com.nucleus.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class Subject {

	private int subjectKeyCode;
	private String subjectName;
	private int subjectLevel;
	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	public Subject() {}
	
	public Subject(int subjectKeyCode, String subjectName, int subjectLevel) {
		this.subjectKeyCode = subjectKeyCode;
		this.subjectName = subjectName;
		this.subjectLevel = subjectLevel;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subject_keycode")
	public int getSubjectKeyCode() {
		return subjectKeyCode;
	}
	public void setSubjectKeyCode(int subjectKeyCode) {
		this.subjectKeyCode = subjectKeyCode;
	}
	
	@Column(name="subject_name")
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Column(name="subject_level")
	public int getSubjectLevel() {
		return subjectLevel;
	}
	public void setSubjectLevel(int subjectLevel) {
		this.subjectLevel = subjectLevel;
	}
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy = "subjects")
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
