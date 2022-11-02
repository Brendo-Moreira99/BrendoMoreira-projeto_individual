package com.org.recode.NovosAres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.recode.NovosAres.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByEmail(String email);
}

