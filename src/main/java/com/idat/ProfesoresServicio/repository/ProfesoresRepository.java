package com.idat.ProfesoresServicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ProfesoresServicio.entity.Profesores;

@Repository
public interface ProfesoresRepository extends JpaRepository<Profesores, Integer>{

}
