package com.example.ApiNotasRecordatorio.service.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.IUsuarioDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.UsuarioEntity;
import com.example.ApiNotasRecordatorio.presentation.dto.UsuarioDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public List<UsuarioDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.usuarioDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(long id) {
        Optional<UsuarioEntity> usuarioEntity = this.usuarioDAO.findById(id);
        if (usuarioEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            UsuarioEntity currentUsuarioEntity = usuarioEntity.get();
            return modelMapper.map(currentUsuarioEntity, UsuarioDTO.class);
        }else {
            return new UsuarioDTO();
        }
    }

    @Override
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            UsuarioEntity usuarioEntity = modelMapper.map(usuarioDTO, UsuarioEntity.class);
            this.usuarioDAO.saveUsuario(usuarioEntity);
            return usuarioDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
    }

    @Override
    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO, Long id) {
        Optional<UsuarioEntity> usuarioEntity = this.usuarioDAO.findById(id);
        if(usuarioEntity.isPresent()) {
            UsuarioEntity currentUsuarioEntity = usuarioEntity.get();
            currentUsuarioEntity.setNombre(usuarioDTO.getNombre());
            currentUsuarioEntity.setEmail(usuarioDTO.getEmail());
            currentUsuarioEntity.setContrasenia(usuarioDTO.getContrasenia());
            this.usuarioDAO.updateUsuario(currentUsuarioEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentUsuarioEntity, UsuarioDTO.class);
        }
        throw new IllegalArgumentException("El Usuario no existe");
    }

    @Override
    public String deleteUsuario(Long id) {
        Optional<UsuarioEntity> usuarioEntity = this.usuarioDAO.findById(id);
        if(usuarioEntity.isPresent()) {
            UsuarioEntity currentUsuarioEntity = usuarioEntity.get();
            this.usuarioDAO.deleteUsuario(currentUsuarioEntity);
            return "El usuario con el id: " + id + " a sido eliminado con exito";
        }
        return "El usuario no el id: " + id + " no existe";
    }
}
