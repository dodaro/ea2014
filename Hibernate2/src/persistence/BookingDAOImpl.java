package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookingDAOImpl implements BookingDAO{

	@Override
	public void delete(Booking booking) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(booking);
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
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		List<Booking> bookings = (List<Booking>) session.createQuery("from booking").list();		 
	    session.close();	
	    return bookings;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getByPriceGreaterThan(Double price) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();		
		List<Booking> bookings = (List<Booking>) session.createQuery("from Booking b where b.price > " + price).list();		 
	    session.close();	
	    return bookings;			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getByPriceLessThan(Double price) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();		
		List<Booking> bookings = (List<Booking>) session.createQuery("from Booking b where b.price < " + price).list();		 
	    session.close();	
	    return bookings;
	}

	@Override
	public Booking getBooking(Integer id) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		String queryString = "from Booking where id = :id_booking";
		Query query = session.createQuery(queryString);
		query.setParameter("id_booking", id);
		Booking b = (Booking) query.uniqueResult();		 
	    session.close();	
	    return b;	
	}

	@Override
	public void create(Booking booking) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(booking);
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
	public Long numberOfBookings() {
		// TODO Auto-generated method stub		
		Session session = MySessionFactory.getSession();
		Long size = (Long) session.createQuery("select count(*) from Booking").uniqueResult();		 
	    session.close();	
	    return size;
	}	

	@Override
	public void update(Booking booking) {
		// TODO Auto-generated method stub
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(booking);
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
