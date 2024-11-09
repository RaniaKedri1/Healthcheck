package com.projetdeformation.Healthcheck.Entities;

//import java.sql.Date;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consultation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date datedeconsultation;
	private String rapportConsultation;
	private Double PrixConsultation;
@OneToOne(mappedBy = "consultation")
private RendezVous rendezVous;

}
