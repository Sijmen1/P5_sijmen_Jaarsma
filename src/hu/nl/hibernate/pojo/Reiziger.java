package hu.nl.hibernate.pojo;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="reiziger")
//tutorial from https://www.tutorialspoint.com/hibernate/
//class location is saved in the hibernate.cfg file
public class Reiziger {
	//Primary key, as indicated with the id tag
	@Id
	@Column(name = "reizigerid")
	private int reizigerid;
	//column key indicates that this is a column in the main table 
	@Column(name = "voorletters")
	private String voorletters;
	@Column(name = "tussenvoegsel")
	private String tussenvoegsel;
	@Column(name = "achternaam")
	private String achternaam;
	@Column(name = "gebortedatum")
	private Date gebortedatum;
	//this explains to the oracle database that it is a one to many relation, The eager type is selected by fetch becaue my version of java couldn't comprehend the lazy type of fetch.
	//this specific annotation Is made with aid by Gillaume, as I could not figure it out
	@OneToMany(mappedBy = "reiziger", fetch = FetchType.EAGER , cascade=CascadeType.ALL)
	private List<OvChipkaart> ovChipKaarten;
	
	public Reiziger(String voorletters, String tussenvoegsel, String achternaam, Date gebortedatum) {
		super();
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gebortedatum = gebortedatum;
	}
	public Reiziger(int reizigerid, String voorletters, String tussenvoegsel, String achternaam, Date gebortedatum) {
		super();
		this.reizigerid = reizigerid;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gebortedatum = gebortedatum;
	}
	public Reiziger() {
	}
	public int getReizigerid() {
		return reizigerid;
	}
	public void setReizigerid(int reizigerid) {
		this.reizigerid = reizigerid;
	}
	public String getVoorletters() {
		return voorletters;
	}
	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public Date getGebortedatum() {
		return gebortedatum;
	}
	public void setGebortedatum(Date gebortedatum) {
		this.gebortedatum = gebortedatum;
	}
	
	public List<OvChipkaart> getOvChipKaarten() {
		return ovChipKaarten;
	}	public void setOvChipKaarten(List<OvChipkaart> ovChipKaarten) {
		this.ovChipKaarten = ovChipKaarten;
	}
	@Override
	public String toString() {
		return "Reiziger [reizigerid=" + reizigerid + ", tussenvoegsel=" + tussenvoegsel + ", achternaam=" + achternaam
				+ ", gebortedatum=" + gebortedatum + "] \n" ;
	}
	
	
	
}
