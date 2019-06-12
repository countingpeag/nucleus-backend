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
import com.nucleus.models.Subject;
import com.nucleus.models.Teacher;
import com.nucleus.requestModels.TeacherChangePassword;

public class TeacherDAO implements DataAccessObjectInterface<Teacher>,LoginInterface<Teacher> {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;
	
	@SuppressWarnings("finally")
	public boolean create(Teacher obj) {
		// TODO Auto-generated method stub
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			session.save(obj);
			session.beginTransaction().commit();
			//RESPUESTA OK
			response = true;
		}catch(Exception ex) {
			//RESPUESTA ERROR
			response = false;
			System.out.println("Error al insertar a " + obj.getTeacherName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Teacher obj) {
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
			System.out.println("Error eliminar a " + obj.getTeacherName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Teacher obj) {
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
			System.out.println("Error al insertar a " + obj.getTeacherName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Teacher read(Teacher obj) {
		// TODO Auto-generated method stub
		Teacher tch =  null;
		try {
			query = "FROM Teacher tch WHERE tch.idTeacher = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tch	=	(Teacher)session.createQuery(query)
					.setParameter(1, obj.getIdTeacher())
					.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar a " + obj.getTeacherName() + ":\nERROR:" + ex);
			tch = null;
		}finally {
			session.close();
			return tch;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	public ArrayList<Teacher> readAll() {
		// TODO Auto-generated method stub
		ArrayList<Teacher> tchList = null;
		try {
			query = "FROM Teacher";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tchList =	(ArrayList<Teacher>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar lista de maestros:\nERROR: " + ex);
			tchList = null;
		}finally {
			session.close();
			return tchList;
		}
	}

	public boolean changePassword(TeacherChangePassword teacher) {
		
		Transaction transaction = null; 
		Teacher teacherToChange = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Teacher> query = builder.createQuery(Teacher.class);
			Root<Teacher> root = query.from(Teacher.class);
			
			query.select(root).where(builder.equal(root.get("idTeacher"), teacher.getTeacherId()), builder.equal(root.get("teacherPassword"), teacher.getOldTeacherPassword()));
			Query<Teacher> q = session.createQuery(query);
			
			teacherToChange = q.getSingleResult();
			
			if(teacherToChange!=null) {
				teacherToChange.setTeacherPassword(teacher.getNewTeacherPassword());
				session.saveOrUpdate(teacherToChange);
			}
			else {
				return false;
			}
			
			transaction.commit();
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Teacher getLogin(Teacher obj) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacher = null;
		
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Teacher> query = builder.createQuery(Teacher.class);
			Root<Teacher> root = query.from(Teacher.class);
			
			query.select(root).where(builder.equal(root.get("teacherUsername"), obj.getTeacherUsername()), builder.equal(root.get("teacherPassword"), obj.getTeacherPassword()));
			Query<Teacher> q = session.createQuery(query);
			
			teacher = q.getSingleResult();
			transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return teacher;
	}
	
	public boolean saveTeacher(Teacher teacher) { 
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(teacher);
			transaction.commit();
		} 
		catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public Teacher getTeacherByName(String rfc) {
		
		Teacher teacher = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Teacher> query = builder.createQuery(Teacher.class);
			
			Root<Teacher> root = query.from(Teacher.class);
			query.select(root).where(builder.equal(root.get("teacherRFC"),  rfc));
			
			Query<Teacher> q = session.createQuery(query);
			teacher = q.getSingleResult();
			List<Subject> subjects = teacher.getSubjects();
			for(Subject subject: subjects) {
				subject.setTeachers(null);
			}
			teacher.setSubjects(subjects);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return teacher;
	}

}
