package com.trabajo.diagnostico.controller;

import org.springframework.web.bind.annotation.RestController;

import com.trabajo.diagnostico.Model.Incidencia;
import com.trabajo.diagnostico.service.serviceIncidencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;



@RestController
@RequestMapping("/api/incidencia")

public class controllerincidencia {

    @Autowired
    private serviceIncidencia service;

    @PostMapping
    public ResponseEntity<Incidencia> crearincidencia(@RequestBody Incidencia incidencia){
        System.out.println("[controllerincidencia] => crearincidencia");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearincidencia(incidencia));
    }

    @GetMapping
    public ResponseEntity<List<Incidencia>> mostrarinidencias(){
        System.out.println("mostrando todas las incidencias");
        List<Incidencia> incidencias = service.mostrarincidencias();
        return ResponseEntity.ok(incidencias);
    }    


    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> mostrarpordetalle(@PathVariable int id){
        System.out.println("Mostrando detalle de incidencia");
        Incidencia incidencia = service.mostrarporuna(id);
        if(incidencia == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(incidencia);
    }

    @PutMapping
    public ResponseEntity<Incidencia> modificar(@RequestBody Incidencia incidencia){
        Incidencia modificada = service.modificar(incidencia);

        if(modificada == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(modificada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }




    
}
