package com.dante.nucleo_de_esportes_java.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Set;

@Entity
@Table(name = "local")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String campus;

    @OneToMany(mappedBy = "local")
    private Set<Turma> turmas;


}
