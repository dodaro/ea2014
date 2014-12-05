package persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.MySessionFactory;
import persistence.Promotion;

public class PromotionDAOImpl implements PromotionDAO{

	@Override
	public void create(Promotion p) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.save(p);
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
	public Promotion get(Integer id) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		String queryString = "from Promotion where id = :id_promotion";
		Query query = session.createQuery(queryString);
		query.setParameter("id_promotion", id);
		Promotion p = (Promotion) query.uniqueResult();	
		p.getUsers().size();
		session.close();	
	    return p;
	}

	@Override
	public Long numberOfPromotions() {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Long size = (Long) session.createQuery("select count(*) from Promotion").uniqueResult();		 
	    session.close();	
	    return size;
	}

	@Override
	public void update(Promotion p) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.saveOrUpdate(p);
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
	public void delete(Promotion p) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.delete(p);
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
