package com.nucleus.dao;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nucleus.hibernate.HibernateUtil;
import com.nucleus.interfaces.DataAccessObjectInterface;
import com.nucleus.models.Institute;

public class InstituteDAO implements DataAccessObjectInterface<Institute> {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;
	
	@SuppressWarnings("finally")
	public boolean create(Institute obj) {
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
			System.out.println("Error al insertar el instituta " + obj.getInstituteName() + " :\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Institute obj) {
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
			System.out.println("Error eliminar el instituto " + obj.getInstituteName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Institute obj) {
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
			System.out.println("Error al actualizar al instituto " + obj.getInstituteName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Institute read(Institute obj) {
		// TODO Auto-generated method stub
		Institute inst =  null;
		try {
			query = "FROM Institute inst WHERE inst.idInstitute = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			inst	=	(Institute)session.createQuery(query)
						.setParameter(1, obj.getIdInstitute())
						.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar a instituto " + obj.getIdInstitute() + ":\nERROR:" + ex);
			inst = null;
		}finally {
			session.close();
			return inst;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	public ArrayList<Institute> readAll() {
		// TODO Auto-generated method stub
		ArrayList<Institute> instList = null;
		try {
			query = "FROM Institute";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			instList =	(ArrayList<Institute>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar la lista de institutos:\nERROR: " + ex);
			instList = null;
		}finally {
			session.close();
			return instList;
		}
	}
	
	public Institute getInstituteByName(String name) {
		
		Transaction transaction = null;
		Institute institute = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Institute> query = builder.createQuery(Institute.class);
			
			Root<Institute> root = query.from(Institute.class);
			query.select(root).where(builder.equal(root.get("instituteName"), name));
			
			Query<Institute> q = session.createQuery(query);
			institute = q.getSingleResult();
			
			transaction.commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return institute;
	}

}
