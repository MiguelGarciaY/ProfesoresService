package com.idat.ProfesoresServicio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesores;
	private String descripcion;
	public Integer getIdProfesores() {
		return idProfesores;
	}
	public void setIdProfesores(Integer idProfesores) {
		this.idProfesores = idProfesores;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
