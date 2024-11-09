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

import com.projetdeformation.Healthcheck.Entities.RendezVous;
import com.projetdeformation.Healthcheck.Service.ServiceRendezVous;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RendezVousController {
	
	 ServiceRendezVous sr;

	@GetMapping("/indexR")
	public String getAllRendezVous(
			@RequestParam(defaultValue ="") String mc,
								@RequestParam(defaultValue ="0") int page,
								@RequestParam(defaultValue = "5")int size, Model m )
	{
		Page<RendezVous> pagesRendezVous=sr.getAllRendezVouss( PageRequest.of(page, size));
		m.addAttribute("data", pagesRendezVous.getContent());
		m.addAttribute("mc" ,mc);
		m.addAttribute("pages",new int[pagesRendezVous.getTotalPages()]);
		m.addAttribute("currentpage", page);
		return "vueR";
		
	}
	@GetMapping("/deleteR/{id}") //suppression 
	public String deleteRendezVous(@PathVariable Integer id)  
	{
		sr.deleteRendezVous(id);
		return "redirect:/indexR"; //call index again
	}

	@GetMapping("/formajoutR")
	public String ajouterRendezVous(Model m)
	{
		m.addAttribute("RendezVous" ,new RendezVous() ); //add an empty patient
		return "ajouterR";
	}
	@PostMapping("/ajouterR")
	public String ajouterRendezVous(@ModelAttribute RendezVous r) 
	{
		sr.addRendezVous(r);
		return "redirect:/indexR";
	}
	@GetMapping("/modifierR/{id}") 
	public String modifierRendezVous(@PathVariable Integer id ,Model m)  
	{
		RendezVous RendezVous=sr.getRendezVous(id);
		m.addAttribute("RendezVous", RendezVous);
		return "ajouterR";
		
	}

	}

