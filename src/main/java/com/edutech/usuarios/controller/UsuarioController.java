package com.edutech.usuarios.controller;

import com.edutech.usuarios.model.Usuario;
import com.edutech.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping
    public List<Usuario> listar() {
        return servicio.listar();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario nuevo = servicio.guardar(usuario);
            return ResponseEntity.ok(nuevo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = servicio.buscarPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        Usuario actualizado = servicio.actualizar(id, usuario);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
}
