package com.nucleus.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class Teacher {
	
	private int idTeacher;
	private String teacherName;
	private String teacherLastNameFather;
	private String teacherLastNameMother;
	private String teacherUsername;
	private String teacherPassword;
	private char teacherGenre;
	private String teacherRFC;
	
	private Institute idInstitute;
	private List<Subject> subjects = new ArrayList<Subject>(); 
	private List<Specialty> specialities = new ArrayList<Specialty>();
	
	public Teacher() {
		
	}

	public Teacher(int idTeacher, String teacherName, String teacherLastNameFather, String teacherLastNameMother,
			String teacherUsername, String teacherPassword, char teacherGenre, String teacherRFC, Institute idInstitute,
			List<Subject> subjects, List<Specialty> specialities) {
		super();
		this.idTeacher = idTeacher;
		this.teacherName = teacherName;
		this.teacherLastNameFather = teacherLastNameFather;
		this.teacherLastNameMother = teacherLastNameMother;
		this.teacherUsername = teacherUsername;
		this.teacherPassword = teacherPassword;
		this.teacherGenre = teacherGenre;
		this.teacherRFC = teacherRFC;
		this.idInstitute = idInstitute;
		this.subjects = subjects;
		this.specialities = specialities;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_teachers")
	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	@Column(name="teacher_name")
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Column(name="teacher_lastname_father")
	public String getTeacherLastNameFather() {
		return teacherLastNameFather;
	}

	public void setTeacherLastNameFather(String teacherLastNameFather) {
		this.teacherLastNameFather = teacherLastNameFather;
	}

	@Column(name="teacher_lastname_mother")
	public String getTeacherLastNameMother() {
		return teacherLastNameMother;
	}

	public void setTeacherLastNameMother(String teacherLastNameMother) {
		this.teacherLastNameMother = teacherLastNameMother;
	}

	@Column(name="teacher_username")
	public String getTeacherUsername() {
		return teacherUsername;
	}

	public void setTeacherUsername(String teacherUsername) {
		this.teacherUsername = teacherUsername;
	}

	@Column(name="teacher_password")
	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	@Column(name="teacher_genre")
	public char getTeacherGenre() {
		return teacherGenre;
	}

	public void setTeacherGenre(char teacherGenre) {
		this.teacherGenre = teacherGenre;
	}
	
	@Column(name="teacher_rfc")
	public String getTeacherRFC() {
		return teacherRFC;
	}

	public void setTeacherRFC(String teacherRFC) {
		this.teacherRFC = teacherRFC;
	}

	@ManyToOne
	@JoinColumn(name="INSTITUTES_id_institute", foreignKey=@ForeignKey(name="id_institute"))
	public Institute getIdInstitute() {
		return idInstitute;
	}

	public void setIdInstitute(Institute idInstitute) {
		this.idInstitute = idInstitute;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="teachers_has_subjects",
				joinColumns = { @JoinColumn(name="id_teachers_join")},
				inverseJoinColumns = { @JoinColumn(name="subject_keycode_join")})
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="teachers_has_specialities",
				joinColumns = { @JoinColumn(name="TEACHERS_id_teachers")},
				inverseJoinColumns = { @JoinColumn(name="SPECIALITIES_specialty_keycode")})
	public List<Specialty> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<Specialty> specialities) {
		this.specialities = specialities;
	}
	
}
