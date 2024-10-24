package com.example.ApiNotasRecordatorio.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "nota")
@NoArgsConstructor
@AllArgsConstructor
public class NotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "fechaRecordatorio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaRecordatorio;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    @JsonBackReference(value = "usuario-nota")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    @JsonBackReference(value = "categoria-nota")
    private CategoriaEntity categoria;

    @Column(name = "fechaCreacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaCreacion;

   @OneToMany(mappedBy = "nota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "comentario-nota")
    private List<ComentarioEntity> comentarios;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }
}