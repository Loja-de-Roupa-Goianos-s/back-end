package com.ecommerce.lojavirtual.security;

import com.ecommerce.lojavirtual.model.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean isUsuarioAtual(Long usuarioId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof Usuario) {
            return ((Usuario) principal).getId().equals(usuarioId);
        }

        return false;
    }
}