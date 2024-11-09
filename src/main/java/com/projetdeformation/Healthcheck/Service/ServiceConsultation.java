package com.projetdeformation.Healthcheck.Service;

import java.util.List;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projetdeformation.Healthcheck.Dao.ConsultationRepository;
import com.projetdeformation.Healthcheck.Entities.Consultation;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor


public class ServiceConsultation implements IServiceConsultation{
	ConsultationRepository cr;

	@Override
	public List<Consultation> getAllConsultations() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public void addConsultation(Consultation c) {
		// TODO Auto-generated method stub
		cr.save(c);

	}

	@Override
	public void deleteConsultation(Integer id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);

	}

	@Override
	public Consultation getConsultation(Integer id) {
		// TODO Auto-generated method stub
		 return cr.findById(id).get();
	}

	

	@Override
	public Page<Consultation> getAllConsultations( Pageable p) {
		// TODO Auto-generated method stub
		return cr.findAll( p);
	}

}
