package com.example.ApiNotasRecordatorio.service.interfaces;

import com.example.ApiNotasRecordatorio.presentation.dto.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaDTO> findAll();
    CategoriaDTO findById(long id);
    CategoriaDTO saveCategoria(CategoriaDTO categoria);
    CategoriaDTO updateCategoria(CategoriaDTO categoria, Long id);
    String deleteCategoria(Long id);
}