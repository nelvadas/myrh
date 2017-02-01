package fr.imie.tp.myrh.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

public class EmployeDAOImpl2Test {

	static IEmployeDAO _employeDAOService ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		_employeDAOService = new EmployeDAOImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetAllEmploye() {
		List<Employe> emps = (List<Employe>) _employeDAOService.getAllEmploye();
		assertNotNull(emps);
		assertEquals(1, emps.size());
		assertEquals("Prenom incorrect","Antoine",emps.get(0).getFirstName());
	}

	
	
	
}
