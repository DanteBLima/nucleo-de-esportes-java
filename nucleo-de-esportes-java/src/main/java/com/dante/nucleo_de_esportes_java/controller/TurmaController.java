package com.dante.nucleo_de_esportes_java.controller;


import com.dante.nucleo_de_esportes_java.dto.TurmaRequestDto;
import com.dante.nucleo_de_esportes_java.dto.TurmaResponseDto;
import com.dante.nucleo_de_esportes_java.model.Turma;
import com.dante.nucleo_de_esportes_java.repository.LocalRepository;
import com.dante.nucleo_de_esportes_java.repository.ModalidadeRepository;
import com.dante.nucleo_de_esportes_java.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;


    @PostMapping
    public ResponseEntity<TurmaResponseDto> createTurma (@RequestBody @Valid TurmaRequestDto data){
       TurmaResponseDto newTurma =  turmaService.registerTurma(data);
       return ResponseEntity.status(201).body(newTurma);

    }
}
