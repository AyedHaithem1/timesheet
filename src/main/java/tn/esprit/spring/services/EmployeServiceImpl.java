package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements IEmployeService {
	
	private static final Logger log = LogManager.getLogger(EmployeServiceImpl.class);	
	@Autowired
	EmployeRepository employeRepository;

	@Autowired
	DepartementRepository DepartementRepository;

	
	public Employe addOrUpdateEmploye(Employe employe) {
		
	
		log.info("In  addemploye : " + employe); 
		

		Employe userSaved = employeRepository.save(employe);

		log.info("Out of  addUser. "); 
		return userSaved; 

	}

	
	public Employe UpdateEmploye(Employe employe) {
		log.info("In  addemploye : " + employe); 
		Employe userSaved = employeRepository.save(employe);
		log.info("Out of  Update modifiy. "); 
		return employeRepository.save(employe); 
	}
	

	public void mettreAjourEmailByEmployeId(String email, int employeId) {

		Employe employe = employeRepository.findById(employeId).get();
		employe.setEmail(email);
		employeRepository.save(employe);

	}

	public String getEmployePrenomById(int employeId) {
		
		Employe employeManagedEntity = employeRepository.findById(employeId).get();
		return employeManagedEntity.getPrenom();
	}


	public List<Employe> getAllEmployes() {
		log.info("addOrUpdateEmploye : " ); 

		return (List<Employe>) employeRepository.findAll();
	}

/*	@Override
	public Employe addOrUpdateEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return null;
	}*/
	@Override
	public int deleteeEmployeById(int employeId)
	{
		log.debug("methode deleteEmployeById ");
		
		try {
		Employe employe = employeRepository.findById(employeId).orElse(null);

		employeRepository.delete(employe);
		return -1;}
		catch (Exception e) {
			log.error("erreur methode deleteEmpolyeById : " +e);
			return 0;
		}	
	}	
	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes = null;
	
		log.info("In  retrieveAllEmployes : "); 
		 employes = (List<Employe>) employeRepository.findAll();
		for (Employe employe : employes) {
			log.debug("employe +++ : " +employe);
		}
		log.info("Out of retrieveAllUsers.");
		
		
		return employes;
	}



}
