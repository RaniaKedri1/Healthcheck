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

import com.projetdeformation.Healthcheck.Entities.Patient;
import com.projetdeformation.Healthcheck.Service.IServicePatient;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class PatientController {
private  IServicePatient sp ;
	
	@GetMapping("/index")
	public String getAllPatient(@RequestParam(defaultValue ="") String mc,
								@RequestParam(defaultValue ="0") int page,
								@RequestParam(defaultValue = "6")int size
			,Model m)
	{
		Page<Patient> pagesPatient=sp.getPatientsByName(mc ,PageRequest.of(page, size));
		m.addAttribute("data", pagesPatient.getContent());
		m.addAttribute("mc" ,mc);
		m.addAttribute("pages",new int[pagesPatient.getTotalPages()]);
		m.addAttribute("currentpage", page);
		return "vueP";
		
	}
	@GetMapping("/deleteP/{id}") //suppression 
	public String deletePatient(@PathVariable Integer id)  
	{
		sp.deletePatient(id);
		return "redirect:/index"; //call index again
	}
	
	@GetMapping("/formajoutP")
	public String ajoutPatient(Model m)
	{
		m.addAttribute("patient" ,new Patient()); //add an empty patient
		return "ajouterP";
	}
	@PostMapping("/ajouterP")
	public String ajouterPatient(@ModelAttribute Patient p) 
	{
		sp.addPatient(p);
		return "redirect:/index";
	}
	@GetMapping("/modifierP/{id}") 
	public String modifierPatient(@PathVariable Integer id ,Model m)  
	{
		Patient patient=sp.getPatient(id);
		m.addAttribute("patient", patient);
		return "ajouterP";
		
	}


}
