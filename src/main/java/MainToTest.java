import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nucleus.dao.AdministratorDAO;
import com.nucleus.dao.ScoreDAO;
import com.nucleus.dao.SpecialityDAO;
import com.nucleus.dao.StatisticsDAO;
import com.nucleus.dao.StudentDAO;
import com.nucleus.dao.SubjectDAO;
import com.nucleus.dao.TeacherDAO;
import com.nucleus.files.FileOperations;
import com.nucleus.hibernate.HibernateUtil;
import com.nucleus.models.Administrator;
import com.nucleus.models.Group;
import com.nucleus.models.Institute;
import com.nucleus.models.Schedule;
import com.nucleus.models.Score;
import com.nucleus.models.Specialty;
import com.nucleus.models.StatisticsForm;
import com.nucleus.models.Student;
import com.nucleus.models.Subject;
import com.nucleus.models.Teacher;
import com.nucleus.requestModels.AdminRequestModel;
import com.nucleus.requestModels.DataStatistics;

import java.util.Date;

public class MainToTest {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction transaction = session.beginTransaction();

		/*FileOperations operations = new FileOperations();
		operations.insertSchoolInformation();*/
		
		/*Institute inst = new Institute();
		inst.setIdInstitute(1);
		inst.setInstituteName("CBTIS NO. 38");
		
		Administrator administrator = new Administrator();
		administrator.setAdminName("Omar");
		administrator.setAdminLastNameFather("Palma");
		administrator.setAdminLastNameMother("Nuñez");
		administrator.setAdminPassword("admin");
		administrator.setAdminRFC("PANEXXXXXXXX");
		administrator.setAdminUsername("admin");
		administrator.setIdInstitute(inst);
		
		AdministratorDAO administratorDAO = new AdministratorDAO();
		administratorDAO.create(administrator);*/
		
		/*Institute inst = new Institute();
		inst.setIdInstitute(1);
		inst.setInstituteName("CBTIS NO. 38");
		
		Subject subject1 = new Subject();
		subject1.setSubjectKeyCode(1);
		subject1.setSubjectName("FÍSICA I");
		subject1.setSubjectLevel(4);
		
		Subject subject2 = new Subject();
		subject2.setSubjectKeyCode(2);
		subject2.setSubjectName("CÁLCULO DIFERENCIAL");
		subject2.setSubjectLevel(4);
		
		Specialty spe1 = new Specialty();
		spe1.setSpecialityKeycode(2);
		spe1.setSpecialityName("ELECTRÓNICA");
		
		Specialty spe2 = new Specialty();
		spe2.setSpecialityKeycode(4);
		spe2.setSpecialityName("LABORATORISTA QUÍMICO");
		
		Teacher teacher = new Teacher();
		teacher.setTeacherName("Erick Omar");
		teacher.setTeacherLastNameFather("Palma");
		teacher.setTeacherLastNameMother("Nuñez");
		teacher.setTeacherUsername("test");
		teacher.setTeacherPassword("test");
		teacher.setTeacherGenre('H');
		teacher.setTeacherRFC("PANEXXXXXXXX");
		teacher.setIdInstitute(inst);
		
		teacher.getSubjects().add(subject1);
		teacher.getSubjects().add(subject2);
		teacher.getSpecialities().add(spe1);
		teacher.getSpecialities().add(spe2);
		
		TeacherDAO dao = new TeacherDAO();
		System.out.println(dao.saveTeacher(teacher));*/
		
		
		/*Institute inst = new Institute();
		inst.setIdInstitute(1);
		inst.setInstituteName("CBTIS NO. 38");
		
		Teacher teacher = new Teacher();
		teacher.setIdTeacher(3);
		teacher.setTeacherName("Erick Omar");
		teacher.setTeacherLastNameFather("Palma");
		teacher.setTeacherLastNameMother("Nuñez");
		teacher.setTeacherUsername("test");
		teacher.setTeacherPassword("test");
		teacher.setTeacherGenre('H');
		teacher.setTeacherRFC("PANEXXXXXXXX");
		teacher.setIdInstitute(inst);
		
		SpecialityDAO spe = new SpecialityDAO();
		spe.getSpecialitiesByTeacher(teacher);*/
	
		/*ScoreDAO sco = new ScoreDAO();
		Subject sub = new Subject();
		sub.setSubjectKeyCode(46);
		sub.setSubjectLevel(0);
		sub.setSubjectName("INGLÉS II");
		
		Group group = new Group();
		group.setGroupName("2A");
		group.setIdGroup(5);
		
		Speciality speciality = new Speciality();
		speciality.setSpecialityKeycode(1);
		speciality.setSpecialityName("ELECTRÓNICA");
		
		int size = sco.retrieveStudentsNotApprovedF(sub, speciality, group, "matutino", "finalScore").size();
		System.out.println(size);*/
		
		/*Institute inst = new Institute();
		inst.setIdInstitute(1);
		inst.setInstituteAddress("Guadalajara");
		inst.setInstituteName("CBIS 38");
		inst.setInstitutePhone("3333333333");
		
		Teacher teacher = new Teacher();
		teacher.setIdTeacher(2);
		teacher.setTeacherName("Erick Omar");
		teacher.setTeacherLastName("Palm Nuñez");
		teacher.setTeacherUsername("test");
		teacher.setTeacherPassword("test");
		teacher.setTeaherGenre('H');
		teacher.setTeacherRFC("PANEXXXXXXXX");
		teacher.setIdInstitute(inst);
		
		SubjectDAO sub = new SubjectDAO();
		sub.getSubjectsByTeacher(teacher);*/
	

		/*StatisticsDAO sta = new StatisticsDAO();
		StatisticsForm st = sta.getDataStatisticsOptions();
		System.out.println(st.getShift());*/
		//for(Speciality item : sta.getDataStatistics().getSpecialities()) {
	//		System.out.println(item.getSpecialityKeycode());
		//}
		
		/*CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Administrator> query = builder.createQuery(Administrator.class);
		
		Root<Administrator> root = query.from(Administrator.class);
		query.select(root);
		Query<Administrator> q = session.createQuery(query);
		
		List<Administrator> list = q.getResultList();
		
		for(Administrator item: list)
			System.out.println(item.getAdminName());*/
		
		/*
		Institute inst = new Institute();
		inst.setIdInstitute(1);
		inst.setInstituteAddress("address");
		inst.setInstituteName("CBTIS40");
		inst.setInstitutePhone("3323130804");

		Speciality s = new Speciality("1002", "Biomedical");
		
		
		Group g = new Group("1F");
		g.setIdGroup(1);
		
		Subject sub = new Subject("01", "Mathematics", 1);
		
		Teacher t = new Teacher("Oscar", "zepeda", "oscarin", "1234", 'M', inst);
		t.setIdTeacher(1);
		
		Date date = new Date();
		
		Schedule s1 = new Schedule(date,date,date,date,date,date,date,date,date,date,date,date,sub,g,t);
		s1.setIdSchedule(1);
		Schedule s2 = new Schedule(date,date,date,date,date,date,date,date,date,date,date,date,sub,g,t);
		s2.setIdSchedule(2);
		
		List<Schedule> schedules = new ArrayList<Schedule>();
		schedules.add(s1);
		schedules.add(s2);
		
		Student student = new Student("140120000", "Omar", "Nuñez", "1234", 'M', 1, g, s, inst, schedules);
		
		String id = (String) session.save(student);
		System.out.println(id);
		
		transaction.commit();
		HibernateUtil.shutdown();*/
	}

}
