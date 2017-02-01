package fr.imie.tp.myrh.dao.impl;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

public class EmployeDAOImplTest {
	
	IEmployeDAO _employeDaoService= new EmployeDAOImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Test
	public void testGetAllEmploye() {
		Collection<Employe> emps = _employeDaoService.getAllEmploye();
		assertNotNull(emps);
	}

}
