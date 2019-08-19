package hu.nl.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hu.nl.hibernate.pojo.OvChipkaart;
import hu.nl.hibernate.pojo.Reiziger;

public class OvChipkaartDaoOracle extends OracleHibernateBaseDao implements OvChipkaartDaoImpl{
	//tutorial from https://www.tutorialspoint.com/hibernate/

	//general ov_chipkaart control dao class, all coupling is done in the pojo annotations
	@Override
	public OvChipkaart getKaartById(int id) {
		OvChipkaart r=null;
		try(SessionFactory factory = getFactory()){
		Session session = factory.openSession();
		//get's an ov-chipkaart by id
		r = (OvChipkaart)session.get(OvChipkaart.class, id);
		session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean saveKaart(OvChipkaart ov) {
		boolean b = false;
		try (SessionFactory factory = getFactory()) {

			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			//saves the new ov_chipkaart
			session.save(ov);
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
	public boolean updateKaart(OvChipkaart ov) {
		try (SessionFactory factory = getFactory()) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			//changes data from ov_chipkaart even updating connections to other tables
			session.update(ov);
			t.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteKaart(OvChipkaart ov) {
		try (SessionFactory factory = getFactory()) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			//deletes a card if nothing is depending on it. If you want to delte even if dependancies are there you would need to set cascadable fuctions according to the tutorialspoint tutorial.
			session.delete(ov);
			t.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public ArrayList<OvChipkaart> getAllKaart() {
		List<OvChipkaart> list=null;
		try(SessionFactory factory = getFactory()){
			Session session=factory.openSession();
			
			Transaction tx = null;
			tx= session.beginTransaction();
			//same as in reiziger, I made a direct reference to the location of the pojo(as indicated in the hibernate file), It wouldn't be reconized in any other way
			list=session.createQuery("FROM hu.nl.hibernate.pojo.OvChipkaart").list();
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	return (ArrayList<OvChipkaart>) list;
	}
}
