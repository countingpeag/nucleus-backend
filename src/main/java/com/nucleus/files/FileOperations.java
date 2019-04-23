package com.nucleus.files;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.nucleus.dao.GroupDAO;
import com.nucleus.dao.InstituteDAO;
import com.nucleus.dao.ScoreDAO;
import com.nucleus.dao.SpecialityDAO;
import com.nucleus.dao.StudentDAO;
import com.nucleus.dao.SubjectDAO;
import com.nucleus.models.Group;
import com.nucleus.models.Institute;
import com.nucleus.models.Score;
import com.nucleus.models.Speciality;
import com.nucleus.models.Student;
import com.nucleus.models.Subject;

public class FileOperations {

	public void redFile(String fileLocation) throws IOException, InvalidFormatException {
		
		Workbook workbook = WorkbookFactory.create(new File(fileLocation));
		
		Sheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		
		Hashtable<Long, Long> studentsTuition = new Hashtable<Long, Long>();
		
		Row row = rowIterator.next();
		
		if(row.getCell(0).getStringCellValue().equals("CCT")) {
			//Candidates
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				int successes = (int)(row.getCell(5).getNumericCellValue());
				String candidateName = row.getCell(3).getStringCellValue();
				System.out.println(candidateName+" = "+(successes*100)/70);
			}
		}
		else if(row.getCell(0).getStringCellValue().equals("CLV_CENTRO")) {
			//Students
			while(rowIterator.hasNext()) {
				
				row = rowIterator.next();
				
				String group = row.getCell(6).getStringCellValue();
				Long tuition = (long) row.getCell(7).getNumericCellValue();
				if(!group.equals("") && studentsTuition.get(tuition)==null) {
					readStudents(row, tuition, group);			
					studentsTuition.put(tuition, tuition);
				}
				if(!group.equals(""))
					readScroes(row, group);
				
			}
		}
		
	}
	
	private boolean readScroes(Row row, String group) {
		
		StudentDAO studentDAO = new StudentDAO();
		SubjectDAO subjectDAO = new SubjectDAO();
		ScoreDAO scoreDAO = new ScoreDAO();
		
		long tuition = (long) row.getCell(7).getNumericCellValue();
		String subjectName = row.getCell(12).getStringCellValue();
		double p1 = row.getCell(13).getNumericCellValue();
		double p2 = row.getCell(14).getNumericCellValue();
		double p3 = row.getCell(15).getNumericCellValue();
		double finalScore = row.getCell(16).getNumericCellValue();
		int assist = (int) row.getCell(23).getNumericCellValue();

		Student student = studentDAO.getStudentByTuition(tuition);
		Subject subject = subjectDAO.getSubjectByName(subjectName);
		Score score = scoreDAO.getScoreByStudentSubject(student, subject);

		score.setP1(p1);
		score.setP2(p2);
		score.setP3(p3);
		score.setFinalScore(finalScore);
		score.setAbsences(assist);
		score.setStudentTuition(student);
		score.setSubjectKeycode(subject);
			
		return scoreDAO.create(score);
	}
	
	private boolean readStudents(Row row, long tuition, String group) {

		StudentDAO studentDAO = new StudentDAO();
		GroupDAO groupDAO = new GroupDAO();
		SpecialityDAO specialityDAO = new SpecialityDAO();
		InstituteDAO instituteDAO = new InstituteDAO();
		
		String institute = row.getCell(1).getStringCellValue();
		String speciality = row.getCell(2).getStringCellValue();
		String shift = row.getCell(4).getStringCellValue();
		int level = (int) row.getCell(5).getNumericCellValue();
		String name = row.getCell(8).getStringCellValue();
		String lastNameFather = row.getCell(9).getStringCellValue();
		String lastNameMother = row.getCell(10).getStringCellValue();
		char genre = row.getCell(11).getStringCellValue().charAt(10);
		
		if(!group.equals("") && !speciality.equals("") && !institute.equals("")) {
			
			Group groupObj = groupDAO.getGroupByName(group);
			Speciality specialityObj = specialityDAO.getSpecialityByName(speciality);
			Institute instituteObj = instituteDAO.getInstituteByName(institute);
			
			Student student = new Student();
				student.setStudentTuition(Long.toString(tuition));
				student.setStudentName(name);
				student.setStudentLastNameFather(lastNameFather);
				student.setStudentLastNameMother(lastNameMother);
				student.setStudentPassword(Long.toString(tuition));
				student.setStudentGenre(genre);
				student.setStudentLevel(level);
				student.setStudentShift(shift);
				student.setIdGroup(groupObj);
				student.setIdSpeciality(specialityObj);
				student.setIdInstitute(instituteObj);
				student.setStudentVisibility('0');
				
			return studentDAO.create(student);
		}
		
		return false;
	}
	
	public void insertSchoolInformation() throws IOException, InvalidFormatException  {
		
		Workbook workbook = WorkbookFactory.create(new File("C://Users/Omar/Desktop/test/detalle-de-calificaciones.xlsx"));
		
		Sheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		Hashtable<String, String> specialities = new Hashtable<String, String>();
		Hashtable<String, String> institutes = new Hashtable<String, String>();
		Hashtable<String, String> groups = new Hashtable<String, String>();
		Hashtable<String, String> subjects = new Hashtable<String, String>();
		
		InstituteDAO instituteDAO = new InstituteDAO();
		SpecialityDAO specialityDAO = new SpecialityDAO();
		GroupDAO groupDAO = new GroupDAO();
		SubjectDAO subjectDAO = new SubjectDAO();
		
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			String institute = row.getCell(1).getStringCellValue();
			String speciality = row.getCell(2).getStringCellValue();
			String group = row.getCell(6).getStringCellValue();
			String subject = row.getCell(12).getStringCellValue();
			int subjectLevel = (int) row.getCell(5).getNumericCellValue();
			
			if(institutes.get(institute)==null && institute!="") {
				Institute instituteObj = new Institute();
				instituteObj.setInstituteName(institute);
				instituteDAO.create(instituteObj);
				institutes.put(institute, institute);
			}
			if(specialities.get(speciality)==null && speciality!="") {
				Speciality specialityObj = new Speciality();
				specialityObj.setSpecialityName(speciality);
				specialityDAO.create(specialityObj);
				specialities.put(speciality, speciality);
			}
			if(groups.get(group)==null && group!="") {
				Group groupObj = new Group();
				groupObj.setGroupName(group);
				groupDAO.create(groupObj);
				groups.put(group, group);
			}
			if(subjects.get(subject)==null && subject!="") {
				Subject subjectObj = new Subject();
				subjectObj.setSubjectName(subject);
				subjectObj.setSubjectLevel(subjectLevel);
				subjectDAO.create(subjectObj);
				subjects.put(subject, subject);
			}
		}
		
	}
	
}
