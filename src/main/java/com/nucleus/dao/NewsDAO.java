package com.nucleus.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nucleus.hibernate.HibernateUtil;
import com.nucleus.interfaces.DataAccessObjectInterface;
import com.nucleus.models.News;

public class NewsDAO implements DataAccessObjectInterface<News> {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;

	@SuppressWarnings("finally")
	public boolean create(News obj) {
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
			System.out.println("Error al insertar la noticia " + obj.getIdNew() + " :\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(News obj) {
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
			System.out.println("Error eliminar la noticia " + obj.getIdNew() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(News obj) {
		Session session = null;
	    Transaction transaction = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      transaction = session.beginTransaction();
	      
	      session.saveOrUpdate(obj);

	      transaction.commit();
	    } catch (Exception e) {
	      if (transaction != null) {
	        transaction.rollback();
	      }
	      e.printStackTrace();
	      return false;
	    } finally {
	      if (session != null) {
	        session.close();
	      }
	      return true;
	    }

	}

	@SuppressWarnings("finally")
	public News read(News obj) {
		// TODO Auto-generated method stub
		News nw =  null;
		try {
			query = "FROM News ws WHERE ws.idNew = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			nw	=	(News)session.createQuery(query)
					.setParameter(1, obj.getIdNew())
					.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar la noticia " + obj.getIdNew() + ":\nERROR:" + ex);
			nw = null;
		}finally {
			session.close();
			return nw;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	public ArrayList<News> readAll() {
		// TODO Auto-generated method stub
		ArrayList<News> nwList = null;
		try {
			query = "FROM News";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			nwList =	(ArrayList<News>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar la lista de noticias:\nERROR: " + ex);
			nwList = null;
		}finally {
			session.close();
			return nwList;
		}
		
	}

}
