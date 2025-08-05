package com.dante.nucleo_de_esportes_java.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "turma")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "horario_inicio")
    private LocalTime horario_inicio;

    @Column(nullable = false, name = "horario_fim")
    private LocalTime horario_fim;

    @Column(nullable = false)
    private Long limite_inscritos;

    @Column(nullable = false)
    private String dia_semana;


    @JoinColumn(name = "modalidade_id", nullable = false )
    @ManyToOne
    private Modalidade modalidade;

    @JoinColumn(name = "local_id", nullable = false )
    @ManyToOne
    private Local local;

}
