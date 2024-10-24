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
@RequestMapping("/api/nota")
public class NotaController {
    @Autowired
    private INotaService notaService;

    @GetMapping("/buscar")
    public ResponseEntity<List<NotaDTO>> findAll() {
        return new ResponseEntity<>(this.notaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<NotaDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.notaService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotaDTO> createNota(@RequestBody NotaDTO notaDTO) {
        return new ResponseEntity<>(this.notaService.saveNota(notaDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotaDTO> updateNota(@RequestBody NotaDTO notaDTO, @PathVariable Long id) {
        return new ResponseEntity<>(this.notaService.updateNota(notaDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteNota(@PathVariable Long id) {
        return new ResponseEntity<>(this.notaService.deleteNota(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar/categoria/{idCategoria}")
    public ResponseEntity<List<NotaDTO>> findByCategoria(@PathVariable Long idCategoria) {
        return new ResponseEntity<>(this.notaService.findByCategoria(idCategoria), HttpStatus.OK);
    }

    @GetMapping("/buscar/usuario/{idUsuario}")
    public ResponseEntity<List<NotaDTO>> findByUsuario(@PathVariable Long idUsuario) {
        return new ResponseEntity<>(this.notaService.findByUsuario(idUsuario), HttpStatus.OK);
    }
}
