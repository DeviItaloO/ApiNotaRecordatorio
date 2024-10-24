package com.example.ApiNotasRecordatorio.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "recordatorio")
@NoArgsConstructor
@AllArgsConstructor
public class RecordatorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "fechaRecordatorio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaRecordatorio;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idNota", nullable = false)
    @JsonBackReference(value = "recordatorio-nota")
    private NotaEntity nota;

    @PrePersist
    protected void onCreate() {
        this.fechaRecordatorio = LocalDateTime.now();
    }

}
