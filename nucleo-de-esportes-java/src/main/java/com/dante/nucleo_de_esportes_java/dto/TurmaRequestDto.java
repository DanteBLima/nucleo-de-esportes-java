package com.dante.nucleo_de_esportes_java.dto;

import com.dante.nucleo_de_esportes_java.model.Local;
import com.dante.nucleo_de_esportes_java.model.Modalidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public record TurmaRequestDto(@NotNull Long limite_inscritos, @NotBlank String dia_semana, @NotNull Long modalidadeId, @NotNull
                              Long localId, @NotNull LocalTime horario_inicio, @NotNull LocalTime horario_final) {
}
