package com.nucleus.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nucleus.hibernate.HibernateUtil;
import com.nucleus.interfaces.DataAccessObjectInterface;
import com.nucleus.models.Schedule;

public class ScheduleDAO implements DataAccessObjectInterface<Schedule> {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;

	@SuppressWarnings("finally")
	public boolean create(Schedule obj) {
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
			System.out.println("Error al insertar horario " + obj.getIdSchedule() + " :\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Schedule obj) {
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
			System.out.println("Error eliminar horario " + obj.getIdSchedule() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Schedule obj) {
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
			System.out.println("Error al actualizar horario " + obj.getIdSchedule() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Schedule read(Schedule obj) {
		// TODO Auto-generated method stub
		Schedule sch =  null;
		try {
			query = "FROM Schedule sch WHERE sch.idSchedule = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			sch	=	(Schedule)session.createQuery(query)
					.setParameter(1, obj.getIdSchedule())
					.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar el horario " + obj.getIdSchedule() + ":\nERROR:" + ex);
			sch = null;
		}finally {
			session.close();
			return sch;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	public ArrayList<Schedule> readAll() {
		// TODO Auto-generated method stub
		ArrayList<Schedule> schList = null;
		try {
			query = "FROM Schedule";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			schList =	(ArrayList<Schedule>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar la lista de horarios :\nERROR: " + ex);
			schList = null;
		}finally {
			session.close();
			return schList;
		}
	}

}
