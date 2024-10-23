package com.example.ApiNotasRecordatorio.persistence.dao.interfaces;

import com.example.ApiNotasRecordatorio.persistence.entity.TemasEntity;
import java.util.List;
import java.util.Optional;

public interface ITemasDAO {
    // Método para los temas
    List<TemasEntity> findAll();
    Optional<TemasEntity> findById(long id);
    void saveTema(TemasEntity tema);
    void updateTema(TemasEntity tema);
    void deleteTema(TemasEntity tema);

    // Método para buscar por título y autor
    Optional<TemasEntity> findByTituloAndAutor(String titulo, String autor);
}