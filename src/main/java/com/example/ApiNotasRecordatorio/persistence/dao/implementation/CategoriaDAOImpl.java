package com.example.ApiNotasRecordatorio.persistence.dao.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.ICategoriaDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.CategoriaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaDAOImpl implements ICategoriaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<CategoriaEntity> findAll() {
        return this.em.createQuery("SELECT c FROM CategoriaEntity c", CategoriaEntity.class).getResultList();
    }

    @Override
    @Transactional
    public Optional<CategoriaEntity> findById(long id) {
        return Optional.ofNullable(this.em.find(CategoriaEntity.class, id));
    }

    @Override
    @Transactional
    public void saveCategoria(CategoriaEntity categoriaEntity) {
        this.em.persist(categoriaEntity);
    }

    @Override
    @Transactional
    public void updateCategoria(CategoriaEntity categoriaEntity) {
        this.em.merge(categoriaEntity);
    }

    @Override
    @Transactional
    public void deleteCategoria(CategoriaEntity categoriaEntity) {
        this.em.remove(categoriaEntity);
    }
}