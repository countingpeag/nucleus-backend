package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="scores")
public class Score {
	
	private int idScore;
	private double p1;
	private double p2;
	private double p3;
	private double finalScore;
	private int absences;
	
	private Student studentTuition;
	private Subject subjectKeycode;
	
	public Score() {}
	
	public Score(int idScore, int p1, int p2, int p3, int finalScore, int absences, Student studentTuition, Subject subjectKeycode) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.finalScore = finalScore;
		this.absences = absences;
		this.studentTuition = studentTuition;
		this.subjectKeycode = subjectKeycode;
	}


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_score")
	public int getIdScore() {
		return idScore;
	}

	public void setIdScore(int idScore) {
		this.idScore = idScore;
	}

	@Column(name="p1")
	public double getP1() {
		return p1;
	}

	public void setP1(double p1) {
		this.p1 = p1;
	}

	@Column(name="p2")
	public double getP2() {
		return p2;
	}

	public void setP2(double p2) {
		this.p2 = p2;
	}

	@Column(name="p3")
	public double getP3() {
		return p3;
	}

	public void setP3(double p3) {
		this.p3 = p3;
	}

	@Column(name="final_score")
	public double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}

	@Column(name="absences")
	public int getAbsences() {
		return absences;
	}

	public void setAbsences(int absences) {
		this.absences = absences;
	}

	@ManyToOne
	@JoinColumn(name="STUDENTS_student_tuition", foreignKey=@ForeignKey(name="student_tuition"))
	public Student getStudentTuition() {
		return studentTuition;
	}

	public void setStudentTuition(Student studentTuition) {
		this.studentTuition = studentTuition;
	}

	@ManyToOne
	@JoinColumn(name="SUBJECTS_subject_keycode", foreignKey=@ForeignKey(name="subject_keycode"))
	public Subject getSubjectKeycode() {
		return subjectKeycode;
	}

	public void setSubjectKeycode(Subject subjectKeycode) {
		this.subjectKeycode = subjectKeycode;
	}
	
}
