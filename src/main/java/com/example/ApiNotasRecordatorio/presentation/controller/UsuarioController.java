package com.example.ApiNotasRecordatorio.presentation.controller;

import com.example.ApiNotasRecordatorio.presentation.dto.UsuarioDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    //BUSCAR USUARIOS
    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return new ResponseEntity<>(this.usuarioService.findAll(), HttpStatus.OK);
    }

    //BUSCAR UNA USUARIO POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.usuarioService.findById(id), HttpStatus.OK);
    }

    //CREAR USUARIO
    @PostMapping("/crear")
    public ResponseEntity<UsuarioDTO> createPersona(@RequestBody UsuarioDTO UsuarioDTO){
        return new ResponseEntity<>(this.usuarioService.saveUsuario(UsuarioDTO), HttpStatus.CREATED);
    }

    //ACTUALIZAR USUARIO
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioDTO> updatePersona(@RequestBody UsuarioDTO UsuarioDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.usuarioService.updateUsuario(UsuarioDTO, id), HttpStatus.OK);
    }

    //ELIMINAR USUARIO
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id){
        return new ResponseEntity<>(this.usuarioService.deleteUsuario(id), HttpStatus.NO_CONTENT);
    }
}
