package com.example.ApiNotasRecordatorio.persistence.dao.interfaces;

import com.example.ApiNotasRecordatorio.persistence.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDAO {

    List<UsuarioEntity> findAll();
    Optional<UsuarioEntity> findById(long id);
    void saveUsuario(UsuarioEntity usuario);
    void updateUsuario(UsuarioEntity usuario);
    void deleteUsuario(UsuarioEntity usuario);
    Optional<UsuarioEntity> findByEmailAndContrasenia(String email, String contrasenia);
}
