package com.dante.nucleo_de_esportes_java.controller;


import com.dante.nucleo_de_esportes_java.dto.TurmaRequestDto;
import com.dante.nucleo_de_esportes_java.dto.TurmaResponseDto;
import com.dante.nucleo_de_esportes_java.model.Turma;
import com.dante.nucleo_de_esportes_java.repository.LocalRepository;
import com.dante.nucleo_de_esportes_java.repository.ModalidadeRepository;
import com.dante.nucleo_de_esportes_java.repository.TurmaRepository;
import com.dante.nucleo_de_esportes_java.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @Autowired
    TurmaRepository turmaRepository;


    @PostMapping
    public ResponseEntity<TurmaResponseDto> createTurma (@RequestBody @Valid TurmaRequestDto data){
       TurmaResponseDto newTurma =  turmaService.registerTurma(data);
       return ResponseEntity.status(201).body(newTurma);
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponseDto>> getAllTurmas(){
        List<TurmaResponseDto> turmas = turmaService.getTurmas();
        if (turmas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(200).body(turmas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurmaById(@PathVariable (value = "id") Long id ){
        Optional<Turma> turma = turmaRepository.findById(id);
        if (turma.isEmpty()){
            return ResponseEntity.status(404).body("Turma não encontrada");
        }
        turmaRepository.deleteById(id);
        return ResponseEntity.status(200).body("Turma deletada com sucesso");
    }
}
