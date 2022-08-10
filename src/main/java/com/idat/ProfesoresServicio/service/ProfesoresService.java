package com.idat.ProfesoresServicio.service;

import java.util.List;

import com.idat.ProfesoresServicio.dto.ProfesoresDTO;


public interface ProfesoresService {
	void guardarProfesores(ProfesoresDTO profesores);
	void actualizarProfesores(ProfesoresDTO profesores);
	void eliminarProfesores(Integer id);	
	List<ProfesoresDTO>listar();
	ProfesoresDTO obtenerProfesoresId(Integer id);
}
