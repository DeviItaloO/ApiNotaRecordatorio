package com.example.ApiNotasRecordatorio.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private LocalDateTime fechaCreacion;

    public CategoriaDTO(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
    }
}