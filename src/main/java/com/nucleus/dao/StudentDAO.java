package com.nucleus.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nucleus.hibernate.HibernateUtil;
import com.nucleus.interfaces.DataAccessObjectInterface;
import com.nucleus.interfaces.LoginInterface;
import com.nucleus.models.Student;
import com.nucleus.models.Subject;

public class StudentDAO implements DataAccessObjectInterface<Student>, LoginInterface<Student>  {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;
	
	@SuppressWarnings("finally")
	public boolean create(Student obj) {
		// TODO Auto-generated method stub
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			session.saveOrUpdate(obj);
			session.beginTransaction().commit();
			//RESPUESTA OK
			response = true;
		}catch(Exception ex) {
			//RESPUESTA ERROR
			response = false;
			System.out.println("Error al insertar a " + obj.getStudentName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Student obj) {
		// TODO Auto-generated method stub
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			session.delete(obj);
			session.beginTransaction().commit();
			//RESPUESTA OK
			response = true;
		}catch(Exception ex) {
			//RESPUESTA ERROR
			response = false;
			System.out.println("Error eliminar a " + obj.getStudentName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Student obj) {
		// TODO Auto-generated method stub
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			session.update(obj);
			session.beginTransaction().commit();
			//RESPUESTA OK
			response = true;
		}catch(Exception ex) {
			//RESPUESTA ERROR
			response = false;
			System.out.println("Error al insertar a " + obj.getStudentName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Student read(Student obj) {
		// TODO Auto-generated method stub
		Student std =  null;
		try {
			query = "FROM Student std WHERE std.studentTuition = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			std	=	(Student)session.createQuery(query)
					.setParameter(1, obj.getStudentTuition())
					.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar a " + obj.getStudentName() + ":\nERROR:" + ex);
			std = null;
		}finally {
			session.close();
			return std;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	public ArrayList<Student> readAll() {
		// TODO Auto-generated method stub
		ArrayList<Student> stdList = null;
		try {
			query = "FROM Student";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			stdList =	(ArrayList<Student>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar lista de estudiantes:\nERROR: " + ex);
			stdList = null;
		}finally {
			session.close();
			return stdList;
		}
	}
	
	@SuppressWarnings("finally")
	public Student getLogin(Student obj) {
		// TODO Auto-generated method stub
		Student std =  null;
		try {
			query = "FROM Student std WHERE std.studentTuition = ? and std.studentPassword = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			std	=	(Student)session.createQuery(query)
					.setParameter(1, obj.getStudentTuition())
					.setParameter(2, obj.getStudentPassword())
					.uniqueResult();
			if(std != null) {
				response = true;
			}else {
				response = false;
			}
		}catch(Exception ex) {
			System.out.println("Error al consultar LOGIN de " + obj.getStudentName() + ":\nERROR:" + ex);
			response = false;
		}finally {
			session.close();
			return std;
		}
	}
	
	public List<Student> getValidationStudents(int specialityKeycode, int idGroup, String shift){
		List<Student> list = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Student> query = builder.createQuery(Student.class);
			
			Root<Student> root = query.from(Student.class);
			query.select(root).where(builder.equal(root.get("idSpeciality"), specialityKeycode),
									builder.equal(root.get("idGroup"), idGroup),
									builder.equal(root.get("studentShift"), shift));
			
			Query<Student> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean updateStudentVisibility(List<Student> students) {
	
		Transaction transaction = null;
		Student studentToUpdate = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			for(Student student : students) {
				studentToUpdate = (Student) session.get(Student.class, student.getStudentTuition());
				studentToUpdate.setStudentVisibility(student.getStudentVisibility());
				session.update(studentToUpdate);
			}
			
			transaction.commit();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public Student getStudentByTuition(long tuition) {
		
		Student student = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Student> query = builder.createQuery(Student.class);
			
			Root<Student> root = query.from(Student.class);
			query.select(root).where(builder.equal(root.get("studentTuition"),  String.valueOf(tuition)));
			
			Query<Student> q = session.createQuery(query);
			student = q.getSingleResult();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return student;
	}

	//check it out **************************
	public List<Student> getStudentsBySubject(Subject subject){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Student> students = null;
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Student> query = builder.createQuery(Student.class);
			
			Root<Student> root = query.from(Student.class);
			query.select(root).where(builder.equal(root.get("schedules").get("subjectKeycode"), subject));
			
			Query<Student> q = session.createQuery(query);
			students = q.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
}
