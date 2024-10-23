package com.example.ApiNotasRecordatorio.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaDTO {
    private Long id;                     // ID único de la nota
    private String titulo;               // Título de la nota
    private String descripcion;          // Descripción de la nota
    private LocalDateTime fechaRecordatorio;  // Fecha y hora de recordatorio
    private String estado;               // Estado de la nota (por ejemplo, "pendiente", "completada")
    private Long idUsuario;              // ID del usuario que creó la nota
    private Long idCategoria;            // ID de la categoría de la nota
    private LocalDateTime fechaCreacion; // Fecha de creación de la nota

    public NotaDTO(String titulo, String descripcion, LocalDateTime fechaRecordatorio, String estado, Long idUsuario, Long idCategoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaRecordatorio = fechaRecordatorio;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.fechaCreacion = LocalDateTime.now(); // Asigna la fecha de creación actual
    }
}
//JoseRG6
