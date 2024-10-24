package com.example.ApiNotasRecordatorio.presentation.controller;

import com.example.ApiNotasRecordatorio.presentation.dto.LoginDTO;
import com.example.ApiNotasRecordatorio.presentation.dto.UsuarioDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return new ResponseEntity<>(this.usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.usuarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> createPersona(@RequestBody UsuarioDTO usuarioDTO){
        return new ResponseEntity<>(this.usuarioService.saveUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    //LOGIN DEL USUARIO
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> loginUsuario(@RequestBody LoginDTO loginDTO) {
        UsuarioDTO usuario = usuarioService.findByEmailAndContrasenia(loginDTO.getEmail(), loginDTO.getContrasenia());
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> updatePersona(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.usuarioService.updateUsuario(usuarioDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id){
        return new ResponseEntity<>(this.usuarioService.deleteUsuario(id), HttpStatus.NO_CONTENT);
    }
}
