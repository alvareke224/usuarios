package com.edutech.usuarios.service;

import com.edutech.usuarios.model.Usuario;
import com.edutech.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;

    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        if (repositorio.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }
        if (repositorio.existsByNombre(usuario.getNombre())) {
            throw new IllegalArgumentException("El nombre ya está registrado.");
        }

        return repositorio.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    public Usuario actualizar(Long id, Usuario datosNuevos) {
        Usuario usuarioExistente = buscarPorId(id);
        if (usuarioExistente == null) return null;

        usuarioExistente.setEmail(datosNuevos.getEmail());
        usuarioExistente.setNombre(datosNuevos.getNombre());
        usuarioExistente.setContrasena(datosNuevos.getContrasena());
        usuarioExistente.setRol(datosNuevos.getRol());

        return repositorio.save(usuarioExistente);
    }
}
