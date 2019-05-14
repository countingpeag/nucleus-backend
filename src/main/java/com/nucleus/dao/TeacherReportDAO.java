package com.nucleus.dao;

import com.nucleus.requestModels.TeacherDataReport;
import com.nucleus.requestModels.TeacherReport;

public class TeacherReportDAO {

	public TeacherDataReport getTeacherReportData(TeacherReport data) {
		
		ScoreDAO scoreDAO = new ScoreDAO();
		
		TeacherDataReport dataReport = new TeacherDataReport();
		Long registeredStudens = scoreDAO.getRegisteredStudents(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift());
		dataReport.setRegisteredStudents(registeredStudens);
		
		if(data.getDataType().equals("quantity")) {
			dataReport.setApprovedStudentsP1(scoreDAO.retrieveStudentsApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1"));
			dataReport.setFailedStudentsP1(scoreDAO.retrieveStudentsNotApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1"));
			dataReport.setStudentsScore050P1(scoreDAO.getStudent0To50(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1"));
			dataReport.setStudentsScore5160P1(scoreDAO.getStudent51To60(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1"));
			dataReport.setStudentsScore6170P1(scoreDAO.getStudent61To70(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1"));
			dataReport.setStudentsScore7180P1(scoreDAO.getStudent71To80(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1"));
			dataReport.setStudentsScore8190P1(scoreDAO.getStudent81To90(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1"));
			dataReport.setStudentsScore91100P1(scoreDAO.getStudent91To100(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1"));
			
			dataReport.setApprovedStudentsP2(scoreDAO.retrieveStudentsApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2"));
			dataReport.setFailedStudentsP2(scoreDAO.retrieveStudentsNotApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2"));
			dataReport.setStudentsScore050P2(scoreDAO.getStudent0To50(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2"));
			dataReport.setStudentsScore5160P2(scoreDAO.getStudent51To60(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2"));
			dataReport.setStudentsScore6170P2(scoreDAO.getStudent61To70(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2"));
			dataReport.setStudentsScore7180P2(scoreDAO.getStudent71To80(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2"));
			dataReport.setStudentsScore8190P2(scoreDAO.getStudent81To90(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2"));
			dataReport.setStudentsScore91100P2(scoreDAO.getStudent91To100(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2"));
			
			dataReport.setApprovedStudentsP3(scoreDAO.retrieveStudentsApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3"));
			dataReport.setFailedStudentsP3(scoreDAO.retrieveStudentsNotApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3"));
			dataReport.setStudentsScore050P3(scoreDAO.getStudent0To50(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3"));
			dataReport.setStudentsScore5160P3(scoreDAO.getStudent51To60(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3"));
			dataReport.setStudentsScore6170P3(scoreDAO.getStudent61To70(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3"));
			dataReport.setStudentsScore7180P3(scoreDAO.getStudent71To80(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3"));
			dataReport.setStudentsScore8190P3(scoreDAO.getStudent81To90(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3"));
			dataReport.setStudentsScore91100P3(scoreDAO.getStudent91To100(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3"));
			
			dataReport.setApprovedStudentsFL(scoreDAO.retrieveStudentsApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore"));
			dataReport.setFailedStudentsFL(scoreDAO.retrieveStudentsNotApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore"));
			dataReport.setStudentsScore050FL(scoreDAO.getStudent0To50(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore"));
			dataReport.setStudentsScore5160FL(scoreDAO.getStudent51To60(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore"));
			dataReport.setStudentsScore6170FL(scoreDAO.getStudent61To70(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore"));
			dataReport.setStudentsScore7180FL(scoreDAO.getStudent71To80(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore"));
			dataReport.setStudentsScore8190FL(scoreDAO.getStudent81To90(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore"));
			dataReport.setStudentsScore91100FL(scoreDAO.getStudent91To100(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore"));
		}
		else {
			dataReport.setApprovedStudentsP1((scoreDAO.retrieveStudentsApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1")*100)/registeredStudens);
			dataReport.setFailedStudentsP1((scoreDAO.retrieveStudentsNotApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1")*100)/registeredStudens);
			dataReport.setStudentsScore050P1((scoreDAO.getStudent0To50(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1")*100)/registeredStudens);
			dataReport.setStudentsScore5160P1((scoreDAO.getStudent51To60(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1")*100)/registeredStudens);
			dataReport.setStudentsScore6170P1((scoreDAO.getStudent61To70(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1")*100)/registeredStudens);
			dataReport.setStudentsScore7180P1((scoreDAO.getStudent71To80(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1")*100)/registeredStudens);
			dataReport.setStudentsScore8190P1((scoreDAO.getStudent81To90(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1")*100)/registeredStudens);
			dataReport.setStudentsScore91100P1((scoreDAO.getStudent91To100(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p1")*100)/registeredStudens);
			
			dataReport.setApprovedStudentsP2((scoreDAO.retrieveStudentsApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2")*100)/registeredStudens);
			dataReport.setFailedStudentsP2((scoreDAO.retrieveStudentsNotApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2")*100)/registeredStudens);
			dataReport.setStudentsScore050P2((scoreDAO.getStudent0To50(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2")*100)/registeredStudens);
			dataReport.setStudentsScore5160P2((scoreDAO.getStudent51To60(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2")*100)/registeredStudens);
			dataReport.setStudentsScore6170P2((scoreDAO.getStudent61To70(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2")*100)/registeredStudens);
			dataReport.setStudentsScore7180P2((scoreDAO.getStudent71To80(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2")*100)/registeredStudens);
			dataReport.setStudentsScore8190P2((scoreDAO.getStudent81To90(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2")*100)/registeredStudens);
			dataReport.setStudentsScore91100P2((scoreDAO.getStudent91To100(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p2")*100)/registeredStudens);
			
			dataReport.setApprovedStudentsP3((scoreDAO.retrieveStudentsApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3")*100)/registeredStudens);
			dataReport.setFailedStudentsP3((scoreDAO.retrieveStudentsNotApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3")*100)/registeredStudens);
			dataReport.setStudentsScore050P3((scoreDAO.getStudent0To50(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3")*100)/registeredStudens);
			dataReport.setStudentsScore5160P3((scoreDAO.getStudent51To60(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3")*100)/registeredStudens);
			dataReport.setStudentsScore6170P3((scoreDAO.getStudent61To70(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3")*100)/registeredStudens);
			dataReport.setStudentsScore7180P3((scoreDAO.getStudent71To80(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3")*100)/registeredStudens);
			dataReport.setStudentsScore8190P3((scoreDAO.getStudent81To90(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3")*100)/registeredStudens);
			dataReport.setStudentsScore91100P3((scoreDAO.getStudent91To100(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "p3")*100)/registeredStudens);
			
			dataReport.setApprovedStudentsFL((scoreDAO.retrieveStudentsApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore")*100)/registeredStudens);
			dataReport.setFailedStudentsFL((scoreDAO.retrieveStudentsNotApproved(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore")*100)/registeredStudens);
			dataReport.setStudentsScore050FL((scoreDAO.getStudent0To50(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore")*100)/registeredStudens);
			dataReport.setStudentsScore5160FL((scoreDAO.getStudent51To60(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore")*100)/registeredStudens);
			dataReport.setStudentsScore6170FL((scoreDAO.getStudent61To70(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore")*100)/registeredStudens);
			dataReport.setStudentsScore7180FL((scoreDAO.getStudent71To80(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore")*100)/registeredStudens);
			dataReport.setStudentsScore8190FL((scoreDAO.getStudent81To90(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore")*100)/registeredStudens);
			dataReport.setStudentsScore91100FL((scoreDAO.getStudent91To100(data.getSubject(), data.getSpecialty(), data.getGroup(), data.getShift(), "finalScore")*100)/registeredStudens);
		}
		
		return dataReport;
	}
}
