package com.trabajo.diagnostico.repository;

import com.trabajo.diagnostico.Model.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface repositoryIncidencia extends JpaRepository<Incidencia, Integer> {

}
