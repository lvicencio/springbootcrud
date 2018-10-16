package com.pruebas.sbootpruebas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

/*	@GetMapping("/")
	//@RequestMapping(value="/", method=RequestMethod.GET)
	public String redirectLogin() {
		return "redirect:/login";
	}*/
	
	
	@GetMapping("/login")
	public String verLoginFormulario(Model model,
			@RequestParam(name="error",  required= false) String error,
			@RequestParam(name="logout",  required= false) String logout
			) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";
		
	}
	
/*	@GetMapping("/login")
	public String verLoginFormulario(Model model,
			@RequestParam(name="error",  required= false) String error,
			@RequestParam(name="logout",  required= false) String logout
			) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredential());
		return "login";
		
	}*/
	
/*	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential ) {
		
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user") ) {
			return "redirect:/contacto/vercontactos";
		}
		
		return "redirect:/login?error";
	}*/
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {
		return "redirect:/contacto/vercontactos";
	}
	
	
}
