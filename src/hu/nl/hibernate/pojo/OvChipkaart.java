package hu.nl.hibernate.pojo;

import java.sql.Date;

import javax.persistence.*;
@Entity
@Table(name="OV_CHIPKAART")
public class OvChipkaart {
	//tutorial from https://www.tutorialspoint.com/hibernate/
	//class location is saved in the hibernate.cfg file
	//shows the primary key
	@Id
	@Column(name="KAARTNUMMER")
	private int kaartnummer;
	//indicates a column of the table
	@Column(name="GELDIGTOT")
	private Date geldigtot;
	@Column(name="KLASSE")
	private int klasse;
	@Column(name="SALDO")
	private double saldo;
	//this function automatically loads the corrosponding Reiziger list into this class if called
	@ManyToOne
    @JoinColumn(name = "reizigerid")
	private Reiziger reiziger;
	public OvChipkaart() {}

	public int getKaartnummer() {
		return kaartnummer;
	}

	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}

	public Date getGeldigtot() {
		return geldigtot;
	}

	public void setGeldigtot(Date geldigtot) {
		this.geldigtot = geldigtot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double isSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "OvChipkaart [kaartnummer=" + kaartnummer + ", geldigtot=" + geldigtot + ", klasse=" + klasse
				+ ", saldo=" + saldo + "]";
	}
	
	
	
}
