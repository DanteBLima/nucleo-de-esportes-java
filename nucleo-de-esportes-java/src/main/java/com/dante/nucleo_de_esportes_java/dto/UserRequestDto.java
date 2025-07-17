package com.dante.nucleo_de_esportes_java.dto;

import com.dante.nucleo_de_esportes_java.enums.UserType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record UserRequestDto(@NotBlank String name,
                             @NotBlank String email,
                             @NotBlank String password
                             ) {
}
