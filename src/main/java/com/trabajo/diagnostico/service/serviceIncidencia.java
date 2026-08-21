package com.trabajo.diagnostico.service;

import com.trabajo.diagnostico.Model.Incidencia;
import com.trabajo.diagnostico.Model.Estado;
import com.trabajo.diagnostico.repository.repositoryIncidencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class serviceIncidencia {

    @Autowired
    private repositoryIncidencia repository;

    // Crear
    public Incidencia crearincidencia(Incidencia incidencia){
        incidencia.setEstado(Estado.ABIERTA);
        incidencia.setFecha_creacion(java.time.LocalDate.now());
        return repository.save(incidencia);
    }

    // listar
    public List<Incidencia> mostrarincidencias(String estado, String prioridad, String search){
            if (estado != null || prioridad != null || search != null) {
                return repository.buscarConFiltros(estado, prioridad, search);
            }
            return repository.findAll();
    }

    // ver detalle
    public Incidencia mostrarporuna(int id){
        return repository.findById(id).orElse(null);
    }

    // editar
    public Incidencia modificar(int id, Incidencia incidenciaActualizada){
        return repository.findById(id).map(existente -> {
            existente.setTitulo(incidenciaActualizada.getTitulo());
            existente.setDescripcion(incidenciaActualizada.getDescripcion());
            existente.setCategoria(incidenciaActualizada.getCategoria());
            existente.setPrioridad(incidenciaActualizada.getPrioridad());
            if (incidenciaActualizada.getEstado() != null) {
                existente.setEstado(incidenciaActualizada.getEstado());
            }
            return repository.save(existente);
        }).orElse(null);
    }

    // eliminar
    public boolean eliminar(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    // Contar por estado
    public Map<String, Long> obtenerContadores() {
            Map<String, Long> stats = new HashMap<>();
            stats.put("ABIERTA", repository.countByEstado("ABIERTA"));
            stats.put("EN_PROGRESO", repository.countByEstado("EN_PROGRESO"));
            stats.put("RESUELTA", repository.countByEstado("RESUELTA"));
            return stats;
        }

}
