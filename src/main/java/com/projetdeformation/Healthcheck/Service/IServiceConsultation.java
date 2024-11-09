package com.projetdeformation.Healthcheck.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projetdeformation.Healthcheck.Entities.Consultation;

public interface IServiceConsultation {
	public List<Consultation> getAllConsultations();
	public void addConsultation(Consultation c);  //void turn nothing 
	public void deleteConsultation(Integer id);
	public Consultation getConsultation(Integer id);
	
	public Page<Consultation> getAllConsultations( Pageable p);

}
