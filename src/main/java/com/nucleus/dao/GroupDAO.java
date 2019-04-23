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
import com.nucleus.models.Group;

public class GroupDAO implements DataAccessObjectInterface<Group> {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;

	@SuppressWarnings("finally")
	public boolean create(Group obj) {
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
			System.out.println("Error al insertar el grupo " + obj.getGroupName() + " :\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Group obj) {
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
			System.out.println("Error eliminar el grupo " + obj.getGroupName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Group obj) {
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
			System.out.println("Error al actualizar a " + obj.getGroupName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Group read(Group obj) {
		// TODO Auto-generated method stub
		Group grp =  null;
		try {
			query = "FROM Group grp WHERE grp.idGroup = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			grp	=	(Group)session.createQuery(query)
						.setParameter(1, obj.getIdGroup())
						.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar a grupo " + obj.getGroupName() + ":\nERROR:" + ex);
			grp = null;
		}finally {
			session.close();
			return grp;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	public ArrayList<Group> readAll() {
		// TODO Auto-generated method stub
		ArrayList<Group> grpList = null;
		try {
			query = "FROM Group";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			grpList =	(ArrayList<Group>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar la lista de grupos:\nERROR: " + ex);
			grpList = null;
		}finally {
			session.close();
			return grpList;
		}
	}
	
	public Group getGroupByName(String name) {
		
		Transaction transaction = null;
		Group group = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Group> query = builder.createQuery(Group.class);
			
			Root<Group> root = query.from(Group.class);
			query.select(root).where(builder.equal(root.get("groupName"), name));
			
			Query<Group> q = session.createQuery(query);
			group = q.getSingleResult();
			
			transaction.commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return group;
	}

}
