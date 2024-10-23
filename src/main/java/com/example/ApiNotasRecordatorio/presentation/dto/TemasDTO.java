package com.example.ApiNotasRecordatorio.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TemasDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String autor;
    private LocalDateTime fechaCreacion;

    public TemasDTO(String titulo, String descripcion, String autor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaCreacion = LocalDateTime.now();
    }
}