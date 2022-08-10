package com.idat.ProfesoresServicio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ProfesoresServicio.dto.ProfesoresDTO;
import com.idat.ProfesoresServicio.entity.Profesores;
import com.idat.ProfesoresServicio.repository.ProfesoresRepository;


@Service
public class ProfesoresServiceImpl implements ProfesoresService{

	@Autowired
	private ProfesoresRepository repository;
	@Override
	public void guardarProfesores(ProfesoresDTO profesoresDto) {
		Profesores profesores=new Profesores();
		profesores.setDescripcion(profesoresDto.getDescripcionProfesores());		
		repository.save(profesores);
		
	}

	@Override
	public void actualizarProfesores(ProfesoresDTO profesoresDto) {
		Profesores profesores=new Profesores();
		profesores.setIdProfesores(profesoresDto.getId());
		profesores.setDescripcion(profesoresDto.getDescripcionProfesores());	
		
		repository.saveAndFlush(profesores);
		
	}

	@Override
	public void eliminarProfesores(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<ProfesoresDTO> listar() {
		// TODO Auto-generated method stub
		List<ProfesoresDTO> listar=new ArrayList<>();
		ProfesoresDTO dto=null;
		List<Profesores> b=repository.findAll();
		
		for(Profesores profesores:b) {
			dto=new ProfesoresDTO();
			dto.setId(profesores.getIdProfesores());
			dto.setDescripcionProfesores(profesores.getDescripcion());			

			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public ProfesoresDTO obtenerProfesoresId(Integer id) {
		// TODO Auto-generated method stub
		Profesores profesores=repository.findById(id).orElse(null);
		ProfesoresDTO dto=null;
		dto=new ProfesoresDTO();
		dto.setId(profesores.getIdProfesores());
		dto.setDescripcionProfesores(profesores.getDescripcion());		
		return dto;
	}

}
