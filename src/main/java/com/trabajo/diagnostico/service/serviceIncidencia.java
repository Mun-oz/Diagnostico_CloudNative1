package com.trabajo.diagnostico.service;
import com.trabajo.diagnostico.Model.Incidencia;
import com.trabajo.diagnostico.repository.repositoryIncidencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class serviceIncidencia {

    @Autowired
    private repositoryIncidencia repository;

    // Crear
    public Incidencia crearincidencia(Incidencia incidencia){
        incidencia.setEstado("ABIERTA");
        incidencia.setFecha_creacion(java.time.LocalDate.now());

        return repository.save(incidencia);
    }

    // listar
    public List<Incidencia> mostrarincidencias(){
        return repository.findAll();
    }

    // ver detalle
    public Incidencia mostrarporuna(int id){
        return repository.findById(id).orElse(null);
    }

    // editar
    public Incidencia modificar(Incidencia incidencia){
        if(repository.existsById(incidencia.getIdentificador())){
            return repository.save(incidencia);
        }
        return null;
    }

    // eliminar
    public boolean eliminar(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
