package com.example.ApiNotasRecordatorio.service.interfaces;

import com.example.ApiNotasRecordatorio.presentation.dto.NotaDTO;

import java.util.List;

public interface INotaService {

    List<NotaDTO> findAll();
    NotaDTO findById(long id);
    NotaDTO saveNota(NotaDTO notaDTO);
    NotaDTO updateNota(NotaDTO notaDTO, Long id);
    String deleteNota(Long id);
    List<NotaDTO> findByUsuario(Long idUsuario);
    List<NotaDTO> findByCategoria(Long idCategoria);
}
//JoseRG1

