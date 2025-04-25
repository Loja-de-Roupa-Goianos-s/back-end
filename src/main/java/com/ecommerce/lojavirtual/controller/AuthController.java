package com.ecommerce.lojavirtual.controller;

import com.ecommerce.lojavirtual.dto.LoginDTO;
import com.ecommerce.lojavirtual.dto.RegistroUsuarioDTO;
import com.ecommerce.lojavirtual.dto.UsuarioDTO;
import com.ecommerce.lojavirtual.security.JwtTokenProvider;
import com.ecommerce.lojavirtual.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  JwtTokenProvider tokenProvider;
    @Autowired
    private  UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@Valid @RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getSenha()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.gerarToken(authentication);

        UsuarioDTO usuarioDTO = usuarioService.buscarUsuarioPorEmail(loginDTO.getEmail());

        Map<String, Object> response = new HashMap<>();
        response.put("token", jwt);
        response.put("usuario", usuarioDTO);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody RegistroUsuarioDTO registroDTO) {
        UsuarioDTO usuarioDTO = usuarioService.registrarUsuario(registroDTO);
        return ResponseEntity.ok(usuarioDTO);
    }
}