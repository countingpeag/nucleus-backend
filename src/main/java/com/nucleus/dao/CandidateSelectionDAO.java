package com.nucleus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.nucleus.models.Candidate;
import com.nucleus.models.Specialty;
import com.nucleus.requestModels.CandidatesSelection;

public class CandidateSelectionDAO {
	
	public CandidatesSelection getCandidatesSelected() {
		CandidatesSelection candidatesSelected = new CandidatesSelection();
		
		List<Candidate> candidatesNotSelected = new ArrayList<Candidate>();
		List<Candidate> morningElectronica = new ArrayList<Candidate>();
		List<Candidate> morningClinico = new ArrayList<Candidate>();
		List<Candidate> morningQuimico = new ArrayList<Candidate>();
		List<Candidate> morningAutomotriz = new ArrayList<Candidate>();
		List<Candidate> afternoonElectronica = new ArrayList<Candidate>();
		List<Candidate> afternoonClinico = new ArrayList<Candidate>();
		List<Candidate> afternoonQuimico = new ArrayList<Candidate>();
		List<Candidate> afternoonAutomotriz = new ArrayList<Candidate>();
		
		
		CandidatesDAO candidatesDAO = new CandidatesDAO();
		List<Candidate> candidatesSorted = candidatesDAO.getAllSortedCandidates();
		
		if(candidatesSorted.get(0).getCandidateShift()!=null) {
			for(Candidate candidate: candidatesSorted) {
				if(candidate.getCandidateShift().equals("Matutino")) {
					if(candidate.getSpecialty().getSpecialityName().equals("ELECTRÓNICA"))
						morningElectronica.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("LABORATORISTA QUÍMICO"))
						morningQuimico.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("LABORATORISTA CLÍNICO"))
						morningClinico.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("MANTENIMIENTO AUTOMOTRIZ"))
						morningAutomotriz.add(candidate);
					else
						candidatesNotSelected.add(candidate);
				}
				else {
					if(candidate.getSpecialty().getSpecialityName().equals("ELECTRÓNICA"))
						afternoonElectronica.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("LABORATORISTA QUÍMICO"))
						afternoonQuimico.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("LABORATORISTA CLÍNICO"))
						afternoonClinico.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("MANTENIMIENTO AUTOMOTRIZ"))
						afternoonAutomotriz.add(candidate);
					else
						candidatesNotSelected.add(candidate);
				}			
			}
		}
		else {
			for(Candidate candidate: candidatesSorted) {
				if(candidate.getPreference().getPreferencesShiftWished().equals("Matutino")) {
					if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("ELECTRÓNICA") && (morningElectronica.size()<5 || afternoonElectronica.size()<5) ) {
						if(morningElectronica.size()<5)
							morningElectronica.add(candidate);
						else if(afternoonElectronica.size()<5)
							afternoonElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA QUÍMICO") && (morningQuimico.size()<5 || afternoonQuimico.size()<5) ) {
						if(morningQuimico.size()<5)
							morningQuimico.add(candidate);
						else if(afternoonQuimico.size()<5)
							afternoonQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA CLÍNICO") && (morningClinico.size()<5 || afternoonClinico.size()<5) ) {
						if(morningClinico.size()<5)
							morningClinico.add(candidate);
						else if(afternoonClinico.size()<5)
							afternoonClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("MANTENIMIENTO AUTOMOTRIZ") && (morningAutomotriz.size()<5 || afternoonAutomotriz.size()<5) ) {
						if(morningAutomotriz.size()<5)
							morningAutomotriz.add(candidate);
						else if(afternoonAutomotriz.size()<5)
							afternoonAutomotriz.add(candidate);
					}
					
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("ELECTRÓNICA") && (morningElectronica.size()<5 || afternoonElectronica.size()<5) ) {
						if(morningElectronica.size()<5)
							morningElectronica.add(candidate);
						else if(afternoonElectronica.size()<5)
							afternoonElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("LABORATORISTA QUÍMICO") && (morningQuimico.size()<5 || afternoonQuimico.size()<5) ) {
						if(morningQuimico.size()<5)
							morningQuimico.add(candidate);
						else if(afternoonQuimico.size()<5)
							afternoonQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("LABORATORISTA CLÍNICO") && (morningClinico.size()<5 || afternoonClinico.size()<5) ) {
						if(morningClinico.size()<5)
							morningClinico.add(candidate);
						else if(afternoonClinico.size()<5)
							afternoonClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("MANTENIMIENTO AUTOMOTRIZ") && (morningAutomotriz.size()<5 || afternoonAutomotriz.size()<5) ) {
						if(morningAutomotriz.size()<5)
							morningAutomotriz.add(candidate);
						else if(afternoonAutomotriz.size()<5)
							afternoonAutomotriz.add(candidate);
					}
					
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("ELECTRÓNICA") && (morningElectronica.size()<5 || afternoonElectronica.size()<5) ) {
						if(morningElectronica.size()<5)
							morningElectronica.add(candidate);
						else if(afternoonElectronica.size()<5)
							afternoonElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("LABORATORISTA QUÍMICO") && (morningQuimico.size()<5 || afternoonQuimico.size()<5) ) {
						if(morningQuimico.size()<5)
							morningQuimico.add(candidate);
						else if(afternoonQuimico.size()<5)
							afternoonQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("LABORATORISTA CLÍNICO") && (morningClinico.size()<5 || afternoonClinico.size()<5) ) {
						if(morningClinico.size()<5)
							morningClinico.add(candidate);
						else if(afternoonClinico.size()<5)
							afternoonClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("MANTENIMIENTO AUTOMOTRIZ") && (morningAutomotriz.size()<5 || afternoonAutomotriz.size()<5) ) {
						if(morningAutomotriz.size()<5)
							morningAutomotriz.add(candidate);
						else if(afternoonAutomotriz.size()<5)
							afternoonAutomotriz.add(candidate);
					}
					
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("ELECTRÓNICA") && (morningElectronica.size()<5 || afternoonElectronica.size()<5) ) {
						if(morningElectronica.size()<5)
							morningElectronica.add(candidate);
						else if(afternoonElectronica.size()<5)
							afternoonElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("LABORATORISTA QUÍMICO") && (morningQuimico.size()<5 || afternoonQuimico.size()<5) ) {
						if(morningQuimico.size()<5)
							morningQuimico.add(candidate);
						else if(afternoonQuimico.size()<5)
							afternoonQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("LABORATORISTA CLÍNICO") && (morningClinico.size()<5 || afternoonClinico.size()<5) ) {
						if(morningClinico.size()<5)
							morningClinico.add(candidate);
						else if(afternoonClinico.size()<5)
							afternoonClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("MANTENIMIENTO AUTOMOTRIZ") && (morningAutomotriz.size()<5 || afternoonAutomotriz.size()<5) ) {
						if(morningAutomotriz.size()<5)
							morningAutomotriz.add(candidate);
						else if(afternoonAutomotriz.size()<5)
							afternoonAutomotriz.add(candidate);
					}
					else
						candidatesNotSelected.add(candidate);
					
				}
				else {
					if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("ELECTRÓNICA") && (afternoonElectronica.size()<5 || morningElectronica.size()<5) ) {
						if(afternoonElectronica.size()<5)
							afternoonElectronica.add(candidate);
						else if(morningElectronica.size()<5)
							morningElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA QUÍMICO") && (afternoonQuimico.size()<5 || morningQuimico.size()<5) ) {
						if(afternoonQuimico.size()<5)
							afternoonQuimico.add(candidate);
						else if(morningQuimico.size()<5)
							morningQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA CLÍNICO") && (afternoonClinico.size()<5 || morningClinico.size()<5) ) {
						if(afternoonClinico.size()<5)
							afternoonClinico.add(candidate);
						else if(morningClinico.size()<5)
							morningClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("MANTENIMIENTO AUTOMOTRIZ") && (afternoonAutomotriz.size()<5 || morningAutomotriz.size()<5) ) {
						if(afternoonAutomotriz.size()<5)
							afternoonAutomotriz.add(candidate);
						else if(morningAutomotriz.size()<5)
							morningAutomotriz.add(candidate);
					}
					
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("ELECTRÓNICA") && (afternoonElectronica.size()<5 || morningElectronica.size()<5) ) {
						if(afternoonElectronica.size()<5)
							afternoonElectronica.add(candidate);
						else if(morningElectronica.size()<5)
							morningElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("LABORATORISTA QUÍMICO") && (afternoonQuimico.size()<5 || morningQuimico.size()<5) ) {
						if(afternoonQuimico.size()<5)
							afternoonQuimico.add(candidate);
						else if(morningQuimico.size()<5)
							morningQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("LABORATORISTA CLÍNICO") && (afternoonClinico.size()<5 || morningClinico.size()<5) ) {
						if(afternoonClinico.size()<5)
							afternoonClinico.add(candidate);
						else if(morningClinico.size()<5)
							morningClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("MANTENIMIENTO AUTOMOTRIZ") && (afternoonAutomotriz.size()<5 || morningAutomotriz.size()<5) ) {
						if(afternoonAutomotriz.size()<5)
							afternoonAutomotriz.add(candidate);
						else if(morningAutomotriz.size()<5)
							morningAutomotriz.add(candidate);
					}
					
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("ELECTRÓNICA") && (afternoonElectronica.size()<5 || morningElectronica.size()<5) ) {
						if(afternoonElectronica.size()<5)
							afternoonElectronica.add(candidate);
						else if(morningElectronica.size()<5)
							morningElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("LABORATORISTA QUÍMICO") && (afternoonQuimico.size()<5 || morningQuimico.size()<5) ) {
						if(afternoonQuimico.size()<5)
							afternoonQuimico.add(candidate);
						else if(morningQuimico.size()<5)
							morningQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("LABORATORISTA CLÍNICO") && (afternoonClinico.size()<5 || morningClinico.size()<5) ) {
						if(afternoonClinico.size()<5)
							afternoonClinico.add(candidate);
						else if(morningClinico.size()<5)
							morningClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("MANTENIMIENTO AUTOMOTRIZ") && (afternoonAutomotriz.size()<5 || morningAutomotriz.size()<5) ) {
						if(afternoonAutomotriz.size()<5)
							afternoonAutomotriz.add(candidate);
						else if(morningAutomotriz.size()<5)
							morningAutomotriz.add(candidate);
					}
					
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("ELECTRÓNICA") && (afternoonElectronica.size()<5 || morningElectronica.size()<5) ) {
						if(afternoonElectronica.size()<5)
							afternoonElectronica.add(candidate);
						else if(morningElectronica.size()<5)
							morningElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("LABORATORISTA QUÍMICO") && (afternoonQuimico.size()<5 || morningQuimico.size()<5) ) {
						if(afternoonQuimico.size()<5)
							afternoonQuimico.add(candidate);
						else if(morningQuimico.size()<5)
							morningQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("LABORATORISTA CLÍNICO") && (afternoonClinico.size()<5 || morningClinico.size()<5) ) {
						if(afternoonClinico.size()<5)
							afternoonClinico.add(candidate);
						else if(morningClinico.size()<5)
							morningClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("MANTENIMIENTO AUTOMOTRIZ") && (afternoonAutomotriz.size()<5 || morningAutomotriz.size()<5) ) {
						if(afternoonAutomotriz.size()<5)
							afternoonAutomotriz.add(candidate);
						else if(morningAutomotriz.size()<5)
							morningAutomotriz.add(candidate);
					}
					else
						candidatesNotSelected.add(candidate);
				}
			}
		}
		
		candidatesSelected.setCandidatesNotSelected(candidatesNotSelected);
		
		candidatesSelected.setMorningAutomotriz(morningAutomotriz);
		candidatesSelected.setMorningClinico(morningClinico);
		candidatesSelected.setMorningElectronica(morningElectronica);
		candidatesSelected.setMorningQuimico(morningQuimico);
		
		candidatesSelected.setAfternoonAutomotriz(afternoonAutomotriz);
		candidatesSelected.setAfternoonClinico(afternoonClinico);
		candidatesSelected.setAfternoonElectronica(afternoonElectronica);
		candidatesSelected.setAfternoonQuimico(afternoonQuimico);
		
		return candidatesSelected;
	}
	
	public Response updateCandidateSelection(CandidatesSelection candidates) {
		
		CandidatesDAO candidatesDAO = new CandidatesDAO();
		
		
		for(Candidate candidate: candidates.getMorningAutomotriz()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(5);
			specialty.setSpecialityName("MANTENIMIENTO AUTOMOTRIZ");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Matutino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getMorningClinico()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(6);
			specialty.setSpecialityName("LABORATORISTA CLÍNICO");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Matutino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getMorningElectronica()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(2);
			specialty.setSpecialityName("ELECTRÓNICA");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Matutino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getMorningQuimico()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(4);
			specialty.setSpecialityName("LABORATORISTA QUÍMICO");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Matutino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		
		for(Candidate candidate: candidates.getAfternoonAutomotriz()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(5);
			specialty.setSpecialityName("MANTENIMIENTO AUTOMOTRIZ");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Vespertino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getAfternoonClinico()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(6);
			specialty.setSpecialityName("LABORATORISTA CLÍNICO");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Vespertino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getAfternoonElectronica()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(2);
			specialty.setSpecialityName("ELECTRÓNICA");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Vespertino");
			
			candidatesDAO.saveCandidates(candidate);
		}

		for(Candidate candidate: candidates.getAfternoonQuimico()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(4);
			specialty.setSpecialityName("LABORATORISTA QUÍMICO");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Vespertino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getCandidatesNotSelected()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(1);
			specialty.setSpecialityName("None");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift(candidate.getPreference().getPreferencesShiftWished());
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		return Response.ok(true).build();
	}
}