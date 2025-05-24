package com.edutech.usuarios.service;

import com.edutech.usuarios.model.Usuario;
import com.edutech.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Lógica de negocio y operaciones con el repositorio
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Listar todos los usuarios
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    // Guardar un nuevo usuario
    public Usuario guardar(Usuario u) {
        return repository.save(u);
    }

    // Buscar por ID
    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Eliminar usuario
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
