package hu.nl.hibernate.dao;

import java.util.ArrayList;
import hu.nl.hibernate.pojo.OvChipkaart;

public interface OvChipkaartDaoImpl {
	public OvChipkaart getKaartById(int id);
	public boolean saveKaart(OvChipkaart ov);
	public boolean updateKaart(OvChipkaart ov);
	public boolean deleteKaart(OvChipkaart ov);
	public ArrayList<OvChipkaart> getAllKaart();
}
