package hu.nl.hibernate.dao;

//import java.util.ArrayList;
import java.util.List;

import hu.nl.hibernate.pojo.Reiziger;

public interface ReizigerDaoImpl {
	
	public boolean saveReiziger(Reiziger r);
	public boolean updateReiziger(Reiziger r);
	public boolean deleteReiziger(Reiziger r);
	public Reiziger getReizigerbyID(int id);
	public List<Reiziger> getAllReiziger();

	

}
