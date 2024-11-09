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
import com.projetdeformation.Healthcheck.Entities.Medecin;
//import com.projetdeformation.Healthcheck.Service.IServiceMedecin;
import com.projetdeformation.Healthcheck.Service.ServiceMedecin;

import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor
public class MedecinController {
	 ServiceMedecin sm;
	
	@GetMapping("/indexM")
	public String getAllMedecin(@RequestParam(defaultValue ="") String mc,
								@RequestParam(defaultValue ="0") int page,
								@RequestParam(defaultValue = "6")int size
			,Model m)
	{
		Page<Medecin> pagesMedecin=sm.getMedecinsByName(mc ,PageRequest.of(page, size));
		m.addAttribute("data", pagesMedecin.getContent());
		m.addAttribute("mc" ,mc);
		m.addAttribute("pages",new int[pagesMedecin.getTotalPages()]);
		m.addAttribute("currentpage", page);
		return "vueM";
		
	}
	@GetMapping("/deleteM/{id}") //suppression 
	public String deleteMedecin(@PathVariable Integer id)  
	{
		sm.deleteMedecin(id);
		return "redirect:/indexM"; //call index again
	}
	
	@GetMapping("/formajoutM")
	public String ajoutMedecin(Model m)
	{
		m.addAttribute("Medecin" ,new Medecin()); //add an empty Medecin
		return "ajouterM";
	}
	@PostMapping("/ajouterM")
	public String ajouterMedecin(@ModelAttribute Medecin me) 
	{
		sm.addMedecin(me);
		return "redirect:/indexM";
	}
	@GetMapping("/modifierM/{id}") 
	public String modifierMedecin(@PathVariable Integer id ,Model m)  
	{
		Medecin medecin=sm.getMedecin(id);
		m.addAttribute("medecin", medecin);
		return "ajouterM";
	}


}
