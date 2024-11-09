package com.projetdeformation.Healthcheck.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetdeformation.Healthcheck.Entities.Patient;


public interface PatientRepository  extends JpaRepository<Patient, Integer>{  //only CRUD 

public List<Patient> findByNomContains(String ra);  //derived query
	
	@Query("select p from Patient p where p.nom like %:x%")
	public Page<Patient> rechercheParRA (@Param ("x") String ra ,Pageable p);

}
