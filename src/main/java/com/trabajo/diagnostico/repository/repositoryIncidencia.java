package com.trabajo.diagnostico.repository;

import com.trabajo.diagnostico.Model.Incidencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface repositoryIncidencia extends JpaRepository<Incidencia, Integer> {
    // Búsqueda por texto (en título o descripción) y filtros opcionales
    @Query("SELECT i FROM Incidencia i WHERE " +
           "(:estado IS NULL OR i.estado = :estado) AND " +
           "(:prioridad IS NULL OR i.prioridad = :prioridad) AND " +
           "(:search IS NULL OR LOWER(i.titulo) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(i.descripcion) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<Incidencia> buscarConFiltros(@Param("estado") String estado, 
                                      @Param("prioridad") String prioridad, 
                                      @Param("search") String search);

    long countByEstado(String estado);
}
