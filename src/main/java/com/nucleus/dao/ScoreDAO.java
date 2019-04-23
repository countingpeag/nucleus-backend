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
import com.nucleus.models.Group;
import com.nucleus.models.Score;
import com.nucleus.models.Speciality;
import com.nucleus.models.Student;
import com.nucleus.models.Subject;

public class ScoreDAO implements DataAccessObjectInterface<Score> {
	SessionFactory sf;
	Session session;	
	boolean response=false;
	String query;
	
	@SuppressWarnings("finally")
	public boolean create(Score obj) {
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
			System.out.println("Error al insertar calificacion " + obj.getIdScore() + " :\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(Score obj) {
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
			System.out.println("Error eliminar calificacion " + obj.getIdScore() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Score obj) {
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
			System.out.println("Error al actualizar calificacion " + obj.getIdScore() + ":\nERROR:" + ex);
		}finally {
			session.close();
			return response;
		}
	}

	@SuppressWarnings("finally")
	public Score read(Score obj) {
		// TODO Auto-generated method stub
		Score scr =  null;
		try {
			query = "FROM Score scr WHERE scr.idScore = ?";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			scr	=	(Score)session.createQuery(query)
					.setParameter(1, obj.getIdScore())
					.uniqueResult();
		}catch(Exception ex) {
			System.out.println("Error al consultar calificacion " + obj.getIdScore() + ":\nERROR:" + ex);
			scr = null;
		}finally {
			session.close();
			return scr;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	public ArrayList<Score> readAll() {
		// TODO Auto-generated method stub
		ArrayList<Score> scrList = null;
		try {
			query = "FROM Score";
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			scrList =	(ArrayList<Score>)session
						.createQuery(query)
						.list();
		}catch(Exception ex) {
			System.out.println("Error al consultar la lista de calificaciones :\nERROR: " + ex);
			scrList = null;
		}finally {
			session.close();
			return scrList;
		}
	}
	
	public List<Score> getStudentsApproved(int subjectKeyCode, int specility, String shift, String partial) {
		List<Score> list = new ArrayList<Score>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(builder.and(builder.and(builder.and(builder.and(
					builder.equal(root.get("studentTuition").get("studentLevel"), root.get("subjectKeycode").get("subjectLevel")),
					builder.greaterThanOrEqualTo(root.<Integer>get(partial), 6)), 
					builder.equal(root.get("subjectKeycode"), subjectKeyCode)), 
					builder.equal(root.get("studentTuition").get("idSpeciality"), specility)),
					builder.equal(root.get("studentTuition").get("studentShift"), shift)));
			
			Query<Score> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Score> getStudentsNotApproved(int subjectKeyCode, int specility, String shift, String partial) {
		List<Score> list = new ArrayList<Score>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(builder.and(builder.and(builder.and(builder.and(
												builder.equal(root.get("studentTuition").get("studentLevel"), root.get("subjectKeycode").get("subjectLevel")),
												builder.lessThan(root.<Integer>get(partial), 6)), 
												builder.equal(root.get("subjectKeycode"), subjectKeyCode)), 
												builder.equal(root.get("studentTuition").get("idSpeciality"), specility)),
												builder.equal(root.get("studentTuition").get("studentShift"), shift)));
			
			Query<Score> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Score> getStudentsNotApprovedM(int subjectKeyCode, int specility, String shift, String partial) {
		List<Score> list = new ArrayList<Score>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(builder.and(builder.and(builder.and(builder.and(builder.and(
												 builder.equal(root.get("studentTuition").get("studentLevel"), root.get("subjectKeycode").get("subjectLevel")),
												 builder.lessThan(root.<Integer>get(partial), 6)), 
												 builder.equal(root.get("subjectKeycode"), subjectKeyCode)), 
												 builder.equal(root.get("studentTuition").get("idSpeciality"), specility)),
												 builder.equal(root.get("studentTuition").get("studentGenre"), 'H')),
												 builder.equal(root.get("studentTuition").get("studentShift"), shift)));
			
			Query<Score> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Score> getStudentsNotApprovedF(int subjectKeyCode, int specility, String shift, String partial) {
		List<Score> list = new ArrayList<Score>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(builder.and(builder.and(builder.and(builder.and(builder.and(
												 builder.equal(root.get("studentTuition").get("studentLevel"), root.get("subjectKeycode").get("subjectLevel")),
												 builder.lessThan(root.<Integer>get(partial), 6)), 
												 builder.equal(root.get("subjectKeycode"), subjectKeyCode)), 
												 builder.equal(root.get("studentTuition").get("idSpeciality"), specility)),
												 builder.equal(root.get("studentTuition").get("studentGenre"), 'M')),
												 builder.equal(root.get("studentTuition").get("studentShift"), shift)));
			
			Query<Score> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	public List<Score> retrieveStudentsApproved(Subject subjectKeyCode, Speciality specialty, Group group, String shift, String partial) {
		List<Score> list = new ArrayList<Score>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(
					builder.equal(root.get("studentTuition").get("studentLevel"), root.get("subjectKeycode").get("subjectLevel")),
					builder.greaterThanOrEqualTo(root.<Integer>get(partial), 6), 
					builder.equal(root.get("subjectKeycode"), subjectKeyCode.getSubjectKeyCode()), 
					builder.equal(root.get("studentTuition").get("idSpeciality"), specialty.getSpecialityKeycode()),
					builder.equal(root.get("studentTuition").get("studentShift"), shift),
					builder.equal(root.get("studentTuition").get("idGroup"), group.getIdGroup())
					);
			
			Query<Score> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Score> retrieveStudentsNotApproved(Subject subjectKeyCode, Speciality specialty, Group group, String shift, String partial) {
		List<Score> list = new ArrayList<Score>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(
										builder.equal(root.get("studentTuition").get("studentLevel"), root.get("subjectKeycode").get("subjectLevel")),
										builder.lessThan(root.<Integer>get(partial), 6), 
										builder.equal(root.get("subjectKeycode"), subjectKeyCode.getSubjectKeyCode()), 
										builder.equal(root.get("studentTuition").get("idSpeciality"), specialty.getSpecialityKeycode()),
										builder.equal(root.get("studentTuition").get("studentShift"), shift),
										builder.equal(root.get("studentTuition").get("idGroup"), group.getIdGroup())
									);
			
			Query<Score> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Score> retrieveStudentsNotApprovedM(Subject subjectKeyCode, Speciality specialty, Group group, String shift, String partial) {
		List<Score> list = new ArrayList<Score>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(
										builder.equal(root.get("studentTuition").get("studentLevel"), root.get("subjectKeycode").get("subjectLevel")),
									 	builder.lessThan(root.<Integer>get(partial), 6), 
									 	builder.equal(root.get("subjectKeycode"), subjectKeyCode.getSubjectKeyCode()), 
									 	builder.equal(root.get("studentTuition").get("idSpeciality"), specialty.getSpecialityKeycode()),
									 	builder.equal(root.get("studentTuition").get("studentGenre"), 'H'),
									 	builder.equal(root.get("studentTuition").get("studentShift"), shift),
										builder.equal(root.get("studentTuition").get("idGroup"), group.getIdGroup())
									);
			
			Query<Score> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Score> retrieveStudentsNotApprovedF(Subject subjectKeyCode, Speciality specialty, Group group, String shift, String partial) {
		List<Score> list = new ArrayList<Score>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(
										builder.equal(root.get("studentTuition").get("studentLevel"), root.get("subjectKeycode").get("subjectLevel")),
										builder.lessThan(root.<Integer>get(partial), 6), 
										builder.equal(root.get("subjectKeycode"), subjectKeyCode.getSubjectKeyCode()), 
										builder.equal(root.get("studentTuition").get("idSpeciality"), specialty.getSpecialityKeycode()),
										builder.equal(root.get("studentTuition").get("studentGenre"), 'M'),
										builder.equal(root.get("studentTuition").get("studentShift"), shift),
										builder.equal(root.get("studentTuition").get("idGroup"), group.getIdGroup())
									);
			
			Query<Score> q = session.createQuery(query);
			list = q.getResultList();
			
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public Score getScoreByStudentSubject(Student student, Subject subject) {
		
		Score score= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(builder.equal(root.get("studentTuition"), student), 
									builder.equal(root.get("subjectKeycode"), subject.getSubjectKeyCode()));
			
			Query<Score> q = session.createQuery(query);
			score = q.getSingleResult();
			
			return score;
		}
		catch(Exception e) {
			return new Score();
		}
	}
	
	public boolean deleteScoreByStudent(Student student) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
		    Query query = session
		                .createQuery("DELETE FROM Score scr WHERE scr.studentTuition = :tuition")
		                .setParameter("tuition", student);
		    query.executeUpdate();
		    transaction.commit();
		    return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Score> getStudentsByTest(Subject subject, Group group, Speciality speciality, String shift){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Score> scores = null;
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Score> query = builder.createQuery(Score.class);
			
			Root<Score> root = query.from(Score.class);
			query.select(root).where(builder.equal(root.get("subjectKeycode"), subject),
									builder.equal(root.get("studentTuition").get("studentShift"), shift),
									builder.equal(root.get("studentTuition").get("idGroup"), group),
									builder.equal(root.get("studentTuition").get("idSpeciality"), speciality));

			Query<Score> q = session.createQuery(query);
			scores = q.getResultList();
			
			for(Score score: scores) {
				score.getSubjectKeycode().setTeachers(null);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return scores;
	}
}