package com.trabajo.diagnostico.controller;

import com.trabajo.diagnostico.Model.Incidencia;
import com.trabajo.diagnostico.service.serviceIncidencia;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/incidencias")
@CrossOrigin(origins = "*") // Permite la integración con el Fronend
public class controllerincidencia {

    @Autowired
    private serviceIncidencia service;

    @PostMapping
    public ResponseEntity<Incidencia> crearincidencia(@Valid @RequestBody Incidencia incidencia){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearincidencia(incidencia));
    }

    @GetMapping
    public ResponseEntity<List<Incidencia>> mostrarinidencias(
        @RequestParam(required = false) String estado,
            @RequestParam(required = false) String prioridad,
            @RequestParam(required = false) String search) {
        List<Incidencia> incidencias = service.mostrarincidencias(estado, prioridad, search);
        return ResponseEntity.ok(incidencias);
    }    


    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> mostrarpordetalle(@PathVariable int id){
        Incidencia incidencia = service.mostrarporuna(id);
        if(incidencia == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(incidencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidencia> modificar(@PathVariable int id,@Valid @RequestBody Incidencia incidencia){
        incidencia.setIdentificador(id);
        Incidencia modificada = service.modificar(id,incidencia);
        if(modificada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modificada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        boolean eliminado = service.eliminar(id);
        if(!eliminado){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Long>> obtenerEstadisticas() {
        return ResponseEntity.ok(service.obtenerContadores());
    }

    
}
