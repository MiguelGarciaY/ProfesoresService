package com.idat.ProfesoresServicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.ProfesoresServicio.dto.ProfesoresDTO;
import com.idat.ProfesoresServicio.service.ProfesoresService;


@Controller
@RequestMapping("/profesores/v1")
public class ProfesoresController {
	@Autowired
	private ProfesoresService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ProfesoresDTO>> listar() {
		return new ResponseEntity<List<ProfesoresDTO>>(service.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProfesoresDTO profesores) {
		service.guardarProfesores(profesores);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ProfesoresDTO p=service.obtenerProfesoresId(id);
		if(p != null) {
			service.eliminarProfesores(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ProfesoresDTO profesores) {
		ProfesoresDTO p=service.obtenerProfesoresId(profesores.getId());
		
		if(p != null) {
			service.actualizarProfesores(profesores);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProfesoresDTO> obtenerID(@PathVariable Integer id) {
		ProfesoresDTO p=service.obtenerProfesoresId(id);
		
		if(p != null) {			
			return new ResponseEntity<ProfesoresDTO>(service.obtenerProfesoresId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<ProfesoresDTO>(HttpStatus.NOT_FOUND);
	}
}
