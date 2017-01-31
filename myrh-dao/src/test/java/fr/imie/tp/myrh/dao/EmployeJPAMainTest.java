package fr.imie.tp.myrh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.imie.tp.myrh.dao.model.Employe;

public class EmployeJPAMainTest {

	public static void main(String[] args) throws ParseException {

		//Utilitaire Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Création d'une unité de travail
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
			EntityManager em = emf.createEntityManager();
		
		
		
		//Requête1: Insertion d'un employe
		System.out.println("\nRequête1: CREATION D'UN EMPLOYE");
		EntityTransaction trx= em.getTransaction();
		trx.begin();
		
		Employe empEntity= new Employe();
		empEntity.setFirstName("Antoine");
		empEntity.setLastname("Griezmann");
		empEntity.setNss("1234567890");
		empEntity.setBrithdate(sdf.parse("21/03/1991"));
	
		em.persist(empEntity);
		System.out.println("Utilisateur enregistré avec l'id "+empEntity.getId());
		trx.commit();
		
		//Requête2: Liste des employés
		System.out.println("\nRequête2: LISTE DES Employés");
		TypedQuery<Employe> query = em.createNamedQuery("Employe.findAll", Employe.class);
        List<Employe> result = query.getResultList();
        for (Employe employe : result) {
			System.out.println("\nID="+employe.getId()+" Name="+employe.getFirstName() +" "+employe.getLastname()+" "+sdf.format(employe.getBrithdate()));
		}
        
        System.out.println("\nRequête2: LISTE DES Employés");
		
		
		//Fermeture unité de travail
		em.close();
		emf.close();
	}

}
