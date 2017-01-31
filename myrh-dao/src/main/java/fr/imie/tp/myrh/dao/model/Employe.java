package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EMPLOYE")

@NamedQueries({
    @NamedQuery(name="Employe.findAll", query="SELECT e FROM Employe e"),
    @NamedQuery(name="Employe.findByID", query="SELECT e FROM Employe e WHERE e.id= :idVar")
})
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	/**
	 * Prenom de l'employe
	 */
	@Column(name="FIRSTNAME")
	private String firstName;

	/**
	 * Nom de l'employe
	 */
	@Column(name="LASTNAME")
	private String lastname;
	
	/**
	 * Numeros de securite sociale
	 */
	@Column(name="NSS")
	private String nss;
	
	/**
	 * Date de Naissance
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDATE")
	private Date brithdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public Date getBrithdate() {
		return brithdate;
	}

	public void setBrithdate(Date brithdate) {
		this.brithdate = brithdate;
	}
	
}
