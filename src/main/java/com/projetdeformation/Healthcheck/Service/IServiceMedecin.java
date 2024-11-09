package com.projetdeformation.Healthcheck.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projetdeformation.Healthcheck.Entities.Medecin;

public interface IServiceMedecin {

	public List<Medecin> getAllMedecins();
	public void addMedecin(Medecin m);  //void turn nothing 
	public void deleteMedecin(Integer id);
	public Medecin getMedecin(Integer id);
	public List<Medecin> getMedecinsByName(String name);
	public Page<Medecin> getMedecinsByName(String name , Pageable p);

}
