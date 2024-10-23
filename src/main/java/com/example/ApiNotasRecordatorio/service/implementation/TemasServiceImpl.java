package com.example.ApiNotasRecordatorio.service.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.ITemasDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.TemasEntity;
import com.example.ApiNotasRecordatorio.presentation.dto.TemasDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.ITemasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TemasServiceImpl implements ITemasService {

    @Autowired
    private ITemasDAO temasDAO;

    @Override
    @Transactional(readOnly = true)
    public List<TemasDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.temasDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, TemasDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TemasDTO findById(long id) {
        Optional<TemasEntity> temasEntity = this.temasDAO.findById(id);
        if (temasEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            TemasEntity currentTemasEntity = temasEntity.get();
            return modelMapper.map(currentTemasEntity, TemasDTO.class);
        } else {
            return new TemasDTO();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public TemasDTO findByTituloAndAutor(String titulo, String autor) {
        Optional<TemasEntity> temasEntity = temasDAO.findByTituloAndAutor(titulo, autor);
        if (temasEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(temasEntity.get(), TemasDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public TemasDTO saveTema(TemasDTO temasDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            TemasEntity temasEntity = modelMapper.map(temasDTO, TemasEntity.class);
            this.temasDAO.saveTema(temasEntity);
            return modelMapper.map(temasEntity, TemasDTO.class);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error al guardar el tema" + e);
        }
    }

    @Override
    public TemasDTO updateTema(TemasDTO temasDTO, Long id) {
        Optional<TemasEntity> temasEntity = this.temasDAO.findById(id);
        if (temasEntity.isPresent()) {
            TemasEntity currentTemasEntity = temasEntity.get();
            currentTemasEntity.setTitulo(temasDTO.getTitulo());
            currentTemasEntity.setDescripcion(temasDTO.getDescripcion());
            currentTemasEntity.setAutor(temasDTO.getAutor());
            this.temasDAO.updateTema(currentTemasEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentTemasEntity, TemasDTO.class);
        }
        throw new IllegalArgumentException("El Tema no existe");
    }

    @Override
    public String deleteTema(Long id) {
        Optional<TemasEntity> temasEntity = this.temasDAO.findById(id);
        if (temasEntity.isPresent()) {
            TemasEntity currentTemasEntity = temasEntity.get();
            this.temasDAO.deleteTema(currentTemasEntity);
            return "El tema con el id: " + id + " ha sido eliminado con éxito";
        }
        return "El tema con el id: " + id + " no existe";
    }
}