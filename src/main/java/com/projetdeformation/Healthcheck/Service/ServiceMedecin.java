package com.projetdeformation.Healthcheck.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projetdeformation.Healthcheck.Dao.MedecinRepository;
import com.projetdeformation.Healthcheck.Entities.Medecin;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceMedecin implements  IServiceMedecin{
	MedecinRepository mr ;

	@Override
	public List<Medecin> getAllMedecins() {
		// TODO Auto-generated method stub
		return mr.findAll();
	}

	@Override
	public void addMedecin(Medecin m) {
		// TODO Auto-generated method stub
		mr.save(m);

	}

	@Override
	public void deleteMedecin(Integer id) {
		// TODO Auto-generated method stub
		mr.deleteById(id);

	}

	@Override
	public Medecin getMedecin(Integer id) {
		// TODO Auto-generated method stub
		 return mr.findById(id).get();
	}

	@Override
	public List<Medecin> getMedecinsByName(String name) {
		// TODO Auto-generated method stub
		return mr.findByNomContains(name);	
	}

	@Override
	public Page<Medecin> getMedecinsByName(String name, Pageable p) {
		// TODO Auto-generated method stub
		return mr.rechercheParRA(name, p);
	}

}
