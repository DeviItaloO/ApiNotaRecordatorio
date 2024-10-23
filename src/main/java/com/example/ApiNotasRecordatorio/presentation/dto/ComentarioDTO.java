package com.example.ApiNotasRecordatorio.presentation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ComentarioDTO {
    private Long id;
    private String comentario;
    private LocalDateTime fechaCreacion;
    private Long idNota;

    public ComentarioDTO(String comentario, Long idNota) {
        this.comentario = comentario;
        this.idNota = idNota;
        this.fechaCreacion = LocalDateTime.now();
    }
}
