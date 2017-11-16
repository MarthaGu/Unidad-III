package model;

import java.io.Serializable;

public class Foro implements Serializable{
	
	
	
	private Long id;
	private String titulo;
	private String descripcion;
	private String estado;
	
	public Foro(Long id, String titulo, String descripcion, String estado) {
		
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Foro() {
		this(0L,"","","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
