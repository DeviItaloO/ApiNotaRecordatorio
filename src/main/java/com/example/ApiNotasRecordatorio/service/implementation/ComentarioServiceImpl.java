package com.example.ApiNotasRecordatorio.service.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.IComentarioDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.ComentarioEntity;
import com.example.ApiNotasRecordatorio.presentation.dto.ComentarioDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.IComentarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements IComentarioService {

    @Autowired
    private IComentarioDAO comentarioDAO;

    @Override
    public List<ComentarioDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.comentarioDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ComentarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ComentarioDTO findById(Long id) {
        Optional<ComentarioEntity> comentarioEntity = this.comentarioDAO.findById(id);
        if(comentarioEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(comentarioEntity.get(), ComentarioDTO.class);
        }else{
            return new ComentarioDTO();
        }
    }

    @Override
    public ComentarioDTO saveComentario(ComentarioDTO comentarioDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            ComentarioEntity comentarioEntity = modelMapper.map(comentarioDTO, ComentarioEntity.class);
            this.comentarioDAO.saveComentario(comentarioEntity);
            return comentarioDTO;
        }catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el comentario"+ e.getMessage());
        }
    }

    @Override
    public ComentarioDTO updateComentario(ComentarioDTO comentarioDTO, Long id) {
        Optional<ComentarioEntity> comentarioEntity = this.comentarioDAO.findById(id);
        if(comentarioEntity.isPresent()){
            ComentarioEntity currentComentarioEntity = comentarioEntity.get();
            currentComentarioEntity.setComentario(comentarioDTO.getComentario());
            this.comentarioDAO.updateComentario(currentComentarioEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentComentarioEntity, ComentarioDTO.class);
        }
        throw new UnsupportedOperationException("Error al actualizar el comentario");
    }

    @Override
    public String deleteComentario(Long id) {
        Optional<ComentarioEntity> comentarioEntity = this.comentarioDAO.findById(id);
        if (comentarioEntity.isPresent()) {
            ComentarioEntity currentComentarioEntity = comentarioEntity.get();
            this.comentarioDAO.deleteComentario(currentComentarioEntity);
            return "El comentario con el id: " + id + " ha sido eliminado con éxito";
        }
        return "El comentario con el id: " + id + " no existe";
    }
}
