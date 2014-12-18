package persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.Person;
import persistence.MySessionFactory;

public class PersonDAOImpl implements PersonDAO{

	@Override
	public void create(Person m) {
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
	public Person get(Integer id) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		String queryString = "from Person where id = :id_person";
		Query query = session.createQuery(queryString);
		query.setParameter("id_person", id);
		Person m = (Person) query.uniqueResult();	
		session.close();	
	    return m;
	}
	
	@Override
	public Integer numberOfMobileNumbers(Integer id) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		String queryString = "from Person where id = :id_person";
		Query query = session.createQuery(queryString);
		query.setParameter("id_person", id);
		Person m = (Person) query.uniqueResult();
		Integer res = m.getMobileNumbers().size();		
		session.close();	
	    return res;
	}
	
	@Override
	public Integer numberOfAddresses(Integer id) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		String queryString = "from Person where id = :id_person";
		Query query = session.createQuery(queryString);
		query.setParameter("id_person", id);
		Person m = (Person) query.uniqueResult();
		Integer res = m.getAddresses().size();
		session.close();	
	    return res;
	}

	@Override
	public void update(Person m) {
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
	public void delete(Person m) {
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
}
