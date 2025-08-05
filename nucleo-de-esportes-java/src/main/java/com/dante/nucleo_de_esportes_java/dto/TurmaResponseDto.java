package com.dante.nucleo_de_esportes_java.dto;

import com.dante.nucleo_de_esportes_java.model.Local;
import com.dante.nucleo_de_esportes_java.model.Modalidade;

import java.time.LocalTime;

public record TurmaResponseDto(Long id, LocalTime horario_inicio, LocalTime horario_fim,
                               String dia_semana,
                               Modalidade modalidade,
                               Local local,
                               Long limite_inscritos) {
}
