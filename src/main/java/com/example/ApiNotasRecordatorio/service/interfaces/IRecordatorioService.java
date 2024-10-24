package com.example.ApiNotasRecordatorio.service.interfaces;

import com.example.ApiNotasRecordatorio.presentation.dto.RecordatorioDTO;
import java.util.List;

public interface IRecordatorioService {

    List<RecordatorioDTO> findAll();
    RecordatorioDTO findById(Long id);
    RecordatorioDTO saveRecordatorio(RecordatorioDTO recordatorioDTO);
    RecordatorioDTO updateRecordatorio(RecordatorioDTO recordatorioDTO, Long id);
    String deleteRecordatorio(Long id);
}
