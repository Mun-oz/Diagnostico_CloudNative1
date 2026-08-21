package com.trabajo.diagnostico.dto;

import com.trabajo.diagnostico.Model.Prioridad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IncidenciaDTO {

    @NotBlank(message = "el titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "la descripcion es obligatoria")
    private String descripcion;

    @NotBlank(message = "la categoria es obligatoria")
    private String categoria;

    @NotNull(message = "la prioridad es obligatoria")
    private Prioridad prioridad;
}
