package com.projetdeformation.Healthcheck.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetdeformation.Healthcheck.Entities.Medecin;


public interface MedecinRepository extends JpaRepository<Medecin, Integer>{  //only CRUD 

	public List<Medecin> findByNomContains(String ra);  //derived query
	
	@Query("select m from Medecin m where m.nom like %:x%")
	public Page<Medecin> rechercheParRA (@Param ("x") String ra ,Pageable p);

}
