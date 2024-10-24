package com.example.ApiNotasRecordatorio.persistence.dao.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.IComentarioDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.ComentarioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ComentarioDAOImpl implements IComentarioDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<ComentarioEntity> findAll() {
        return this.em.createQuery("SELECT c FROM ComentarioEntity c", ComentarioEntity.class).getResultList();
    }

    @Override
    @Transactional
    public Optional<ComentarioEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(ComentarioEntity.class, id));
    }

    @Override
    @Transactional
    public void saveComentario(ComentarioEntity comentarioEntity) {
        this.em.persist(comentarioEntity);
    }

    @Override
    @Transactional
    public void updateComentario(ComentarioEntity comentarioEntity) {
        this.em.merge(comentarioEntity);
    }

    @Override
    @Transactional
    public void deleteComentario(ComentarioEntity comentarioEntity) {
        this.em.remove(comentarioEntity);
    }
}
