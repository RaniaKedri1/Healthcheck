package com.projetdeformation.Healthcheck.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projetdeformation.Healthcheck.Entities.Patient;

public interface IServicePatient {
	public List<Patient> getAllPatients();
	public void addPatient(Patient p);  //void turn nothing 
	public void deletePatient(Integer id);
	public Patient getPatient(Integer id);
	public List<Patient> getPatientsByName(String name);
	public Page<Patient> getPatientsByName(String name , Pageable p);

}
