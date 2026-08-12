package com.trabajo.diagnostico.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Incidencia")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identificador;

    @NonNull
    private String titulo;

    @NonNull
    private String descripcion;
 
    @NonNull
    private String categoria;
 
    @NonNull
    private String prioridad;
 
    @NonNull
    private String estado;
 

    private LocalDate fecha_creacion;
}