package com.cursoceat.main;

public class Contactos {
	
	// Atributos
	private String nombre;
	private String telefono;
	
	// Métodos constructores
	// Al heredar contactos necesito el constructor vacío
	public Contactos() {
	}

	public Contactos(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Contactos(String nombre) {
		this.nombre = nombre;
	}

	// Métodos Setter y Getter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {

		this.telefono = telefono;
	}
	
	
	
	
}
