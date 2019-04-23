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
@Table(name="teachers_availability")
public class TeachersAvailability {
	
	private int idAvailability;
	private Date availabilityInitTime;
	private Date availabilityFinishTime;
	private Teacher teacher;
	
	public TeachersAvailability() {}
	
	public TeachersAvailability(Date availabilityInitTime, Date availabilityFinishTime, Teacher teacher) {
		this.availabilityInitTime = availabilityInitTime;
		this.availabilityFinishTime = availabilityFinishTime;
		this.teacher = teacher;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_availability")
	public int getIdAvailability() {
		return idAvailability;
	}

	public void setIdAvailability(int idAvailability) {
		this.idAvailability = idAvailability;
	}

	@Column(name="availability_init_time")
	public Date getAvailabilityInitTime() {
		return availabilityInitTime;
	}

	public void setAvailabilityInitTime(Date availabilityInitTime) {
		this.availabilityInitTime = availabilityInitTime;
	}

	@Column(name="availbility_finish_time")
	public Date getAvailabilityFinishTime() {
		return availabilityFinishTime;
	}

	public void setAvailabilityFinishTime(Date availabilityFinishTime) {
		this.availabilityFinishTime = availabilityFinishTime;
	}

	@ManyToOne
	@JoinColumn(name="TEACHERS_id_teachers", foreignKey=@ForeignKey(name="id_teachers"))
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
