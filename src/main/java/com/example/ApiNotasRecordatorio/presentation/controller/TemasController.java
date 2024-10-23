package com.example.ApiNotasRecordatorio.presentation.controller;

import com.example.ApiNotasRecordatorio.presentation.dto.TemasDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.ITemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
public class TemasController {

    @Autowired
    private ITemasService temasService;

    //BUSCAR TEMAS
    @GetMapping("/buscar")
    public ResponseEntity<List<TemasDTO>> findAll() {
        return new ResponseEntity<>(this.temasService.findAll(), HttpStatus.OK);
    }

    //BUSCAR UN TEMA POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TemasDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.temasService.findById(id), HttpStatus.OK);
    }

    //CREAR TEMA
    @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemasDTO> createTema(@RequestBody TemasDTO temasDTO){
        return new ResponseEntity<>(this.temasService.saveTema(temasDTO), HttpStatus.CREATED);
    }

    //ACTUALIZAR TEMA
    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TemasDTO> updateTema(@RequestBody TemasDTO temasDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.temasService.updateTema(temasDTO, id), HttpStatus.OK);
    }

    //ELIMINAR TEMA
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteTema(@PathVariable Long id){
        return new ResponseEntity<>(this.temasService.deleteTema(id), HttpStatus.NO_CONTENT);
    }
}