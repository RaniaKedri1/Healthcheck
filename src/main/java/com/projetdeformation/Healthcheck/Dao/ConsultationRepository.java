package com.projetdeformation.Healthcheck.Dao;





import org.springframework.data.jpa.repository.JpaRepository;

import com.projetdeformation.Healthcheck.Entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer>{  //only CRUD 



}
