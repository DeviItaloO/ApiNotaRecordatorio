package com.example.ApiNotasRecordatorio.presentation.controller;

import com.example.ApiNotasRecordatorio.presentation.dto.ComentarioDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

    @Autowired
    private IComentarioService comentarioService;

    @GetMapping("/buscar")
    public ResponseEntity<List<ComentarioDTO>> findAll() {
        return new ResponseEntity<>(this.comentarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ComentarioDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.comentarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ComentarioDTO> createComentario(@RequestBody ComentarioDTO comentarioDTO) {
        return new ResponseEntity<>(this.comentarioService.saveComentario(comentarioDTO), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ComentarioDTO> updateComentario(@RequestBody ComentarioDTO comentarioDTO, @PathVariable Long id) {
        return new ResponseEntity<>(this.comentarioService.updateComentario(comentarioDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteComentario(@PathVariable Long id) {
        return new ResponseEntity<>(this.comentarioService.deleteComentario(id), HttpStatus.NO_CONTENT);
    }
}
