package com.edutech.usuarios.controller;

import com.edutech.usuarios.model.Usuario;
import com.edutech.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API REST para exponer las operaciones CRUD
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Para permitir peticiones desde Postman o frontend
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    // GET http://localhost:8081/usuarios
    @GetMapping
    public List<Usuario> listar() {
        return servicio.listarTodos();
    }

    // POST http://localhost:8081/usuarios
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return servicio.guardar(usuario);
    }

    // GET http://localhost:8081/usuarios/{id}
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return servicio.buscarPorId(id);
    }

    // DELETE http://localhost:8081/usuarios/{id}
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
