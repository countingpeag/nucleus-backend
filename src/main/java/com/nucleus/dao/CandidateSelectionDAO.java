package com.nucleus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.nucleus.models.Candidate;
import com.nucleus.models.Specialty;
import com.nucleus.requestModels.CandidatesSelection;

public class CandidateSelectionDAO {
	
	private final int LIMIT = 5;
	
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
					if(candidate.getSpecialty().getSpecialityName().equals("ELECTR�NICA"))
						morningElectronica.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("LABORATORISTA QU�MICO"))
						morningQuimico.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("LABORATORISTA CL�NICO"))
						morningClinico.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("MANTENIMIENTO AUTOMOTRIZ"))
						morningAutomotriz.add(candidate);
					else
						candidatesNotSelected.add(candidate);
				}
				else {
					if(candidate.getSpecialty().getSpecialityName().equals("ELECTR�NICA"))
						afternoonElectronica.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("LABORATORISTA QU�MICO"))
						afternoonQuimico.add(candidate);
					else if(candidate.getSpecialty().getSpecialityName().equals("LABORATORISTA CL�NICO"))
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
					if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("ELECTR�NICA") && (morningElectronica.size()<LIMIT || afternoonElectronica.size()<LIMIT) ) {
						if(morningElectronica.size()<LIMIT)
							morningElectronica.add(candidate);
						else if(afternoonElectronica.size()<LIMIT)
							afternoonElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA QU�MICO") && (morningQuimico.size()<LIMIT || afternoonQuimico.size()<LIMIT) ) {
						if(morningQuimico.size()<LIMIT)
							morningQuimico.add(candidate);
						else if(afternoonQuimico.size()<LIMIT)
							afternoonQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA CL�NICO") && (morningClinico.size()<LIMIT || afternoonClinico.size()<LIMIT) ) {
						if(morningClinico.size()<LIMIT)
							morningClinico.add(candidate);
						else if(afternoonClinico.size()<LIMIT)
							afternoonClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("MANTENIMIENTO AUTOMOTRIZ") && (morningAutomotriz.size()<LIMIT || afternoonAutomotriz.size()<LIMIT) ) {
						if(morningAutomotriz.size()<LIMIT)
							morningAutomotriz.add(candidate);
						else if(afternoonAutomotriz.size()<LIMIT)
							afternoonAutomotriz.add(candidate);
					}

					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("ELECTR�NICA") && (morningElectronica.size()<LIMIT || afternoonElectronica.size()<LIMIT) ) {
						if(morningElectronica.size()<LIMIT)
							morningElectronica.add(candidate);
						else if(afternoonElectronica.size()<LIMIT)
							afternoonElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("LABORATORISTA QU�MICO") && (morningQuimico.size()<LIMIT || afternoonQuimico.size()<LIMIT) ) {
						if(morningQuimico.size()<LIMIT)
							morningQuimico.add(candidate);
						else if(afternoonQuimico.size()<LIMIT)
							afternoonQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("LABORATORISTA CL�NICO") && (morningClinico.size()<LIMIT || afternoonClinico.size()<LIMIT) ) {
						if(morningClinico.size()<LIMIT)
							morningClinico.add(candidate);
						else if(afternoonClinico.size()<LIMIT)
							afternoonClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("MANTENIMIENTO AUTOMOTRIZ") && (morningAutomotriz.size()<LIMIT || afternoonAutomotriz.size()<LIMIT) ) {
						if(morningAutomotriz.size()<LIMIT)
							morningAutomotriz.add(candidate);
						else if(afternoonAutomotriz.size()<LIMIT)
							afternoonAutomotriz.add(candidate);
					}

					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("ELECTR�NICA") && (morningElectronica.size()<LIMIT || afternoonElectronica.size()<LIMIT) ) {
						if(morningElectronica.size()<LIMIT)
							morningElectronica.add(candidate);
						else if(afternoonElectronica.size()<LIMIT)
							afternoonElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("LABORATORISTA QU�MICO") && (morningQuimico.size()<LIMIT || afternoonQuimico.size()<LIMIT) ) {
						if(morningQuimico.size()<LIMIT)
							morningQuimico.add(candidate);
						else if(afternoonQuimico.size()<LIMIT)
							afternoonQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("LABORATORISTA CL�NICO") && (morningClinico.size()<LIMIT || afternoonClinico.size()<LIMIT) ) {
						if(morningClinico.size()<LIMIT)
							morningClinico.add(candidate);
						else if(afternoonClinico.size()<LIMIT)
							afternoonClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("MANTENIMIENTO AUTOMOTRIZ") && (morningAutomotriz.size()<LIMIT || afternoonAutomotriz.size()<LIMIT) ) {
						if(morningAutomotriz.size()<LIMIT)
							morningAutomotriz.add(candidate);
						else if(afternoonAutomotriz.size()<LIMIT)
							afternoonAutomotriz.add(candidate);
					}

					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("ELECTR�NICA") && (morningElectronica.size()<LIMIT || afternoonElectronica.size()<LIMIT) ) {
						if(morningElectronica.size()<LIMIT)
							morningElectronica.add(candidate);
						else if(afternoonElectronica.size()<LIMIT)
							afternoonElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("LABORATORISTA QU�MICO") && (morningQuimico.size()<LIMIT || afternoonQuimico.size()<LIMIT) ) {
						if(morningQuimico.size()<LIMIT)
							morningQuimico.add(candidate);
						else if(afternoonQuimico.size()<LIMIT)
							afternoonQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("LABORATORISTA CL�NICO") && (morningClinico.size()<LIMIT || afternoonClinico.size()<LIMIT) ) {
						if(morningClinico.size()<LIMIT)
							morningClinico.add(candidate);
						else if(afternoonClinico.size()<LIMIT)
							afternoonClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("MANTENIMIENTO AUTOMOTRIZ") && (morningAutomotriz.size()<LIMIT || afternoonAutomotriz.size()<LIMIT) ) {
						if(morningAutomotriz.size()<LIMIT)
							morningAutomotriz.add(candidate);
						else if(afternoonAutomotriz.size()<LIMIT)
							afternoonAutomotriz.add(candidate);
					}
					else
						candidatesNotSelected.add(candidate);
					
				}
				else {
					if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("ELECTR�NICA") && (afternoonElectronica.size()<LIMIT || morningElectronica.size()<LIMIT) ) {
						if(afternoonElectronica.size()<LIMIT)
							afternoonElectronica.add(candidate);
						else if(morningElectronica.size()<LIMIT)
							morningElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA QU�MICO") && (afternoonQuimico.size()<LIMIT || morningQuimico.size()<LIMIT) ) {
						if(afternoonQuimico.size()<LIMIT)
							afternoonQuimico.add(candidate);
						else if(morningQuimico.size()<LIMIT)
							morningQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA CL�NICO") && (afternoonClinico.size()<LIMIT || morningClinico.size()<LIMIT) ) {
						if(afternoonClinico.size()<LIMIT)
							afternoonClinico.add(candidate);
						else if(morningClinico.size()<LIMIT)
							morningClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("MANTENIMIENTO AUTOMOTRIZ") && (afternoonAutomotriz.size()<LIMIT || morningAutomotriz.size()<LIMIT) ) {
						if(afternoonAutomotriz.size()<LIMIT)
							afternoonAutomotriz.add(candidate);
						else if(morningAutomotriz.size()<LIMIT)
							morningAutomotriz.add(candidate);
					}
					


					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("ELECTR�NICA") && (afternoonElectronica.size()<LIMIT || morningElectronica.size()<LIMIT) ) {
						if(afternoonElectronica.size()<LIMIT)
							afternoonElectronica.add(candidate);
						else if(morningElectronica.size()<LIMIT)
							morningElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("LABORATORISTA QU�MICO") && (afternoonQuimico.size()<LIMIT || morningQuimico.size()<LIMIT) ) {
						if(afternoonQuimico.size()<LIMIT)
							afternoonQuimico.add(candidate);
						else if(morningQuimico.size()<LIMIT)
							morningQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("LABORATORISTA CL�NICO") && (afternoonClinico.size()<LIMIT || morningClinico.size()<LIMIT) ) {
						if(afternoonClinico.size()<LIMIT)
							afternoonClinico.add(candidate);
						else if(morningClinico.size()<LIMIT)
							morningClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished2().equals("MANTENIMIENTO AUTOMOTRIZ") && (afternoonAutomotriz.size()<LIMIT || morningAutomotriz.size()<LIMIT) ) {
						if(afternoonAutomotriz.size()<LIMIT)
							afternoonAutomotriz.add(candidate);
						else if(morningAutomotriz.size()<LIMIT)
							morningAutomotriz.add(candidate);
					}

					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("ELECTR�NICA") && (afternoonElectronica.size()<LIMIT || morningElectronica.size()<LIMIT) ) {
						if(afternoonElectronica.size()<LIMIT)
							afternoonElectronica.add(candidate);
						else if(morningElectronica.size()<LIMIT)
							morningElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("LABORATORISTA QU�MICO") && (afternoonQuimico.size()<LIMIT || morningQuimico.size()<LIMIT) ) {
						if(afternoonQuimico.size()<LIMIT)
							afternoonQuimico.add(candidate);
						else if(morningQuimico.size()<LIMIT)
							morningQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("LABORATORISTA CL�NICO") && (afternoonClinico.size()<LIMIT || morningClinico.size()<LIMIT) ) {
						if(afternoonClinico.size()<LIMIT)
							afternoonClinico.add(candidate);
						else if(morningClinico.size()<LIMIT)
							morningClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished3().equals("MANTENIMIENTO AUTOMOTRIZ") && (afternoonAutomotriz.size()<LIMIT || morningAutomotriz.size()<LIMIT) ) {
						if(afternoonAutomotriz.size()<LIMIT)
							afternoonAutomotriz.add(candidate);
						else if(morningAutomotriz.size()<LIMIT)
							morningAutomotriz.add(candidate);
					}

					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("ELECTR�NICA") && (afternoonElectronica.size()<LIMIT || morningElectronica.size()<LIMIT) ) {
						if(afternoonElectronica.size()<LIMIT)
							afternoonElectronica.add(candidate);
						else if(morningElectronica.size()<LIMIT)
							morningElectronica.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("LABORATORISTA QU�MICO") && (afternoonQuimico.size()<LIMIT || morningQuimico.size()<LIMIT) ) {
						if(afternoonQuimico.size()<LIMIT)
							afternoonQuimico.add(candidate);
						else if(morningQuimico.size()<LIMIT)
							morningQuimico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("LABORATORISTA CL�NICO") && (afternoonClinico.size()<LIMIT || morningClinico.size()<LIMIT) ) {
						if(afternoonClinico.size()<LIMIT)
							afternoonClinico.add(candidate);
						else if(morningClinico.size()<LIMIT)
							morningClinico.add(candidate);
					}
					else if(candidate.getPreference().getPreferencesSpecialtyWhished4().equals("MANTENIMIENTO AUTOMOTRIZ") && (afternoonAutomotriz.size()<LIMIT || morningAutomotriz.size()<LIMIT) ) {
						if(afternoonAutomotriz.size()<LIMIT)
							afternoonAutomotriz.add(candidate);
						else if(morningAutomotriz.size()<LIMIT)
							morningAutomotriz.add(candidate);
					}
					
					else
						candidatesNotSelected.add(candidate);
				}
			}
		}
		
		candidatesSelected.setCandidatesNotSelected(candidatesNotSelected);
		
		candidatesSelected.setMorningAutomotriz(setGroupToCandidate(morningAutomotriz));
		candidatesSelected.setMorningClinico(setGroupToCandidate(morningClinico));
		candidatesSelected.setMorningElectronica(setGroupToCandidate(morningElectronica));
		candidatesSelected.setMorningQuimico(setGroupToCandidate(morningQuimico));
		
		candidatesSelected.setAfternoonAutomotriz(setGroupToCandidate(afternoonAutomotriz));
		candidatesSelected.setAfternoonClinico(setGroupToCandidate(afternoonClinico));
		candidatesSelected.setAfternoonElectronica(setGroupToCandidate(afternoonElectronica));
		candidatesSelected.setAfternoonQuimico(setGroupToCandidate(afternoonQuimico));
		
		return candidatesSelected;
	}
	
	public Response updateCandidateSelection(CandidatesSelection candidates) {
		
		CandidatesDAO candidatesDAO = new CandidatesDAO();
		
		
		for(Candidate candidate: candidates.getMorningAutomotriz()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(LIMIT);
			specialty.setSpecialityName("MANTENIMIENTO AUTOMOTRIZ");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Matutino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getMorningClinico()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(6);
			specialty.setSpecialityName("LABORATORISTA CL�NICO");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Matutino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getMorningElectronica()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(2);
			specialty.setSpecialityName("ELECTR�NICA");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Matutino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getMorningQuimico()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(4);
			specialty.setSpecialityName("LABORATORISTA QU�MICO");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Matutino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		
		for(Candidate candidate: candidates.getAfternoonAutomotriz()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(LIMIT);
			specialty.setSpecialityName("MANTENIMIENTO AUTOMOTRIZ");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Vespertino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getAfternoonClinico()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(6);
			specialty.setSpecialityName("LABORATORISTA CL�NICO");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Vespertino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getAfternoonElectronica()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(2);
			specialty.setSpecialityName("ELECTR�NICA");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Vespertino");
			
			candidatesDAO.saveCandidates(candidate);
		}

		for(Candidate candidate: candidates.getAfternoonQuimico()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(4);
			specialty.setSpecialityName("LABORATORISTA QU�MICO");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateShift("Vespertino");
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		for(Candidate candidate: candidates.getCandidatesNotSelected()) {
			Specialty specialty = new Specialty();
			specialty.setSpecialityKeycode(1);
			specialty.setSpecialityName("None");
			
			candidate.setSpecialty(specialty);
			candidate.setCandidateGroup(null);
			candidate.setCandidateShift(candidate.getPreference().getPreferencesShiftWished());
			
			candidatesDAO.saveCandidates(candidate);
		}
		
		return Response.ok(true).build();
	}
	
	
	private List<Candidate> setGroupToCandidate(List<Candidate> list){
		
		int group1=0;
		int group2=0;
		int group3=0;
		
		for(int i=1 ; i<=list.size() ; i++) {
			if((i%2)==1 && group1<=LIMIT) {
				list.get(i-1).setCandidateGroup("A");
				group1++;
			}
			else if((i%2)==0 && group2<=LIMIT) {
				list.get(i-1).setCandidateGroup("B");
				group2++;
			}
			else {
				if(group3<=LIMIT) {
					list.get(i-1).setCandidateGroup("C");
					group3++;
				}
			}
		}
		
		
		return list;
	}
}