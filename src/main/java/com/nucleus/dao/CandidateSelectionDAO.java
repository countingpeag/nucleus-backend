package com.nucleus.dao;

import java.util.ArrayList;
import java.util.List;

import com.nucleus.models.Candidate;
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
		
		for(Candidate candidate: candidatesSorted) {
			if(candidate.getPreference().getPreferencesShiftWished().equals("Matutino")) {
				if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("ELECTRÓNICA") && morningElectronica.size()<5)
					morningElectronica.add(candidate);
				else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA QUÍMICO") && morningQuimico.size()<5)
					morningQuimico.add(candidate);
				else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA CLÍNICO") && morningClinico.size()<5)
					morningClinico.add(candidate);
				else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("MANTENIMIENTO AUTOMOTRIZ") && morningAutomotriz.size()<5)
					morningAutomotriz.add(candidate);
				else
					candidatesNotSelected.add(candidate);
			}
			else {
				if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("ELECTRÓNICA") && afternoonElectronica.size()<5)
					afternoonElectronica.add(candidate);
				else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA QUÍMICO") && afternoonQuimico.size()<5)
					afternoonQuimico.add(candidate);
				else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("LABORATORISTA CLÍNICO") && afternoonClinico.size()<5)
					afternoonClinico.add(candidate);
				else if(candidate.getPreference().getPreferencesSpecialtyWhished1().equals("MANTENIMIENTO AUTOMOTRIZ") && afternoonAutomotriz.size()<5)
					afternoonAutomotriz.add(candidate);
				else
					candidatesNotSelected.add(candidate);
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
}
