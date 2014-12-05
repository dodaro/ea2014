package persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.Member;
import persistence.MySessionFactory;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public void create(Member m) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.save(m);
			tx.commit();
		 }
		 catch (Exception e) {
		    if (tx!=null) 
		    		tx.rollback();
		    throw e;
		 }
		 finally {
		     session.close();
		 }		 
	}

	@Override
	public Member get(Integer id) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		String queryString = "from Member where id = :id_member";
		Query query = session.createQuery(queryString);
		query.setParameter("id_member", id);
		Member m = (Member) query.uniqueResult();	
		session.close();	
	    return m;
	}	

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.saveOrUpdate(m);
			tx.commit();
		 }
		 catch (Exception e) {
		    if (tx!=null) 
		    		tx.rollback();
		    throw e;
		 }
		 finally {
		     session.close();
		 }
	}

	@Override
	public void delete(Member m) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.delete(m);
			tx.commit();
		 }
		 catch (Exception e) {
		    if (tx!=null) 
		    		tx.rollback();
		    throw e;
		 }
		 finally {
		     session.close();
		 }
	}

	@Override
	public Double sumOfSalary() {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		String queryString = "select sum(salary) from Professor";
		Query query = session.createQuery(queryString);
		Double d = (Double) query.uniqueResult();	
		session.close();	
	    return d;
	}

	@Override
	public Double maxOfAvgScore() {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		String queryString = "select max(avgScore) from Student";
		Query query = session.createQuery(queryString);
		Double d = (Double) query.uniqueResult();	
		session.close();	
	    return d;
	}	
}
