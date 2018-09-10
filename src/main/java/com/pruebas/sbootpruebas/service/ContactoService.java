package com.pruebas.sbootpruebas.service;

import java.util.List;

import com.pruebas.sbootpruebas.model.Contacto;

public interface ContactoService {

	Contacto agregarContacto(Contacto contacto);
	Contacto findOne(Long id);
	Contacto editarContacto(Contacto contacto);
	void borrarContacto(Long id);
	List<Contacto> getAll();
	Contacto getContacto(Long id);
	List<Contacto> findByNombre(String name);
}
