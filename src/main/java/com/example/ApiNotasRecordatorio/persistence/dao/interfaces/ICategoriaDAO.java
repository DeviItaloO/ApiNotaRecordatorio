package com.example.ApiNotasRecordatorio.persistence.dao.interfaces;

import com.example.ApiNotasRecordatorio.persistence.entity.CategoriaEntity;

import java.util.List;
import java.util.Optional;

public interface ICategoriaDAO {
    // Métodos para la entidad Categoria
    List<CategoriaEntity> findAll();
    Optional<CategoriaEntity> findById(long id);
    void saveCategoria(CategoriaEntity categoria);
    void updateCategoria(CategoriaEntity categoria);
    void deleteCategoria(CategoriaEntity categoria);
}