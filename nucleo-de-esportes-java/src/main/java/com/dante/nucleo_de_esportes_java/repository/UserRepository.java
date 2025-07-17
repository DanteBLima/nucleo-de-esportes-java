package com.dante.nucleo_de_esportes_java.repository;

import com.dante.nucleo_de_esportes_java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
