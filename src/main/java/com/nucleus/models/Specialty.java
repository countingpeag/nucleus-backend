package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="specialities")
public class Specialty {
	
	private int specialityKeycode;
	private String specialityName;
	
	public Specialty(){
		
	}
	
	public Specialty(int specialityKeycode, String specialityName) {
		this.specialityKeycode = specialityKeycode;
		this.specialityName = specialityName;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="specialty_keycode")
	public int getSpecialityKeycode() {
		return specialityKeycode;
	}
	public void setSpecialityKeycode(int specialityKeycode) {
		this.specialityKeycode = specialityKeycode;
	}
	
	@Column(name="specialty_name")
	public String getSpecialityName() {
		return specialityName;
	}
	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

}
