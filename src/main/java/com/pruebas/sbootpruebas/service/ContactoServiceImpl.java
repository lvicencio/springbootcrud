package com.pruebas.sbootpruebas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebas.sbootpruebas.model.Contacto;
import com.pruebas.sbootpruebas.repository.ContactoRepository;

@Service
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;
	
	@Override
	public Contacto agregarContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		return contactoRepository.save(contacto);
	}


	@Override
	public Contacto editarContacto(Contacto contacto) {
		// TODO Auto-generated method stub
		return contactoRepository.save(contacto);
	}

	@Override
	public void borrarContacto(Long id) {
		// TODO Auto-generated method stub
		contactoRepository.deleteById(id);
		
	}

	@Override
	public List<Contacto> getAll() {
		// TODO Auto-generated method stub
		return contactoRepository.findAll();
	}


	

	@Override
	public Contacto findOne(Long id) {
//		// TODO Auto-generated method stub
		Object buscado;
		buscado = contactoRepository.findById(id);
	return  (Contacto) buscado;
	}


	@Override
	public Contacto getContacto(Long id) {
		// TODO Auto-generated method stub
		return contactoRepository.getOne(id);
	}


	@Override
	public List<Contacto> findByNombre(String name) {
		// TODO Auto-generated method stub
		return contactoRepository.findByNombreLike("%"+name+"%");
	}


	

	
}
