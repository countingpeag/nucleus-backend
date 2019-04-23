package com.nucleus.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

	private String studentTuition;
	private String studentName;
	private String studentLastNameFather;
	private String studentLastNameMother;
	private String studentPassword;
	private char studentGenre;
	private int studentLevel;
	private String studentShift;
	private Group idGroup;
	private Speciality idSpeciality;
	private Institute idInstitute;
	private char studentVisibility;		
	
	private List<Schedule> schedules= new ArrayList<Schedule>();
	
	public Student() {
		
	}

	public Student(String studentTuition, String studentName, String studentLastNameFather,
			String studentLastNameMother, String studentPassword, char studentGenre, int studentLevel,
			String studentShift, Group idGroup, Speciality idSpeciality, Institute idInstitute, char studentVisibility,
			List<Schedule> schedules) {
		super();
		this.studentTuition = studentTuition;
		this.studentName = studentName;
		this.studentLastNameFather = studentLastNameFather;
		this.studentLastNameMother = studentLastNameMother;
		this.studentPassword = studentPassword;
		this.studentGenre = studentGenre;
		this.studentLevel = studentLevel;
		this.studentShift = studentShift;
		this.idGroup = idGroup;
		this.idSpeciality = idSpeciality;
		this.idInstitute = idInstitute;
		this.studentVisibility = studentVisibility;
		this.schedules = schedules;
	}

	@Id
	@Column(name="student_tuition")
	public String getStudentTuition() {
		return studentTuition;
	}
	public void setStudentTuition(String studentTuition) {
		this.studentTuition = studentTuition;
	}
	
	@Column(name="student_name")
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Column(name="student_lastname_father")
	public String getStudentLastNameFather() {
		return studentLastNameFather;
	}

	public void setStudentLastNameFather(String studentLastNameFather) {
		this.studentLastNameFather = studentLastNameFather;
	}

	@Column(name="student_lastname_mother")
	public String getStudentLastNameMother() {
		return studentLastNameMother;
	}

	public void setStudentLastNameMother(String studentLastNameMother) {
		this.studentLastNameMother = studentLastNameMother;
	}

	@Column(name="student_password")
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	@Column(name="student_genre")
	public char getStudentGenre() {
		return studentGenre;
	}
	public void setStudentGenre(char studentGenre) {
		this.studentGenre = studentGenre;
	}
	
	@Column(name="student_level")
	public int getStudentLevel() {
		return studentLevel;
	}
	public void setStudentLevel(int studentLevel) {
		this.studentLevel = studentLevel;
	}
	
	@Column(name="student_shift")
	public String getStudentShift() {
		return studentShift;
	}

	public void setStudentShift(String studentShift) {
		this.studentShift = studentShift;
	}

	@ManyToOne
	@JoinColumn(name="GROUPS_id_groups", foreignKey=@ForeignKey(name="id_groups"))
	public Group getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(Group idGroup) {
		this.idGroup = idGroup;
	}
	
	@ManyToOne
	@JoinColumn(name="SPECIALITIES_specialty_keycode", foreignKey=@ForeignKey(name="specialty_keycode"))
	public Speciality getIdSpeciality() {
		return idSpeciality;
	}
	public void setIdSpeciality(Speciality idSpeciality) {
		this.idSpeciality = idSpeciality;
	}
	
	@ManyToOne
	@JoinColumn(name="INSTITUTES_id_institute", foreignKey=@ForeignKey(name="id_institute"))
	public Institute getIdInstitute() {
		return idInstitute;
	}
	public void setIdInstitute(Institute idInstitute) {
		this.idInstitute = idInstitute;
	}
	
	@Column(name="student_visibility")
	public char getStudentVisibility() {
		return studentVisibility;
	}

	public void setStudentVisibility(char studentVisibility) {
		this.studentVisibility = studentVisibility;
	}

	@ManyToMany
	@JoinTable(
			name="STUDENTS_has_SCHEDULES",
			joinColumns = { @JoinColumn(name="STUDENTS_student_tuition") },
			inverseJoinColumns = { @JoinColumn(name="SCHEDULES_id_schedule") }
	)
	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "Student [studentTuition=" + studentTuition + ", studentName=" + studentName + ", studentLastName="
				+ studentLastNameFather + ", studentPassword=" + studentPassword + ", studentGenre=" + studentGenre
				+ ", studentLevel=" + studentLevel + ", studentShift=" + studentShift + ", idGroup=" + idGroup
				+ ", idSpeciality=" + idSpeciality + ", idInstitute=" + idInstitute + ", studentVisibility="
				+ studentVisibility + ", schedules=" + schedules + "]";
	}
	
}
