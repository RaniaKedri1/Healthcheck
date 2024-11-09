package com.projetdeformation.Healthcheck.Entities;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	
public class RendezVous {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date dateRendezVous;
@ManyToOne
private Medecin medecin;
@ManyToOne
private Patient patient;
@ManyToOne
private Consultation consultation;

}
