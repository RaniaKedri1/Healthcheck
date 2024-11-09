package com.projetdeformation.Healthcheck.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.projetdeformation.Healthcheck.Dao.RendezVousRepository;
import com.projetdeformation.Healthcheck.Entities.RendezVous;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceRendezVous implements IServiceRendezVous{
	RendezVousRepository rr;

	@Override
	public List<RendezVous> getAllRendezVouss() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public void addRendezVous(RendezVous r) {
		// TODO Auto-generated method stub
		rr.save(r);

	}

	@Override
	public void deleteRendezVous(Integer id) {
		// TODO Auto-generated method stub
		rr.deleteById(id);

	}

	@Override
	public RendezVous getRendezVous(Integer id) {
		// TODO Auto-generated method stub
		 return rr.findById(id).get();
	}

	@Override
	public Page<RendezVous> getAllRendezVouss(Pageable p) {
		// TODO Auto-generated method stub
		return rr.findAll( p);

	}

	

}