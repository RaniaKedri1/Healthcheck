package com.projetdeformation.Healthcheck.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetdeformation.Healthcheck.Entities.Consultation;
import com.projetdeformation.Healthcheck.Service.ServiceConsultation;

import lombok.AllArgsConstructor;
//import com.projetdeformation.Healthcheck.Service.ServiceConsultation;

@Controller
@AllArgsConstructor
public class ConsultationController {
 ServiceConsultation sc;

@GetMapping("/indexConsultation")
public String getAllConsultation(
		@RequestParam(defaultValue ="") String mc,
							@RequestParam(defaultValue ="0") int page,
							@RequestParam(defaultValue = "5")int size, Model m )
{
	Page<Consultation> pagesConsultation=sc.getAllConsultations( PageRequest.of(page, size));
	m.addAttribute("data", pagesConsultation.getContent());
	m.addAttribute("mc" ,mc);
	m.addAttribute("pages",new int[pagesConsultation.getTotalPages()]);
	m.addAttribute("currentpage", page);
	return "vueC";
	
}
@GetMapping("/deleteC/{id}") //suppression 
public String deleteConsultation(@PathVariable Integer id)  
{
	sc.deleteConsultation(id);
	return "redirect:/indexConsultation"; //call index again
}

@GetMapping("/formajoutC")
public String ajoutConsultation(Model m)
{
	m.addAttribute("Consultation" ,new Consultation()); //add an empty patient
	return "ajouterC";
}
@PostMapping("/ajouterC")
public String ajouterConsultation(@ModelAttribute Consultation c) 
{
	sc.addConsultation(c);
	return "redirect:/indexConsultation";
}
@GetMapping("/modifierC/{id}") 
public String modifierConsultation(@PathVariable Integer id ,Model m)  
{
	Consultation consultation=sc.getConsultation(id);
	m.addAttribute("consultation", consultation);
	return "ajouterC";
	
}


}
