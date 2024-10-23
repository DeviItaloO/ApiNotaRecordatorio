package com.example.ApiNotasRecordatorio.presentation.controller;

import com.example.ApiNotasRecordatorio.presentation.dto.ComentarioDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private IComentarioService comentarioService;

    //BUSCAR COMENTARIOS
    @GetMapping("/buscar")
    public ResponseEntity<List<ComentarioDTO>> findAll() {
        return new ResponseEntity<>(this.comentarioService.findAll(), HttpStatus.OK);
    }

    //BUSCAR UN COMENTARIO POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ComentarioDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.comentarioService.findById(id), HttpStatus.OK);
    }

    //CREAR COMENTARIO
    @PostMapping("/crear")
    public ResponseEntity<ComentarioDTO> createComentario(@RequestBody ComentarioDTO comentarioDTO) {
        return new ResponseEntity<>(this.comentarioService.saveComentario(comentarioDTO), HttpStatus.CREATED);
    }

    //ACTUALIZAR COMENTARIO
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ComentarioDTO> updateComentario(@RequestBody ComentarioDTO comentarioDTO, @PathVariable Long id) {
        return new ResponseEntity<>(this.comentarioService.updateComentario(comentarioDTO, id), HttpStatus.OK);
    }

    //ELIMINAR COMENTARIO
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteComentario(@PathVariable Long id) {
        return new ResponseEntity<>(this.comentarioService.deleteComentario(id), HttpStatus.NO_CONTENT);
    }


}
