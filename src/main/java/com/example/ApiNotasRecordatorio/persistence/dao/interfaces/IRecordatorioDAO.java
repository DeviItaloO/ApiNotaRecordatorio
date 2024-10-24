package com.example.ApiNotasRecordatorio.persistence.dao.interfaces;

import com.example.ApiNotasRecordatorio.persistence.entity.RecordatorioEntity;

import java.util.List;
import java.util.Optional;

public interface IRecordatorioDAO {

    List<RecordatorioEntity> findAll();
    Optional<RecordatorioEntity> findById(Long id);
    void saveRecordatorio(RecordatorioEntity recordatorioEntity);
    void updateRecordatorio(RecordatorioEntity recordatorioEntity);
    void deleteRecordatorio(RecordatorioEntity recordatorioEntity);
}
