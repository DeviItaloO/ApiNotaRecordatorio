package com.example.ApiNotasRecordatorio.presentation.controller;

import com.example.ApiNotasRecordatorio.presentation.dto.NotaDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.INotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    private INotaService notaService;

    // BUSCAR TODAS LAS NOTAS
    @GetMapping("/buscar")
    public ResponseEntity<List<NotaDTO>> findAll() {
        return new ResponseEntity<>(this.notaService.findAll(), HttpStatus.OK);
    }
    // BUSCAR UNA NOTA POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<NotaDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.notaService.findById(id), HttpStatus.OK);
    }

    // CREAR NOTA
    @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotaDTO> createNota(@RequestBody NotaDTO notaDTO) {
        return new ResponseEntity<>(this.notaService.saveNota(notaDTO), HttpStatus.CREATED);
    }

    // ACTUALIZAR NOTA
    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotaDTO> updateNota(@RequestBody NotaDTO notaDTO, @PathVariable Long id) {
        return new ResponseEntity<>(this.notaService.updateNota(notaDTO, id), HttpStatus.OK);
    }

    // ELIMINAR NOTA
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteNota(@PathVariable Long id) {
        this.notaService.deleteNota(id);
        return new ResponseEntity<>("Nota eliminada con éxito", HttpStatus.NO_CONTENT);
    }
    // BUSCAR NOTAS POR CATEGORÍA
    @GetMapping("/buscar/categoria/{idCategoria}")
    public ResponseEntity<List<NotaDTO>> findByCategoria(@PathVariable Long idCategoria) {
        return new ResponseEntity<>(this.notaService.findByCategoria(idCategoria), HttpStatus.OK);
    }

}
