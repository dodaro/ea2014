package persistence;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {	 
	
	public UserDAOImpl() {
		
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
			session.save(user);
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
	public void delete(User user) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(user);
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
	public int numberOfUsers() {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		int size = session.createSQLQuery("SELECT * FROM users").list().size();		 
	    session.close();
		return size;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		session.close();
		return users;
	}

	@Override
	public User get(Integer id) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where id = " + id).addEntity(User.class).uniqueResult();
		user.getBookings().size();
		if(user!=null)
		{
			for (Booking b : user.getBookings()) {
			    Hibernate.initialize(b);
			}
		}
		session.close();
		return user;
	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where username = '" + username + "'").addEntity(User.class).uniqueResult();		
		session.close();
		return user;	
	}	

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(user);			
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getBookings(User user) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();		
		List<Booking> bookings = (List<Booking>) session.createQuery("from Booking b where user =" +user.getId()).list();		 
	    session.close();	
	    return bookings;
	}

	@Override
	public Double getTotalPrice(User user) {
		// TODO Auto-generated method stub		
		Session session = MySessionFactory.getSession();
		Double sum = (Double) session.createQuery("select sum(price) from Booking where user = "+user.getId()).uniqueResult();		
	    session.close();	
	    return sum;
	}		
}
