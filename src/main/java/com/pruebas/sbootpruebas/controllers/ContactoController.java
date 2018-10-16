package com.pruebas.sbootpruebas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pruebas.sbootpruebas.model.Contacto;
import com.pruebas.sbootpruebas.service.ContactoService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/contactform")
	private String redirectContactoForm(@RequestParam(name="id", required=false) Long id,
			Model model) {
		
		
		if( null != id)
		{
			Contacto contacto = new Contacto();
			contacto = contactoService.getContacto(id);
			model.addAttribute("contacto", contacto);
		}else 
		{
			model.addAttribute("contacto", new Contacto());
		}
		
		
		return "contactform";
	}
	
	@PostMapping("/agregarcontacto")
	private String agregarContacto(@Valid @ModelAttribute(name="contacto") Contacto contacto, 
			BindingResult bindResult,
			Model model) {
		
		if (bindResult.hasErrors()) {
			model.addAttribute("result", 0);
			return "contactform";
		} else {
			model.addAttribute("result", 1);
			contactoService.agregarContacto(contacto);
		}
		
		
//		if(null != contactoService.agregarContacto(contacto))
//		{			
//			model.addAttribute("result", 1);
//		}else {
//			model.addAttribute("result", 0);
//		}
		
		return "redirect:/contacto/vercontactos";
	}
	
	@GetMapping("/cancelar")
	public String cancelar() {
		return "redirect:/contacto/vercontactos";
	}
	
	@GetMapping("/vercontactos")
	public String verContactos(Model model, @RequestParam(defaultValue="") String name) {
		model.addAttribute("contactos", contactoService.findByNombre(name));
		return "contacts";
	}
	

	
	@GetMapping("/borrarcontacto")
	public String borrarcontacto(@RequestParam(name="id", required=true) int id) {
		contactoService.borrarContacto((long) id);
		return "redirect:/contacto/vercontactos";
	}
}
