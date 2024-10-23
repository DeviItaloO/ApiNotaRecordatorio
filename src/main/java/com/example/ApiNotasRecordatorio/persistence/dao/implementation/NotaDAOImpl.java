package com.example.ApiNotasRecordatorio.persistence.dao.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.INotaDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.NotaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class NotaDAOImpl implements INotaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<NotaEntity> findAll() {
        return this.em.createQuery("SELECT n FROM NotaEntity n", NotaEntity.class).getResultList();
    }

    @Override
    @Transactional
    public Optional<NotaEntity> findById(long id) {
        return Optional.ofNullable(this.em.find(NotaEntity.class, id));
    }

    @Override
    @Transactional
    public void saveNota(NotaEntity notaEntity) {
        this.em.persist(notaEntity);
    }

    @Override
    @Transactional
    public void updateNota(NotaEntity notaEntity) {
        this.em.merge(notaEntity);
    }

    @Override
    @Transactional
    public void deleteNota(NotaEntity notaEntity) {
        this.em.remove(notaEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotaEntity> findByUsuarioId(Long idUsuario) {
        String query = "SELECT n FROM NotaEntity n WHERE n.usuario.id = :idUsuario";
        return em.createQuery(query, NotaEntity.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotaEntity> findByCategoriaId(Long idCategoria) {
        String query = "SELECT n FROM NotaEntity n WHERE n.categoria.id = :idCategoria";
        return em.createQuery(query, NotaEntity.class)
                .setParameter("idCategoria", idCategoria)
                .getResultList();
    }
}
//JoseRG1