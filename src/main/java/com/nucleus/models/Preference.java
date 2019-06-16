package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="preferences") 

public class Preference {

	private int idPreference;
	private String preferencesScholarshipFlag;
	private String preferencesShiftWished;
	private String preferencesWayToKnow;
	private String preferencesSpecialtyWhished1;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_preferences")
	public int getIdPreference() {
		return idPreference;
	}
	public void setIdPreference(int idPreference) {
		this.idPreference = idPreference;
	}
	
	@Column(name="preferences_scholarship_flag")
	public String getPreferencesScholarshipFlag() {
		return preferencesScholarshipFlag;
	}
	public void setPreferencesScholarshipFlag(String preferencesScholarshipFlag) {
		this.preferencesScholarshipFlag = preferencesScholarshipFlag;
	}
	
	@Column(name="preferences_shift_wished")
	public String getPreferencesShiftWished() {
		return preferencesShiftWished;
	}
	public void setPreferencesShiftWished(String preferencesShiftWished) {
		this.preferencesShiftWished = preferencesShiftWished;
	}
	
	@Column(name="preferences_waytoknow")
	public String getPreferencesWayToKnow() {
		return preferencesWayToKnow;
	}
	public void setPreferencesWayToKnow(String preferencesWayToKnow) {
		this.preferencesWayToKnow = preferencesWayToKnow;
	}
	
	@Column(name="preferences_specialty_wished1")
	public String getPreferencesSpecialtyWhished1() {
		return preferencesSpecialtyWhished1;
	}
	public void setPreferencesSpecialtyWhished1(String preferencesSpecialtyWhished1) {
		this.preferencesSpecialtyWhished1 = preferencesSpecialtyWhished1;
	}
	
}
