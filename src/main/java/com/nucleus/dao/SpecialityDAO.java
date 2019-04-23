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
import com.nucleus.models.Speciality;
import com.nucleus.models.Teacher;

public class SpecialityDAO implements DataAccessObjectInterface<Speciality>{
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;
	
	@SuppressWarnings("finally")
	public boolean create(Speciality obj) {
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
			System.out.println("Error al insertar especialidad " + obj.getSpecialityKeycode() + " :\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Speciality obj) {
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
			System.out.println("Error eliminar especialidad " + obj.getSpecialityKeycode() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Speciality obj) {
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
			System.out.println("Error al actualizar especialidad " + obj.getSpecialityKeycode() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Speciality read(Speciality obj) {
		// TODO Auto-generated method stub
		Speciality spc =  null;
		try {
			query = "FROM Speciality spc WHERE spc.specialityKeycode = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			spc	=	(Speciality)session.createQuery(query)
					.setParameter(1, obj.getSpecialityKeycode())
					.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar especialidad " + obj.getSpecialityKeycode() + ":\nERROR:" + ex);
			spc = null;
		}finally {
			session.close();
			return spc;
		}
	}

	public List<Speciality> readAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Speciality> specialities = null;
		
	      try {

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Speciality> query = builder.createQuery(Speciality.class);
	         
	         Root<Speciality> root = query.from(Speciality.class);
	         query.select(root);
	         
	         Query<Speciality> q=session.createQuery(query);
	         specialities = q.getResultList();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	     
	      return specialities;
	}

	public Speciality getSpecialityByName(String name) {
		
		Transaction transaction = null;
		Speciality speciality = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Speciality> query = builder.createQuery(Speciality.class);
			
			Root<Speciality> root = query.from(Speciality.class);
			query.select(root).where(builder.equal(root.get("specialityName"), name));
			
			Query<Speciality> q = session.createQuery(query);
			speciality = q.getSingleResult();
			
			transaction.commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return speciality;
	}
	
	@SuppressWarnings("unchecked")
	public List<Speciality> getSpecialitiesByTeacher(Teacher teacher){
		List<Object[]> objects = null;
		List<Speciality> specialities = new ArrayList<Speciality>();
		
		String query = "SELECT specialty_keycode, specialty_name FROM specialities AS spe "
				+ "INNER JOIN teachers_has_specialities AS ths "
				+ "ON spe.specialty_keycode = ths.specialities_specialty_keycode "
				+ "WHERE ths.teachers_id_teachers = "+teacher.getIdTeacher();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			objects = session.createNativeQuery(query).list();
			
			for(Object[] object: objects) {
				Speciality spe = new Speciality();
				spe.setSpecialityKeycode((Integer)object[0]);
				spe.setSpecialityName((String)object[1]);
				
				specialities.add(spe);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return specialities;
	}
}
