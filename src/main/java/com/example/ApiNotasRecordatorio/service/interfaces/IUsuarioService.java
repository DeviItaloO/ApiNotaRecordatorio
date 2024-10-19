package com.example.ApiNotasRecordatorio.service.interfaces;

import com.example.ApiNotasRecordatorio.presentation.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> findAll();
    UsuarioDTO findById(long id);
    UsuarioDTO saveUsuario(UsuarioDTO usuario);
    UsuarioDTO updateUsuario(UsuarioDTO usuario, Long id);
    String deleteUsuario(Long id);
}
