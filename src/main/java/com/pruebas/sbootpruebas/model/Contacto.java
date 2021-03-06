package com.pruebas.sbootpruebas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="contacto")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3, max=20)
	private String nombre;
	
	@NotNull
	@Size(min=3, max=20)
	private String apellido;
	
	@NotNull
	@Size(min=3, max=20)
	private String fono;
	
	@NotNull
	@Size(min=3, max=20)
	private String ciudad;
	
	public Contacto() {}
	
	 

	public Contacto(Long id, String nombre, String apellido, String fono, String ciudad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fono = fono;
		this.ciudad = ciudad;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	
	
	
	
	
}
