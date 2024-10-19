package com.example.ApiNotasRecordatorio.persistence.dao.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.IUsuarioDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.UsuarioEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioEntity> findAll() {
        return this.em.createQuery("SELECT u from UsuarioEntity u", UsuarioEntity.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioEntity> findById(long id) {
        return Optional.ofNullable(this.em.find(UsuarioEntity.class, id));
    }

    @Override
    public void saveUsuario(UsuarioEntity usuarioEntity) {
        this.em.persist(usuarioEntity);
    }

    @Override
    public void updateUsuario(UsuarioEntity usuarioEntity) {
        this.em.merge(usuarioEntity);
    }

    @Override
    public void deleteUsuario(UsuarioEntity usuarioEntity) {
        this.em.remove(usuarioEntity);
    }
}