package com.nucleus.requestModels;

import java.util.List;

import com.nucleus.models.Candidate;

public class CandidatesSelection {

	List<Candidate> candidatesNotSelected;
	List<Candidate> morningElectronica;
	List<Candidate> morningClinico;
	List<Candidate> morningQuimico;
	List<Candidate> morningAutomotriz;
	List<Candidate> afternoonElectronica;
	List<Candidate> afternoonClinico;
	List<Candidate> afternoonQuimico;
	List<Candidate> afternoonAutomotriz;
	
	public CandidatesSelection() {}
	
	public CandidatesSelection(List<Candidate> candidatesNotSelected, List<Candidate> morningElectronica,
			List<Candidate> morningClinico, List<Candidate> morningQuimico, List<Candidate> morningAutomotriz,
			List<Candidate> afternoonElectronica, List<Candidate> afternoonClinico, List<Candidate> afternoonQuimico,
			List<Candidate> afternoonAutomotriz) {
		super();
		this.candidatesNotSelected = candidatesNotSelected;
		this.morningElectronica = morningElectronica;
		this.morningClinico = morningClinico;
		this.morningQuimico = morningQuimico;
		this.morningAutomotriz = morningAutomotriz;
		this.afternoonElectronica = afternoonElectronica;
		this.afternoonClinico = afternoonClinico;
		this.afternoonQuimico = afternoonQuimico;
		this.afternoonAutomotriz = afternoonAutomotriz;
	}
	
	public List<Candidate> getCandidatesNotSelected() {
		return candidatesNotSelected;
	}
	public void setCandidatesNotSelected(List<Candidate> candidatesNotSelected) {
		this.candidatesNotSelected = candidatesNotSelected;
	}
	public List<Candidate> getMorningElectronica() {
		return morningElectronica;
	}
	public void setMorningElectronica(List<Candidate> morningElectronica) {
		this.morningElectronica = morningElectronica;
	}
	public List<Candidate> getMorningClinico() {
		return morningClinico;
	}
	public void setMorningClinico(List<Candidate> morningClinico) {
		this.morningClinico = morningClinico;
	}
	public List<Candidate> getMorningQuimico() {
		return morningQuimico;
	}
	public void setMorningQuimico(List<Candidate> morningQuimico) {
		this.morningQuimico = morningQuimico;
	}
	public List<Candidate> getMorningAutomotriz() {
		return morningAutomotriz;
	}
	public void setMorningAutomotriz(List<Candidate> morningAutomotriz) {
		this.morningAutomotriz = morningAutomotriz;
	}
	public List<Candidate> getAfternoonElectronica() {
		return afternoonElectronica;
	}
	public void setAfternoonElectronica(List<Candidate> afternoonElectronica) {
		this.afternoonElectronica = afternoonElectronica;
	}
	public List<Candidate> getAfternoonClinico() {
		return afternoonClinico;
	}
	public void setAfternoonClinico(List<Candidate> afternoonClinico) {
		this.afternoonClinico = afternoonClinico;
	}
	public List<Candidate> getAfternoonQuimico() {
		return afternoonQuimico;
	}
	public void setAfternoonQuimico(List<Candidate> afternoonQuimico) {
		this.afternoonQuimico = afternoonQuimico;
	}
	public List<Candidate> getAfternoonAutomotriz() {
		return afternoonAutomotriz;
	}
	public void setAfternoonAutomotriz(List<Candidate> afternoonAutomotriz) {
		this.afternoonAutomotriz = afternoonAutomotriz;
	}
	
}
