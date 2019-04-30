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
	private String preferencesSpecialtyWhished2;
	private String preferencesSpecialtyWhished3;
	private String preferencesSpecialtyWhished4;
	
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
	
	@Column(name="preferences_specialty_wished2")
	public String getPreferencesSpecialtyWhished2() {
		return preferencesSpecialtyWhished2;
	}
	public void setPreferencesSpecialtyWhished2(String preferencesSpecialtyWhished2) {
		this.preferencesSpecialtyWhished2 = preferencesSpecialtyWhished2;
	}
	
	@Column(name="preferences_specialty_wished3")
	public String getPreferencesSpecialtyWhished3() {
		return preferencesSpecialtyWhished3;
	}
	public void setPreferencesSpecialtyWhished3(String preferencesSpecialtyWhished3) {
		this.preferencesSpecialtyWhished3 = preferencesSpecialtyWhished3;
	}
	
	@Column(name="preferences_specialty_wished4")
	public String getPreferencesSpecialtyWhished4() {
		return preferencesSpecialtyWhished4;
	}
	public void setPreferencesSpecialtyWhished4(String preferencesSpecialtyWhished4) {
		this.preferencesSpecialtyWhished4 = preferencesSpecialtyWhished4;
	}
	
	
	
}
