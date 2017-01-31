package fr.imie.tp.myrh.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

public class EmployeDAOImpl implements IEmployeDAO {
	
	EntityManager em;

	
	 public EmployeDAOImpl(){
		 // Don't forget to instanciate your entity manager :)
	 }
	 
	 
	@Override
	public Collection<Employe> getAllEmploye() {
		Collection<Employe> emps = em.createNamedQuery("Employe.findAll",Employe.class).getResultList();
		return emps;
	}

}
