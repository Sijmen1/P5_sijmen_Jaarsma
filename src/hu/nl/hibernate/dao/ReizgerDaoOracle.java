package hu.nl.hibernate.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.fasterxml.classmate.AnnotationConfiguration;

import org.hibernate.cfg.*;

import hu.nl.hibernate.pojo.Reiziger;

public class ReizgerDaoOracle extends OracleHibernateBaseDao implements ReizigerDaoImpl {
	@Override
	//tutorial from https://www.tutorialspoint.com/hibernate/

	//general reiziger dao class, all coupling is done in the pojo annotations
	public boolean saveReiziger(Reiziger r) {
		boolean b = false;
		try (SessionFactory factory = getFactory()) {

			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			//saves a new reiziger into the system
			session.save(r);
			t.commit();
			b = true;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	@Override
	public boolean updateReiziger(Reiziger r) {
		// TODO Auto-generated method stub

		try (SessionFactory factory = getFactory()) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			//updates a reiziger 
			session.update(r);
			t.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteReiziger(Reiziger r) {
		// TODO Auto-generated method stub

		try (SessionFactory factory = getFactory()) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			//deletes a reiziger
			session.delete(r);
			t.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Reiziger getReizigerbyID(int id) {
		Reiziger r=null;
		try(SessionFactory factory = getFactory()){
		Session session = factory.openSession();
		//gets a specific reiziger.
		r = (Reiziger)session.get(Reiziger.class, id);
		session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reiziger> getAllReiziger() {
		List<Reiziger> list=null;
		try(SessionFactory factory = getFactory()){
			Session session=factory.openSession();
			
			Transaction tx = null;
			tx= session.beginTransaction();
			//due to a problem with the mapping I had I found I couldn't simply refer to the pojo Unless I kept it in the same map.
			//In order to work around this problem I refer directly to the source
			list=session.createQuery("FROM hu.nl.hibernate.pojo.Reiziger").list();
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	return list;
	}

}
