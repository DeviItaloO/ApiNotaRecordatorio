package com.example.ApiNotasRecordatorio.persistence.dao.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.ITemasDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.TemasEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class TemasDAOImpl implements ITemasDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<TemasEntity> findAll() {
        return this.em.createQuery("SELECT t from TemasEntity t", TemasEntity.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TemasEntity> findById(long id) {
        return Optional.ofNullable(this.em.find(TemasEntity.class, id));
    }

    @Override
    @Transactional
    public void saveTema(TemasEntity temasEntity) {
        this.em.persist(temasEntity);
    }

    @Override
    @Transactional
    public void updateTema(TemasEntity temasEntity) {
        this.em.merge(temasEntity);
    }

    @Override
    @Transactional
    public void deleteTema(TemasEntity temasEntity) {
        this.em.remove(temasEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TemasEntity> findByTituloAndAutor(String titulo, String autor) {
        String query = "SELECT t FROM TemasEntity t WHERE t.titulo = :titulo AND t.autor = :autor";
        return em.createQuery(query, TemasEntity.class)
                .setParameter("titulo", titulo)
                .setParameter("autor", autor)
                .getResultList().stream().findFirst();
    }
}