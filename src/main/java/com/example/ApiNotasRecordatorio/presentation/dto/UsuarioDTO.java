package com.example.ApiNotasRecordatorio.presentation.dto;

import com.example.ApiNotasRecordatorio.persistence.entity.NotaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String contrasenia;
    private LocalDateTime fechaCreacion;
    private List<NotaEntity> notas;

    public UsuarioDTO(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.fechaCreacion = LocalDateTime.now();
    }
}