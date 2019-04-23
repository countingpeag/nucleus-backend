package com.nucleus.dao;

import com.nucleus.models.Group;
import com.nucleus.models.Speciality;
import com.nucleus.models.StatisticsForm;
import com.nucleus.models.Subject;
import com.nucleus.requestModels.DataStatistics;
import com.nucleus.requestModels.FirstPartial;
import com.nucleus.requestModels.SecondPartial;
import com.nucleus.requestModels.ThirdPartial;

public class StatisticsDAO {

	public StatisticsForm getDataStatisticsOptions() {
		SpecialityDAO speciality = new SpecialityDAO();
		SubjectDAO subject = new SubjectDAO();
		StatisticsForm statistics = new StatisticsForm();
		
		statistics.setSpecialities(speciality.readAll());
		statistics.setSubjects(subject.readAll());
		
		return statistics;
	}
	
	public DataStatistics getDataStatistics(int subjectKeyCode, int speciality, String shift) {
		
		ScoreDAO score =new ScoreDAO();
		FirstPartial p1 = new FirstPartial();
		SecondPartial p2 = new SecondPartial();
		ThirdPartial p3 = new ThirdPartial();
		
		int approved = score.getStudentsApproved(subjectKeyCode, speciality, shift, "finalScore").size();
		int notApproved = score.getStudentsNotApproved(subjectKeyCode, speciality, shift, "finalScore").size();
		int man = score.getStudentsNotApprovedM(subjectKeyCode, speciality, shift, "finalScore").size();
		int women = score.getStudentsNotApprovedF(subjectKeyCode, speciality, shift, "finalScore").size();
		
		p1.setApproved(score.getStudentsApproved(subjectKeyCode, speciality, shift, "p1").size());
		p1.setNotApproved(score.getStudentsNotApproved(subjectKeyCode, speciality, shift, "p1").size());
		p1.setMan(score.getStudentsNotApprovedM(subjectKeyCode, speciality, shift, "p1").size());
		p1.setWomen(score.getStudentsNotApprovedF(subjectKeyCode, speciality, shift, "p1").size());

		p2.setApproved(score.getStudentsApproved(subjectKeyCode, speciality, shift, "p2").size());
		p2.setNotApproved(score.getStudentsNotApproved(subjectKeyCode, speciality, shift, "p2").size());
		p2.setMan(score.getStudentsNotApprovedM(subjectKeyCode, speciality, shift, "p2").size());
		p2.setWomen(score.getStudentsNotApprovedF(subjectKeyCode, speciality, shift, "p2").size());
		
		p3.setApproved(score.getStudentsApproved(subjectKeyCode, speciality, shift, "p3").size());
		p3.setNotApproved(score.getStudentsNotApproved(subjectKeyCode, speciality, shift, "p3").size());
		p3.setMan(score.getStudentsNotApprovedM(subjectKeyCode, speciality, shift, "p3").size());
		p3.setWomen(score.getStudentsNotApprovedF(subjectKeyCode, speciality, shift, "p3").size());
		
		return new DataStatistics(approved, notApproved, man, women, p1, p2, p3);
		
	}
	
	public DataStatistics retrieveDataStatisticsForTeacher(Subject subjectKeyCode, Speciality specialty, Group group, String shift) {
		
		ScoreDAO score =new ScoreDAO();
		FirstPartial p1 = new FirstPartial();
		SecondPartial p2 = new SecondPartial();
		ThirdPartial p3 = new ThirdPartial();
		
		int approved = score.retrieveStudentsApproved(subjectKeyCode, specialty, group, shift, "finalScore").size();
		int notApproved = score.retrieveStudentsNotApproved(subjectKeyCode, specialty, group, shift, "finalScore").size();
		int man = score.retrieveStudentsNotApprovedM(subjectKeyCode, specialty, group, shift, "finalScore").size();
		int women = score.retrieveStudentsNotApprovedF(subjectKeyCode, specialty, group, shift, "finalScore").size();
		
		p1.setApproved(score.retrieveStudentsApproved(subjectKeyCode, specialty, group, shift, "p1").size());
		p1.setNotApproved(score.retrieveStudentsNotApproved(subjectKeyCode, specialty, group, shift, "p1").size());
		p1.setMan(score.retrieveStudentsNotApprovedM(subjectKeyCode, specialty, group, shift, "p1").size());
		p1.setWomen(score.retrieveStudentsNotApprovedF(subjectKeyCode, specialty, group, shift, "p1").size());

		p2.setApproved(score.retrieveStudentsApproved(subjectKeyCode, specialty, group, shift, "p2").size());
		p2.setNotApproved(score.retrieveStudentsNotApproved(subjectKeyCode, specialty, group, shift, "p2").size());
		p2.setMan(score.retrieveStudentsNotApprovedM(subjectKeyCode, specialty, group, shift, "p2").size());
		p2.setWomen(score.retrieveStudentsNotApprovedF(subjectKeyCode, specialty, group, shift, "p2").size());
		
		p3.setApproved(score.retrieveStudentsApproved(subjectKeyCode, specialty, group, shift, "p3").size());
		p3.setNotApproved(score.retrieveStudentsNotApproved(subjectKeyCode, specialty, group, shift, "p3").size());
		p3.setMan(score.retrieveStudentsNotApprovedM(subjectKeyCode, specialty, group, shift, "p3").size());
		p3.setWomen(score.retrieveStudentsNotApprovedF(subjectKeyCode, specialty, group, shift, "p3").size());
		
		return new DataStatistics(approved, notApproved, man, women, p1, p2, p3);
	}
	
}
