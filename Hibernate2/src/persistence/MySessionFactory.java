package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
	private static SessionFactory factory;
	
	private static void createSessionFactory() {
		// TODO Auto-generated constructor stub
		if(factory != null)
			return;
		
		Configuration configuration = new Configuration().
				configure();	
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		factory = configuration.
				buildSessionFactory(builder.build());
	}
	public MySessionFactory() {
		factory = null;
	}
	
	static Session getSession() {
		if(factory == null)
			createSessionFactory();
		return factory.openSession();
	}
}
