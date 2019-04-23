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
import com.nucleus.models.Candidate;

public class CandidatesDAO {
	Session session;	
	
	public List<Candidate> getAllCandidates() {
		Transaction transaction = null;
		session = HibernateUtil.getSessionFactory().openSession();
		List<Candidate> candidates = new ArrayList<Candidate>();
	      try {
	         transaction = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Candidate> query = builder.createQuery(Candidate.class);
	         Root<Candidate> root = query.from(Candidate.class);
	         query.select(root);
	         Query<Candidate> q=session.createQuery(query);
	         candidates = q.getResultList();
	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	    
	   return candidates;
	}
	
}
