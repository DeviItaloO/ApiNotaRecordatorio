package com.example.ApiNotasRecordatorio.presentation.controller;

import com.example.ApiNotasRecordatorio.presentation.dto.RecordatorioDTO;
import com.example.ApiNotasRecordatorio.presentation.dto.RecordatorioDTO;
import com.example.ApiNotasRecordatorio.presentation.dto.RecordatorioDTO;
import com.example.ApiNotasRecordatorio.service.interfaces.IRecordatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recordatorio")
public class RecordatorioController {
    @Autowired
    private IRecordatorioService recordatorioService;

    @GetMapping("/buscar")
    public ResponseEntity<List<RecordatorioDTO>> findAll() {
        return new ResponseEntity<>(this.recordatorioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<RecordatorioDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.recordatorioService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordatorioDTO> createRecordatorio(@RequestBody RecordatorioDTO recordatorioDTO){
        return new ResponseEntity<>(this.recordatorioService.saveRecordatorio(recordatorioDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordatorioDTO> updateRecordatorio(@RequestBody RecordatorioDTO recordatorioDTO, @PathVariable Long id){
        return new ResponseEntity<>(this.recordatorioService.updateRecordatorio(recordatorioDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteRecordatorio(@PathVariable Long id){
        return new ResponseEntity<>(this.recordatorioService.deleteRecordatorio(id), HttpStatus.NO_CONTENT);
    }
    
    
}
