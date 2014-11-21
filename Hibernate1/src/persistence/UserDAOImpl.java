package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UserDAOImpl implements UserDAO {	
	private static SessionFactory factory; 
	
	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
		Configuration configuration = new Configuration().
				configure();		
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		factory = configuration.
				buildSessionFactory(builder.build());		
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
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
		Session session = factory.openSession();
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
		Session session = factory.openSession();
		int size = session.createSQLQuery("SELECT * FROM users").list().size();		 
	    session.close();
		return size;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		session.close();
		return users;
	}

	@Override
	public User get(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where id = " + id).addEntity(User.class).uniqueResult();				
		session.close();
		return user;
	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where username = '" + username + "'").addEntity(User.class).uniqueResult();
		session.close();
		return user;	
	}		

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
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
}
