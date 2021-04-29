package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;


public interface IEmployeService {
	
	public void mettreAjourEmailByEmployeId(String email, int employeId);
	public Employe addOrUpdateEmploye(Employe employe);
	public Employe UpdateEmploye(Employe employe);
	public String getEmployePrenomById(int employeId);
	public List<Employe> getAllEmployes();
	int deleteeEmployeById(int employeId);
	List<Employe> retrieveAllEmployes();

}
