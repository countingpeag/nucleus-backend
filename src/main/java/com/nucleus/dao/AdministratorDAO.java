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
import com.nucleus.interfaces.LoginInterface;
import com.nucleus.models.Administrator;
import com.nucleus.requestModels.AdminRequestModel;

public class AdministratorDAO implements DataAccessObjectInterface<Administrator>, LoginInterface<Administrator> {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;
	
	
	@SuppressWarnings("finally")
	public boolean create(Administrator obj) {
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
			System.out.println("Error al insertar a " + obj.getAdminName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Administrator obj) {
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
			System.out.println("Error eliminar a " + obj.getAdminName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Administrator obj) {
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
			System.out.println("Error al actualizar a " + obj.getAdminName() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Administrator read(Administrator obj) {
		// TODO Auto-generated method stub
		Administrator adm =  null;
		try {
			query = "FROM Administrator adm WHERE adm.idAdministrator = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			adm	=	(Administrator)session.createQuery(query)
					.setParameter(1, obj.getIdAdministrator())
					.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar a " + obj.getAdminName() + ":\nERROR:" + ex);
			adm = null;
		}finally {
			session.close();
			return adm;
		}
	}

	@SuppressWarnings({ "unchecked", "finally" })
	public ArrayList<Administrator> readAll() {
		// TODO Auto-generated method stub
		ArrayList<Administrator> adminList = null;
		try {
			query = "FROM Administrator";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			adminList =	(ArrayList<Administrator>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar lista de administradores:\nERROR: " + ex);
			adminList = null;
		}finally {
			session.close();
			return adminList;
		}
	}
	
	public boolean updatePassword(AdminRequestModel adminRequest) {
		Transaction transaction=null;
		Administrator administrator=null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Administrator> query = builder.createQuery(Administrator.class);
			Root<Administrator> root = query.from(Administrator.class);
			
			query.select(root).where(builder.equal(root.get("adminRFC"), adminRequest.getRfc()), builder.equal(root.get("adminPassword"), adminRequest.getPassword()));
			Query<Administrator> q = session.createQuery(query);
			administrator = q.getSingleResult();
			
			if(administrator!=null);{
				administrator.setAdminPassword(adminRequest.getNewPassword());
				session.save(administrator);
			}
			
			transaction.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Administrator getLogin(Administrator admin) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Administrator administrator = null;
		
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Administrator> query = builder.createQuery(Administrator.class);
			Root<Administrator> root = query.from(Administrator.class);
			
			query.select(root).where(builder.equal(root.get("adminUsername"), admin.getAdminUsername()), builder.equal(root.get("adminPassword"), admin.getAdminPassword()));
			Query<Administrator> q = session.createQuery(query);
			
			administrator = q.getSingleResult();
			transaction.commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return administrator;
	}
	
	/*@SuppressWarnings("finally")
	public boolean getLogin(Administrator obj) {
		// TODO Auto-generated method stub
		Administrator adm =  null;
		try {
			query = "FROM Administrator adm WHERE adm.adminUsername = ? and adm.adminPassword = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			adm	=	(Administrator)session.createQuery(query)
					.setParameter(0, obj.getAdminUsername())
					.setParameter(1, obj.getAdminPassword())
					.uniqueResult();
			if(adm != null) {
				response = true;
			}else {
				response = false;
			}
		}catch(Exception ex) {
			System.out.println("Error al consultar LOGIN de " + obj.getAdminName() + ":\nERROR:" + ex);
			response = false;
		}finally {
			session.close();
			return response;
		}
	}*/

}
