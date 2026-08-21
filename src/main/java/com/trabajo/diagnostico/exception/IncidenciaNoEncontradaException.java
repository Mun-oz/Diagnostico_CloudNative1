package com.trabajo.diagnostico.exception;

public class IncidenciaNoEncontradaException extends RuntimeException {
   public IncidenciaNoEncontradaException(Long id) {
        super("No existe una incidencia con id " + id);
    }
}
