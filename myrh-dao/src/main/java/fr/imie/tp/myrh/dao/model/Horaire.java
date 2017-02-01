package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_HORAIRE")

@NamedQueries({
    @NamedQuery(name="Horaire.findAll", query="SELECT h FROM Horaire h"),
})
public class Horaire implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE")
	private Date date;

	
	@Column(name="DURATION")
	private int duree;


	
	//Relations
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employe travailleur;
	
	
	
	@ManyToOne
	@JoinColumn(name="PRJ_ID")
	private Projet projet ;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public Employe getTravailleur() {
		return travailleur;
	}


	public void setTravailleur(Employe travailleur) {
		this.travailleur = travailleur;
	}


	public Projet getProjet() {
		return projet;
	}


	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
}
