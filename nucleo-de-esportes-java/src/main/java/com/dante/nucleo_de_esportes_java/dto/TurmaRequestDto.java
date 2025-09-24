package com.dante.nucleo_de_esportes_java.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public record TurmaRequestDto(@NotNull Long limite_inscritos, @NotBlank String dia_semana, @NotNull Long modalidade_id, @NotNull
                              Long local_id, @NotNull LocalTime horario_inicio, @NotNull LocalTime horario_fim) {
}
