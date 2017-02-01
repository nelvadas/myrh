package fr.imie.tp.myrh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.Horaire;
import fr.imie.tp.myrh.dao.model.Projet;

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
		empEntity.setBrithdate(sdf.parse("22/03/1991"));
	
		
        
        //Create  JPA project
        Projet jpaProject = new Projet();
        jpaProject.setCode("JPA001");
        jpaProject.setDescription("Introduction to JPA");
        jpaProject.setBeginDate(sdf.parse("30/01/2017"));
        jpaProject.setEndDate(sdf.parse("31/01/2017"));
        em.persist(jpaProject);
		
        //Create  JSF project
        Projet jsfProject = new Projet();
        jsfProject.setCode("JSF002");
        jsfProject.setDescription("Introduction to JPA");
        jsfProject.setBeginDate(sdf.parse("01/02/2017"));
        jsfProject.setEndDate(sdf.parse("03/02/2017"));
        em.persist(jsfProject);

        
        Horaire j1= new Horaire();
        j1.setDate(sdf.parse("30/01/2017"));
        j1.setDuree(4);
        j1.setProjet(jpaProject);
        j1.setTravailleur(empEntity);
        em.persist(j1);
        
        Horaire j2= new Horaire();
        j2.setDate(sdf.parse("01/02/2017"));
        j2.setDuree(6);
        j2.setProjet(jsfProject);
        j2.setTravailleur(empEntity);
        em.persist(j2);
        
        List<Horaire> semaine = new ArrayList<>();
        semaine.add(j1);
        semaine.add(j2);
        empEntity.setHoraires(semaine);
        
        em.persist(empEntity);
        em.flush();
		System.out.println("Utilisateur enregistré avec l'id "+empEntity.getId());
		
        
        trx.commit();
		
		//Requête2: Liste des employés
		System.out.println("\nRequête2: LISTE DES Employés");
		TypedQuery<Employe> query = em.createNamedQuery("Employe.findAll", Employe.class);
        List<Employe> result = query.getResultList();
        		
        
        for (Employe employe : result) {
			System.out.println("\nID="+employe.getId()+" Name="+employe.getFirstName() +" "+employe.getLastname()+" "+sdf.format(employe.getBrithdate()));
		}
        
		//Fermeture unité de travail
		em.close();
		emf.close();
	}

}
