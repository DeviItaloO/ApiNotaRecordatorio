package com.example.ApiNotasRecordatorio.service.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.INotaDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.NotaEntity;
import com.example.ApiNotasRecordatorio.presentation.dto.NotaDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.INotaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaServiceImpl implements INotaService {

    @Autowired
    private INotaDAO notaDAO;

    @Override
    public List<NotaDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.notaDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, NotaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public NotaDTO findById(long id) {
        Optional<NotaEntity> notaEntity = this.notaDAO.findById(id);
        if (notaEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            NotaEntity currentNotaEntity = notaEntity.get();
            return modelMapper.map(currentNotaEntity, NotaDTO.class);
        } else {
            return new NotaDTO(); // Retorna un DTO vacío si no se encuentra la nota
        }
    }

    @Override
    public NotaDTO saveNota(NotaDTO notaDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            NotaEntity notaEntity = modelMapper.map(notaDTO, NotaEntity.class);
            this.notaDAO.saveNota(notaEntity);
            return modelMapper.map(notaEntity, NotaDTO.class); // Mapea el entity guardado de vuelta al DTO
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error al guardar la nota: " + e.getMessage());
        }
    }

    @Override
    public NotaDTO updateNota(NotaDTO notaDTO, Long id) {
        Optional<NotaEntity> notaEntity = this.notaDAO.findById(id);
        if (notaEntity.isPresent()) {
            NotaEntity currentNotaEntity = notaEntity.get();
            // Actualiza los campos de la nota existente
            currentNotaEntity.setTitulo(notaDTO.getTitulo());
            currentNotaEntity.setDescripcion(notaDTO.getDescripcion());
            currentNotaEntity.setFechaRecordatorio(notaDTO.getFechaRecordatorio());
            currentNotaEntity.setEstado(notaDTO.getEstado());
            
            this.notaDAO.updateNota(currentNotaEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentNotaEntity, NotaDTO.class);
        }
        throw new IllegalArgumentException("La nota no existe");
    }

    @Override
    public String deleteNota(Long id) {
        Optional<NotaEntity> notaEntity = this.notaDAO.findById(id);
        if (notaEntity.isPresent()) {
            NotaEntity currentNotaEntity = notaEntity.get();
            this.notaDAO.deleteNota(currentNotaEntity);
            return "La nota con el id: " + id + " ha sido eliminada con éxito";
        }
        return "La nota con el id: " + id + " no existe";
    }

    @Override
    public List<NotaDTO> findByUsuario(Long idUsuario) {
        ModelMapper modelMapper = new ModelMapper();
        return this.notaDAO.findByUsuarioId(idUsuario)
                .stream()
                .map(entity -> modelMapper.map(entity, NotaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<NotaDTO> findByCategoria(Long idCategoria) {
        ModelMapper modelMapper = new ModelMapper();
        return this.notaDAO.findByCategoriaId(idCategoria)
                .stream()
                .map(entity -> modelMapper.map(entity, NotaDTO.class))
                .collect(Collectors.toList());
    }
}