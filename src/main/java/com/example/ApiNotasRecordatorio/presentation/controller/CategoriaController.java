package com.example.ApiNotasRecordatorio.presentation.controller;

import com.example.ApiNotasRecordatorio.presentation.dto.CategoriaDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    //BUSCAR CATEGORÍAS
    @GetMapping("/buscar")
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        return new ResponseEntity<>(this.categoriaService.findAll(), HttpStatus.OK);
    }

    //BUSCAR UNA CATEGORÍA POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.categoriaService.findById(id), HttpStatus.OK);
    }

    //CREAR CATEGORÍA
    @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO){
        return new ResponseEntity<>(this.categoriaService.saveCategoria(categoriaDTO), HttpStatus.CREATED);
    }

    //ACTUALIZAR CATEGORÍA
    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaDTO> updateCategoria(@RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.categoriaService.updateCategoria(categoriaDTO, id), HttpStatus.OK);
    }

    //ELIMINAR CATEGORÍA
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id){
        return new ResponseEntity<>(this.categoriaService.deleteCategoria(id), HttpStatus.NO_CONTENT);
    }
}