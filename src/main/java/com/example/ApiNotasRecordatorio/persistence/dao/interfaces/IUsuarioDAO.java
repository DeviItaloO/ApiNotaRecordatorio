package com.example.ApiNotasRecordatorio.persistence.dao.interfaces;

import com.example.ApiNotasRecordatorio.persistence.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDAO {
    // Método para el usuario
    List<UsuarioEntity> findAll();
    Optional<UsuarioEntity> findById(long id);
    void saveUsuario(UsuarioEntity usuario);
    void updateUsuario(UsuarioEntity usuario);
    void deleteUsuario(UsuarioEntity usuario);

    // Método para buscar por email y contraseña
    Optional<UsuarioEntity> findByEmailAndContrasenia(String email, String contrasenia);
}
