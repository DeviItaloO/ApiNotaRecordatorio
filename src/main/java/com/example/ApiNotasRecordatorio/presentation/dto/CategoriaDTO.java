package com.example.ApiNotasRecordatorio.presentation.dto;

import com.example.ApiNotasRecordatorio.persistence.entity.NotaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private List<NotaEntity> notas;

    public CategoriaDTO(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
    }
}