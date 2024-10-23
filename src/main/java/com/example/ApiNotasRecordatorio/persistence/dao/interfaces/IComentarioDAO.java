package com.example.ApiNotasRecordatorio.persistence.dao.interfaces;

import com.example.ApiNotasRecordatorio.persistence.entity.ComentarioEntity;

import java.util.List;
import java.util.Optional;

public interface IComentarioDAO {
    List<ComentarioEntity> findAll();
    Optional<ComentarioEntity> findById(Long id);
    void saveComentario(ComentarioEntity comentario);
    void updateComentario(ComentarioEntity comentario);
    void deleteComentario(ComentarioEntity comentario);
}
