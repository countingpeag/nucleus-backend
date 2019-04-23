package com.nucleus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nucleus.hibernate.HibernateUtil;
import com.nucleus.interfaces.DataAccessObjectInterface;
import com.nucleus.models.Subject;
import com.nucleus.models.Teacher;

public class SubjectDAO implements DataAccessObjectInterface<Subject>{
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;

	@SuppressWarnings("finally")
	public boolean create(Subject obj) {
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
			System.out.println("Error al insertar materia " + obj.getSubjectKeyCode() + " :\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Subject obj) {
		// TODO Auto-generated method stub
		try {
			//query = "DELETE Administrator adm WHERE adm.idAdministrator = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			session.delete(obj);
			session.beginTransaction().commit();
			//RESPUESTA OK
			response = true;
		}catch(Exception ex) {
			//RESPUESTA ERROR
			response = false;
			System.out.println("Error eliminar materia " + obj.getSubjectKeyCode() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Subject obj) {
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
			System.out.println("Error al actualizar materia " + obj.getSubjectKeyCode() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Subject read(Subject obj) {
		// TODO Auto-generated method stub
		Subject sbj =  null;
		try {
			query = "FROM Subject sbj WHERE sbj.subjectKeyCode = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			sbj	=	(Subject)session.createQuery(query)
					.setParameter(1, obj.getSubjectKeyCode())
					.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar materia " + obj.getSubjectKeyCode() + ":\nERROR:" + ex);
			sbj = null;
		}finally {
			session.close();
			return sbj;
		}
	}

	public List<Subject> readAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Subject> subjects = null;
		
	      try {

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
	         
	         Root<Subject> root = query.from(Subject.class);
	         query.select(root);
	         
	         Query<Subject> q=session.createQuery(query);
	         subjects = q.getResultList();
	         for(Subject subject: subjects) {
	        	 subject.setTeachers(null);
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	     
	      return subjects;
	}
	
	public Subject getSubjectByName(String name) {
		
		Subject subject = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
			
			Root<Subject> root = query.from(Subject.class);
			query.select(root).where(builder.equal(root.get("subjectName"), name));
			
			Query<Subject> q = session.createQuery(query);
			subject = q.getSingleResult();
			subject.setTeachers(null);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return subject;
	}

	@SuppressWarnings("unchecked")
	public List<Subject> getSubjectsByTeacher(Teacher teacher){
		List<Object[]> objects = null;
		List<Subject> subjects= new ArrayList<Subject>();
		
		String query = "SELECT subject_keycode, subject_name, subject_level FROM subjects AS sub "
				+ "INNER JOIN teachers_has_subjects AS ths "
				+ "ON sub.subject_keycode = ths.subject_keycode_join "
				+ "WHERE ths.id_teachers_join = "+teacher.getIdTeacher();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			objects = session.createNativeQuery(query).list();
			
			for(Object[] object: objects) {
				Subject subject = new Subject();
				subject.setSubjectKeyCode((Integer)object[0]);
				subject.setSubjectName((String)object[1]);
				subject.setSubjectLevel((Integer)object[2]);
				
				subjects.add(subject);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return subjects;
	}

}
