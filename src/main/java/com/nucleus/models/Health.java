package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="health") 

public class Health {
	
	private int idHealth;
	private String insuranceNumber;
	private double healthCandidateHeight;
	private double healthCandidateWeight;
	private String healthCandidateBloodType;
	private String healthIllnessFlag;
	private String healthDisability;
	private String healthGlassesFlag;
	private String healthSmokingFlag;
	private String healthLaterality;
	
	
	@Column(name="id_healt")
	public int getIdHealth() {
		return idHealth;
	}
	public void setIdHealth(int idHealth) {
		this.idHealth = idHealth;
	}
	
	@Column(name="healt_insurance_number")
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	
	@Column(name="healt_candidate_height")
	public double getHealthCandidateHeight() {
		return healthCandidateHeight;
	}
	public void setHealthCandidateHeight(double healthCandidateHeight) {
		this.healthCandidateHeight = healthCandidateHeight;
	}
	
	@Column(name="health_candidate_weight")
	public double getHealthCandidateWeight() {
		return healthCandidateWeight;
	}
	public void setHealthCandidateWeight(double healthCandidateWeight) {
		this.healthCandidateWeight = healthCandidateWeight;
	}
	
	@Column(name="health_candidate_bloodtype")
	public String getHealthCandidateBloodType() {
		return healthCandidateBloodType;
	}
	public void setHealthCandidateBloodType(String healthCandidateBloodType) {
		this.healthCandidateBloodType = healthCandidateBloodType;
	}
	
	@Column(name="health_illnes_flag")
	public String getHealthIllnessFlag() {
		return healthIllnessFlag;
	}
	public void setHealthIllnessFlag(String healthIllnessFlag) {
		this.healthIllnessFlag = healthIllnessFlag;
	}
	
	@Column(name="health_disablity")
	public String getHealthDisability() {
		return healthDisability;
	}
	public void setHealthDisability(String healthDisability) {
		this.healthDisability = healthDisability;
	}
	
	@Column(name="health_glasses_flag")
	public String getHealthGlassesFlag() {
		return healthGlassesFlag;
	}
	public void setHealthGlassesFlag(String healthGlassesFlag) {
		this.healthGlassesFlag = healthGlassesFlag;
	}
	
	@Column(name="health_smoking_flag")
	public String getHealthSmokingFlag() {
		return healthSmokingFlag;
	}
	public void setHealthSmokingFlag(String healthSmokingFlag) {
		this.healthSmokingFlag = healthSmokingFlag;
	}
	
	@Column(name="health_lateralilty")
	public String getHealthLaterality() {
		return healthLaterality;
	}
	public void setHealthLaterality(String healthLaterality) {
		this.healthLaterality = healthLaterality;
	}
	
	
	
}
