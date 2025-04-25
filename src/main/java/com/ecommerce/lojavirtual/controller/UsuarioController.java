package com.ecommerce.lojavirtual.controller;

import com.ecommerce.lojavirtual.dto.UsuarioDTO;
import com.ecommerce.lojavirtual.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private  UsuarioService usuarioService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UsuarioDTO>> listarTodosUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @securityService.isUsuarioAtual(#id)")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @securityService.isUsuarioAtual(#id)")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @PutMapping("/{id}/senha")
    @PreAuthorize("hasRole('ADMIN') or @securityService.isUsuarioAtual(#id)")
    public ResponseEntity<?> alterarSenha(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String novaSenha = request.get("novaSenha");
        usuarioService.alterarSenha(id, novaSenha);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @securityService.isUsuarioAtual(#id)")
    public ResponseEntity<?> desativarUsuario (@PathVariable Long id){
        usuarioService.desativarUsuario(id);
        return ResponseEntity.ok().build();
    }
}

