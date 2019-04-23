package com.nucleus.models;

import java.util.Date;

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
@Table(name="schedules")
public class Schedule {
	private int idSchedule;
	private Date mondayInit;
	private Date mondayFinish;
	private Date tuesdayInit;
	private Date tuesdayFinish;
	private Date wednesdayInit;
	private Date wednesdayFinish;
	private Date thursdayInit;
	private Date thursdayFinish;
	private Date frydayInit;
	private Date frydayFinish;
	private Date saturdayInit;
	private Date saturdayFinish;
	
	private Subject subjectKeycode;
	private Group idGroup;
	private Teacher idTeacher;
	
	public Schedule()
	{
		
	}

	public Schedule(Date mondayInit, Date mondayFinish, Date tuesdayInit, Date tuesdayFinish,
			Date wednesdayInit, Date wednesdayFinish, Date thursdayInit, Date thursdayFinish, Date frydayInit,
			Date frydayFinish, Date saturdayInit, Date saturdayFinish, Subject subjectKeycode, Group idGroup,
			Teacher idTeacher) {
		this.mondayInit = mondayInit;
		this.mondayFinish = mondayFinish;
		this.tuesdayInit = tuesdayInit;
		this.tuesdayFinish = tuesdayFinish;
		this.wednesdayInit = wednesdayInit;
		this.wednesdayFinish = wednesdayFinish;
		this.thursdayInit = thursdayInit;
		this.thursdayFinish = thursdayFinish;
		this.frydayInit = frydayInit;
		this.frydayFinish = frydayFinish;
		this.saturdayInit = saturdayInit;
		this.saturdayFinish = saturdayFinish;
		this.subjectKeycode = subjectKeycode;
		this.idGroup = idGroup;
		this.idTeacher = idTeacher;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_schedule")
	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	@Column(name="monday_init")
	public Date getMondayInit() {
		return mondayInit;
	}

	public void setMondayInit(Date mondayInit) {
		this.mondayInit = mondayInit;
	}

	@Column(name="monday_finish")
	public Date getMondayFinish() {
		return mondayFinish;
	}

	public void setMondayFinish(Date mondayFinish) {
		this.mondayFinish = mondayFinish;
	}

	@Column(name="tuesday_init")
	public Date getTuesdayInit() {
		return tuesdayInit;
	}

	public void setTuesdayInit(Date tuesdayInit) {
		this.tuesdayInit = tuesdayInit;
	}

	@Column(name="tuesday_finish")
	public Date getTuesdayFinish() {
		return tuesdayFinish;
	}

	public void setTuesdayFinish(Date tuesdayFinish) {
		this.tuesdayFinish = tuesdayFinish;
	}

	@Column(name="wednesday_init")
	public Date getWednesdayInit() {
		return wednesdayInit;
	}

	public void setWednesdayInit(Date wednesdayInit) {
		this.wednesdayInit = wednesdayInit;
	}

	@Column(name="wednesday_finish")
	public Date getWednesdayFinish() {
		return wednesdayFinish;
	}

	public void setWednesdayFinish(Date wednesdayFinish) {
		this.wednesdayFinish = wednesdayFinish;
	}

	@Column(name="thursday_init")
	public Date getThursdayInit() {
		return thursdayInit;
	}

	public void setThursdayInit(Date thursdayInit) {
		this.thursdayInit = thursdayInit;
	}

	@Column(name="thursday_finish")
	public Date getThursdayFinish() {
		return thursdayFinish;
	}

	public void setThursdayFinish(Date thursdayFinish) {
		this.thursdayFinish = thursdayFinish;
	}

	@Column(name="friday_init")
	public Date getFrydayInit() {
		return frydayInit;
	}

	public void setFrydayInit(Date frydayInit) {
		this.frydayInit = frydayInit;
	}

	@Column(name="friday_finish")
	public Date getFrydayFinish() {
		return frydayFinish;
	}

	public void setFrydayFinish(Date frydayFinish) {
		this.frydayFinish = frydayFinish;
	}

	@Column(name="saturday_init")
	public Date getSaturdayInit() {
		return saturdayInit;
	}

	public void setSaturdayInit(Date saturdayInit) {
		this.saturdayInit = saturdayInit;
	}

	@Column(name="saturday_finish")
	public Date getSaturdayFinish() {
		return saturdayFinish;
	}

	public void setSaturdayFinish(Date saturdayFinish) {
		this.saturdayFinish = saturdayFinish;
	}

	@ManyToOne
	@JoinColumn(name="SUBJECTS_subject_keycode", foreignKey=@ForeignKey(name="subject_keycode"))
	public Subject getSubjectKeycode() {
		return subjectKeycode;
	}

	public void setSubjectKeycode(Subject subjectKeycode) {
		this.subjectKeycode = subjectKeycode;
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
	@JoinColumn(name="TEACHERS_id_teachers", foreignKey=@ForeignKey(name="id_teachers"))
	public Teacher getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(Teacher idTeacher) {
		this.idTeacher = idTeacher;
	}
	
}
