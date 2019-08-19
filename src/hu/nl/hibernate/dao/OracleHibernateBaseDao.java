package hu.nl.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleHibernateBaseDao {
	
	public SessionFactory getFactory() {
		//A simple factory setup to prevent having to write this over and over.
		//I have changed this from the main tutorial of tutorialspoint as I found declaring it everytime to not  be a good look.
		SessionFactory factory;
		boolean b = false;
	      try {
	          factory = new Configuration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	          System.err.println("Failed to create sessionFactory object." + ex);
	          throw new ExceptionInInitializerError(ex);
	        }
	      return factory;
		
	}

}
