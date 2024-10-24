package com.example.ApiNotasRecordatorio.presentation.dto;

import com.example.ApiNotasRecordatorio.persistence.entity.NotaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RecordatorioDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaRecordatorio;
    private String estado;
    private NotaEntity idNota;

    public RecordatorioDTO(String titulo, String descripcion, LocalDateTime fechaRecordatorio, String estado, NotaEntity idNota) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaRecordatorio = fechaRecordatorio;
        this.estado = estado;
        this.idNota = idNota;
    }
}
