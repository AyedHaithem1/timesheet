package tn.esprit.spring;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;


@RunWith(SpringRunner.class)
@SpringBootTest


public class EmployeServiceApplicationTest{

	@Autowired 
	IEmployeService us; 

	@Test
	public void addOrUpdateEmploye()  {
		Employe employe= new Employe("chames", "chames", "Haithem.aayed@gmail.com", "123", false, Role.ADMINISTRATEUR);
		Employe employeAdded= us.addOrUpdateEmploye(employe);
		assertEquals(employe.getNom(),employeAdded.getNom());
	}
	
	@Test
	public void testUpdateEmploye()  {
		Employe employe= new Employe("chames", "chames", "chames.aayed@gmail.com", "123", false, Role.ADMINISTRATEUR);
		Employe employeAdded= us.UpdateEmploye(employe);
		assertEquals(employe.getNom(),employeAdded.getPrenom());
	}
	
	@Test
	public void testGetAllEmployes() {
		 
		 List<Employe> listEmployes = us.getAllEmployes();
		
		 // if there are 5 users in DB : 
		//assertEquals(20, listEmployes.size());
			 us.getAllEmployes();

	}

	@Test
	public void testDeleteEmployeById()
	{
		
		 us.deleteeEmployeById(2);
			
			assertEquals(0, 2);
	}
    
	@Test
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = us.retrieveAllEmployes(); 
		 
		assertEquals(4, listEmployes.size());
	} 
}


