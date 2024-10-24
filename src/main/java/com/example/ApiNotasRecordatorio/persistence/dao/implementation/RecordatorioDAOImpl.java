package com.example.ApiNotasRecordatorio.persistence.dao.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.IRecordatorioDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.RecordatorioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class RecordatorioDAOImpl implements IRecordatorioDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<RecordatorioEntity> findAll() {
        return this.em.createQuery("SELECT r from RecordatorioEntity r", RecordatorioEntity.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RecordatorioEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(RecordatorioEntity.class, id));
    }

    @Override
    @Transactional
    public void saveRecordatorio(RecordatorioEntity recordatorioEntity) {
        this.em.persist(recordatorioEntity);
    }

    @Override
    @Transactional
    public void updateRecordatorio(RecordatorioEntity recordatorioEntity) {
        this.em.merge(recordatorioEntity);
    }

    @Override
    @Transactional
    public void deleteRecordatorio(RecordatorioEntity recordatorioEntity) {
        this.em.remove(recordatorioEntity);
    }
}
