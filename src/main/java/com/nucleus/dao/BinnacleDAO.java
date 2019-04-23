package com.nucleus.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nucleus.hibernate.HibernateUtil;
import com.nucleus.interfaces.DataAccessObjectInterface;
import com.nucleus.models.Binnacle;


public class BinnacleDAO implements DataAccessObjectInterface<Binnacle> {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;

	@SuppressWarnings("finally")
	public boolean create(Binnacle obj) {
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
			System.out.println("Error al insertar la accion " + obj.getBinnacleAction() + " a la bitacora :\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	public boolean delete(Binnacle obj) {
		// TODO Auto-generated method stub
		//-----------------------------
		//-----------------------------
		//-----------------------------
		//		LA BITACORA NO SE BORRARA
		//-----------------------------
		//-----------------------------
		//-----------------------------
		return false;
	}

	public boolean update(Binnacle obj) {
		// TODO Auto-generated method stub
		//-----------------------------
		//-----------------------------
		//-----------------------------
		//		LA BITACORA NO SE ACTUALIZARA
		//-----------------------------
		//-----------------------------
		//-----------------------------
		return false;
	}

	@SuppressWarnings("finally")
	public Binnacle read(Binnacle obj) {
		// TODO Auto-generated method stub
		Binnacle bncle =  null;
		try {
			query = "FROM Binnacle bncle WHERE bncle.idBinnacle = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			bncle	=	(Binnacle)session.createQuery(query)
						.setParameter(1, obj.getIdBinnacle())
						.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar la accion " + obj.getIdBinnacle() + ":\nERROR:" + ex);
			bncle = null;
		}finally {
			session.close();
			return bncle;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	public ArrayList<Binnacle> readAll() {
		// TODO Auto-generated method stub
		ArrayList<Binnacle> bncleList = null;
		try {
			query = "FROM Binnacle";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			bncleList =	(ArrayList<Binnacle>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar la bitacora de acciones:\nERROR: " + ex);
			bncleList = null;
		}finally {
			session.close();
			return bncleList;
		}
	}

}
