package com.edutech.usuarios.repository;

import com.edutech.usuarios.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interfaz que permite operaciones CRUD sobre la tabla Usuario
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Podemos agregar métodos personalizados aquí si se necesitan en el futuro
}
