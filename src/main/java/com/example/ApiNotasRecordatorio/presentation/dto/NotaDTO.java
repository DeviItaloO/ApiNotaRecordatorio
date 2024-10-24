package com.example.ApiNotasRecordatorio.presentation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class NotaDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaRecordatorio;
    private String estado;
    private Long idUsuario;
    private Long idCategoria;
    private LocalDateTime fechaCreacion;

    public NotaDTO(String titulo, String descripcion, LocalDateTime fechaRecordatorio, String estado, Long idUsuario, Long idCategoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaRecordatorio = fechaRecordatorio;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.fechaCreacion = LocalDateTime.now();
    }
}
