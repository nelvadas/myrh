package fr.imie.tp.myrh.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

public class EmployeDAOImpl implements IEmployeDAO {
	Logger logger = Logger.getLogger(EmployeDAOImpl.class);
	
	EntityManager em;


	public EmployeDAOImpl(){
		 // Don't forget to instanciate your entity manager :)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
		 
	 }
	 
	 
	@Override
	public Collection<Employe> getAllEmploye() {
		
		TypedQuery<Employe> query = em.createNamedQuery("Employe.findAll", Employe.class);
        List<Employe> result = query.getResultList();
		return result;
	}
	
	
	 public EntityManager getEm() {
			return em;
		}


		public void setEm(EntityManager em) {
			this.em = em;
		}

		

}
