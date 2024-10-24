package com.example.ApiNotasRecordatorio.presentation.dto;

import com.example.ApiNotasRecordatorio.persistence.entity.NotaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private List<NotaEntity> notas;

    public CategoriaDTO(String nombre, LocalDateTime fechaCreacion, List<NotaEntity> notas) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
        this.notas = notas;
    }
}