package fr.imie.tp.myrh.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class ApplicationResources {
    @Produces
    @PersistenceContext(unitName = "myRhPersistenceUnit")
    private EntityManager em;
}