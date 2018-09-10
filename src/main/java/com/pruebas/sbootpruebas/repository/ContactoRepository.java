package com.pruebas.sbootpruebas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.sbootpruebas.model.Contacto;


@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>{

	List<Contacto> findByNombreLike(String name);

}
