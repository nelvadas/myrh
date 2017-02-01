package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PROJET")

@NamedQueries({
    @NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p"),
})
public class Projet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="CODE")
	private String code;

	@Column(name="DESCRIPTION")
	private String description;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="BEGIN_DATE")
	private Date beginDate;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	
	//Relations
	//1 relation Projet et Horaire
	@OneToMany(mappedBy="projet")
	private List<Horaire>heures;
		
	
	public List<Horaire> getHeures() {
		return heures;
	}

	public void setHeures(List<Horaire> heures) {
		this.heures = heures;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
