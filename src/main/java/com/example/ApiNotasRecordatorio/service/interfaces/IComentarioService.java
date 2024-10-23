package com.example.ApiNotasRecordatorio.service.interfaces;

import com.example.ApiNotasRecordatorio.presentation.dto.ComentarioDTO;

import java.util.List;

public interface IComentarioService {
    List<ComentarioDTO> findAll();
    ComentarioDTO findById(Long id);
    ComentarioDTO saveComentario(ComentarioDTO comentario);
    ComentarioDTO updateComentario(ComentarioDTO comentario, Long id);
    String deleteComentario(Long id);
}
