package com.trabajo.diagnostico.dto;

import com.trabajo.diagnostico.Model.Estado;

import jakarta.validation.constraints.NotNull;

public class CambioEstadoDTO {

    @NotNull(message = "el estado es obligatorio")
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
