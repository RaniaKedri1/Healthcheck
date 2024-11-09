package com.projetdeformation.Healthcheck.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.projetdeformation.Healthcheck.Entities.RendezVous;

public interface IServiceRendezVous {
	public List<RendezVous> getAllRendezVouss();
	public void addRendezVous(RendezVous r);  //void turn nothing 
	public void deleteRendezVous(Integer id);
	public RendezVous getRendezVous(Integer id);
	
	public Page<RendezVous> getAllRendezVouss( Pageable p);

}
