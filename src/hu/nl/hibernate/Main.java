package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hu.nl.hibernate.dao.OvChipkaartDaoImpl;
import hu.nl.hibernate.dao.OvChipkaartDaoOracle;
import hu.nl.hibernate.dao.ReizgerDaoOracle;
import hu.nl.hibernate.dao.ReizigerDaoImpl;
import hu.nl.hibernate.pojo.OvChipkaart;
import hu.nl.hibernate.pojo.Reiziger;

public class Main {
  //private static SessionFactory factory;
  public static void main(String[] args) throws SQLException, ParseException {
      ReizigerDaoImpl Reizigerdao = new ReizgerDaoOracle();
      OvChipkaartDaoImpl OvDao= new OvChipkaartDaoOracle();
	  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	  java.util.Date d = sdf.parse("09-09-2020");
	  java.sql.Date d1 = new java.sql.Date(d.getTime());
	  Reiziger reizigerTest =Reizigerdao.getReizigerbyID(1);
	  System.out.println(reizigerTest);
	  List<Reiziger> reizigers= Reizigerdao.getAllReiziger();
	  System.out.println(reizigers);
	  for(Reiziger reiziger: reizigers) {
		  System.out.println(reiziger.getOvChipKaarten());
	  }
	OvChipkaart ov = OvDao.getKaartById(46392);
	System.out.println(ov);
	ov.setSaldo(50.25);
	OvDao.updateKaart(ov);
	OvChipkaart ov2 = new OvChipkaart();
	ov2.setGeldigtot(d1);
	ov2.setKaartnummer(11111);
	ov2.setKlasse(2);
	ov2.setSaldo(0.0);
	ov2.setReiziger(reizigerTest);
	System.out.println(ov2);
	OvDao.saveKaart(ov2);
	OvDao.deleteKaart(ov2);
	System.out.println(OvDao.getAllKaart());
  } 
}
