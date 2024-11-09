package com.projetdeformation.Healthcheck.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projetdeformation.Healthcheck.Dao.PatientRepository;
import com.projetdeformation.Healthcheck.Entities.Patient;

import lombok.AllArgsConstructor;
@Service 
@AllArgsConstructor
public class ServicePatient implements IServicePatient {
 PatientRepository pr;
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public void addPatient(Patient p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void deletePatient(Integer id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

	@Override
	public Patient getPatient(Integer id) {
		// TODO Auto-generated method stub
		 return pr.findById(id).get();
	}

	@Override
	public List<Patient> getPatientsByName(String name) {
		// TODO Auto-generated method stub
		return pr.findByNomContains(name);	}

	@Override
	public Page<Patient> getPatientsByName(String name, Pageable p) {
		// TODO Auto-generated method stub
		return pr.rechercheParRA(name, p);
	}

}
