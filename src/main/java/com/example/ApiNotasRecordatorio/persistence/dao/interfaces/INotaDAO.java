package com.example.ApiNotasRecordatorio.persistence.dao.interfaces;

import com.example.ApiNotasRecordatorio.persistence.entity.NotaEntity;

import java.util.List;
import java.util.Optional;

public interface INotaDAO {


    List<NotaEntity> findAll();

    Optional<NotaEntity> findById(long id);

    void saveNota(NotaEntity nota);

    void updateNota(NotaEntity nota);

    void deleteNota(NotaEntity nota);

    List<NotaEntity> findByUsuarioId(Long idUsuario);

    List<NotaEntity> findByCategoriaId(Long idCategoria);
}
