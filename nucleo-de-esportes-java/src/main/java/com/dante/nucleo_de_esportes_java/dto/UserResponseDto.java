package com.dante.nucleo_de_esportes_java.dto;

import com.dante.nucleo_de_esportes_java.enums.UserType;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String name,
        UserType role,
        String email

) {
}
