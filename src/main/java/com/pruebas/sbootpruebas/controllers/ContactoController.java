package com.pruebas.sbootpruebas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pruebas.sbootpruebas.model.Contacto;
import com.pruebas.sbootpruebas.service.ContactoService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;
	
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
	private String agregarContacto(@ModelAttribute(name="contacto") Contacto contacto, Model model) {
		
		if(null != contactoService.agregarContacto(contacto))
		{			
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/contacto/vercontactos";
	}
	
	@GetMapping("/cancelar")
	public String cancelar() {
		return "redirect:/contacto/vercontactos";
	}
	
	@GetMapping("/vercontactos")
	public ModelAndView verContactos() {
		ModelAndView mav = new ModelAndView("contacts");
		mav.addObject("contactos", contactoService.getAll());
		return mav;
	}
	
	@GetMapping("/borrarcontacto")
	public ModelAndView borrarcontacto(@RequestParam(name="id", required=true) int id) {
		contactoService.borrarContacto((long) id);
		return verContactos();
	}
}
