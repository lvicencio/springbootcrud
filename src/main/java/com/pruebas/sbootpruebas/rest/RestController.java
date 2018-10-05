package com.pruebas.sbootpruebas.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

import com.pruebas.sbootpruebas.model.Contacto;
import com.pruebas.sbootpruebas.service.ContactoService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

	@Autowired
	private ContactoService contactoservice;
	
	//agregar un nuevo contacto
	@PostMapping("/contacto")
	public Contacto crearContacto(@Valid @RequestBody Contacto contacto) {
		return contactoservice.agregarContacto(contacto);
		
	}

	//todos los contactos
	@GetMapping("/contacto")
	public List<Contacto> verContactos(){
		return contactoservice.getAll();
	}
	
	//traer contacto por id
	@GetMapping("/contacto/{id}")
	public ResponseEntity<Optional<Contacto>> buscarContacto(@PathVariable(value="id") Long id )
	{
		
		//Contacto contacto = contactoservice.getContacto(id);
		Optional<Contacto> contacto = contactoservice.findById(id);
		if(contacto==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(contacto);
	}
	
	//borrar contacto por id
	@DeleteMapping("/contacto/{id}")
	public ResponseEntity<Contacto> borrarContacto(@PathVariable(value="id") Long id){
		contactoservice.borrarContacto(id);
		return ResponseEntity.ok().build();
	}
	
	//update de contacto
	@PutMapping("/contacto/{id}")
	public ResponseEntity<Contacto> editarContacto(@RequestBody Contacto contacto,
			@PathVariable(value="id") Long id )
	{
		
		Optional<Contacto> contac = contactoservice.findById(id);
		if(contac==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		contacto.setId(id);
		contactoservice.agregarContacto(contacto);
	
		return ResponseEntity.ok().body(contacto);
	}
	
}
