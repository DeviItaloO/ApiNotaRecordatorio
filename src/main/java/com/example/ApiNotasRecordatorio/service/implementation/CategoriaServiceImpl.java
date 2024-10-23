package com.example.ApiNotasRecordatorio.service.implementation;

import com.example.ApiNotasRecordatorio.persistence.dao.interfaces.ICategoriaDAO;
import com.example.ApiNotasRecordatorio.persistence.entity.CategoriaEntity;
import com.example.ApiNotasRecordatorio.presentation.dto.CategoriaDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.ICategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private ICategoriaDAO categoriaDAO;

    @Override
    public List<CategoriaDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.categoriaDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, CategoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO findById(long id) {
        Optional<CategoriaEntity> categoriaEntity = this.categoriaDAO.findById(id);
        if (categoriaEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            CategoriaEntity currentCategoriaEntity = categoriaEntity.get();
            return modelMapper.map(currentCategoriaEntity, CategoriaDTO.class);
        } else {
            return new CategoriaDTO(); // Retorna un DTO vacío si no se encuentra la categoría
        }
    }

    @Override
    public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            CategoriaEntity categoriaEntity = modelMapper.map(categoriaDTO, CategoriaEntity.class);
            this.categoriaDAO.saveCategoria(categoriaEntity);
            return modelMapper.map(categoriaEntity, CategoriaDTO.class); // Mapea el entity guardado de vuelta al DTO
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error al guardar la categoría: " + e.getMessage());
        }
    }

    @Override
    public CategoriaDTO updateCategoria(CategoriaDTO categoriaDTO, Long id) {
        Optional<CategoriaEntity> categoriaEntity = this.categoriaDAO.findById(id);
        if (categoriaEntity.isPresent()) {
            CategoriaEntity currentCategoriaEntity = categoriaEntity.get();
            // Actualiza los campos de la categoría existente
            currentCategoriaEntity.setNombre(categoriaDTO.getNombre());
            currentCategoriaEntity.setFechaCreacion(categoriaDTO.getFechaCreacion());
            
            this.categoriaDAO.updateCategoria(currentCategoriaEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentCategoriaEntity, CategoriaDTO.class);
        }
        throw new IllegalArgumentException("La categoría no existe");
    }

    @Override
    public String deleteCategoria(Long id) {
        Optional<CategoriaEntity> categoriaEntity = this.categoriaDAO.findById(id);
        if (categoriaEntity.isPresent()) {
            CategoriaEntity currentCategoriaEntity = categoriaEntity.get();
            this.categoriaDAO.deleteCategoria(currentCategoriaEntity);
            return "La categoría con el id: " + id + " ha sido eliminada con éxito";
        }
        return "La categoría con el id: " + id + " no existe";
    }
}