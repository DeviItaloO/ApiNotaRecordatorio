package com.example.ApiNotasRecordatorio.service.interfaces;

import com.example.ApiNotasRecordatorio.presentation.dto.TemasDTO;

import java.util.List;

public interface ITemasService {
    List<TemasDTO> findAll();
    TemasDTO findById(long id);
    TemasDTO saveTema(TemasDTO tema);
    TemasDTO updateTema(TemasDTO tema, Long id);
    String deleteTema(Long id);

    // Método para buscar por título y autor
    TemasDTO findByTituloAndAutor(String titulo, String autor);
}