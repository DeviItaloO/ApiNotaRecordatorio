package com.example.ApiNotasRecordatorio.service.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.IRecordatorioDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.RecordatorioEntity;
import com.example.ApiNotasRecordatorio.presentation.dto.RecordatorioDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.IRecordatorioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordatorioServiceImpl implements IRecordatorioService {

    @Autowired
    private IRecordatorioDAO recordatorioDAO;

    @Override
    public List<RecordatorioDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.recordatorioDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, RecordatorioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecordatorioDTO findById(Long id) {
        Optional<RecordatorioEntity> recordatorioEntity = this.recordatorioDAO.findById(id);
        if (recordatorioEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            RecordatorioEntity currentRecordatorioEntity = recordatorioEntity.get();
            return modelMapper.map(currentRecordatorioEntity, RecordatorioDTO.class);
        }else {
            return new RecordatorioDTO();
        }
    }

    @Override
    public RecordatorioDTO saveRecordatorio(RecordatorioDTO recordatorioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        RecordatorioEntity recordatorioEntity = modelMapper.map(recordatorioDTO, RecordatorioEntity.class);
        this.recordatorioDAO.saveRecordatorio(recordatorioEntity);
        return recordatorioDTO;
    }

    @Override
    public RecordatorioDTO updateRecordatorio(RecordatorioDTO recordatorioDTO, Long id) {
        Optional<RecordatorioEntity> recordatorioEntity = this.recordatorioDAO.findById(id);
        if(recordatorioEntity.isPresent()) {
            RecordatorioEntity currentRecordatorioEntity = recordatorioEntity.get();
            currentRecordatorioEntity.setFechaRecordatorio(recordatorioDTO.getFechaRecordatorio());
            currentRecordatorioEntity.setEstado(recordatorioDTO.getEstado());
            this.recordatorioDAO.updateRecordatorio(currentRecordatorioEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentRecordatorioEntity, RecordatorioDTO.class);
        }
        throw new IllegalArgumentException("El recordatorio no existe");
    }

    @Override
    public String deleteRecordatorio(Long id) {
        Optional<RecordatorioEntity> recordatorioEntity = this.recordatorioDAO.findById(id);
        if(recordatorioEntity.isPresent()) {
            RecordatorioEntity currentRecordatorioEntity = recordatorioEntity.get();
            this.recordatorioDAO.deleteRecordatorio(currentRecordatorioEntity);
            return "El recordatorio con el id: " + id + " ha sido eliminado con éxito";
        }
        return "El recordatorio con el id: " + id + " no existe";
    }
}
