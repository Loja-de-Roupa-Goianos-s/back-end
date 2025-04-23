package com.ecommerce.lojavirtual.service;

import com.ecommerce.lojavirtual.dto.RegistroUsuarioDTO;
import com.ecommerce.lojavirtual.dto.UsuarioDTO;
import com.ecommerce.lojavirtual.exception.RecursoExistenteException;
import com.ecommerce.lojavirtual.exception.RecursoNaoEncontradoException;
import com.ecommerce.lojavirtual.model.Usuario;
import com.ecommerce.lojavirtual.repository.UsuarioRepository;
import com.ecommerce.lojavirtual.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService implements CustomUserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + email));
    }

    @Transactional
    public UsuarioDTO registrarUsuario(RegistroUsuarioDTO registroDTO) {
        if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
            throw new RecursoExistenteException("Email já está em uso: " + registroDTO.getEmail());
        }

        Usuario usuario = new Usuario();
        usuario.setNome(registroDTO.getNome());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setSenha(passwordEncoder.encode(registroDTO.getSenha()));
        usuario.setDataNascimento(registroDTO.getDataNascimento());
        usuario.setEnderecoRua(registroDTO.getEnderecoRua());
        usuario.setEnderecoNumero(registroDTO.getEnderecoNumero());
        usuario.setEnderecoBairro(registroDTO.getEnderecoBairro());
        usuario.setEnderecoCidade(registroDTO.getEnderecoCidade());
        usuario.setEnderecoEstado(registroDTO.getEnderecoEstado());
        usuario.setEnderecoCep(registroDTO.getEnderecoCep());
        usuario.setRole(Usuario.Role.CLIENTE);
        usuario.setAtivo(true);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioSalvo);
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + id));
        return converterParaDTO(usuario);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o email: " + email));
        return converterParaDTO(usuario);
    }

    public List<UsuarioDTO> listarTodosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + id));

        if (!usuario.getEmail().equals(usuarioDTO.getEmail()) && usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            throw new RecursoExistenteException("Email já está em uso: " + usuarioDTO.getEmail());
        }

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setEnderecoRua(usuarioDTO.getEnderecoRua());
        usuario.setEnderecoNumero(usuarioDTO.getEnderecoNumero());
        usuario.setEnderecoBairro(usuarioDTO.getEnderecoBairro());
        usuario.setEnderecoCidade(usuarioDTO.getEnderecoCidade());
        usuario.setEnderecoEstado(usuarioDTO.getEnderecoEstado());
        usuario.setEnderecoCep(usuarioDTO.getEnderecoCep());

        if (usuarioDTO.getRole() != null) {
            usuario.setRole(usuarioDTO.getRole());
        }

        usuario.setAtivo(usuarioDTO.isAtivo());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioAtualizado);
    }

    @Transactional
    public void alterarSenha(Long id, String novaSenha) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + id));

        usuario.setSenha(passwordEncoder.encode(novaSenha));
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void desativarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + id));

        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

    private UsuarioDTO converterParaDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setEnderecoRua(usuario.getEnderecoRua());
        dto.setEnderecoNumero(usuario.getEnderecoNumero());
        dto.setEnderecoBairro(usuario.getEnderecoBairro());
        dto.setEnderecoCidade(usuario.getEnderecoCidade());
        dto.setEnderecoEstado(usuario.getEnderecoEstado());
        dto.setEnderecoCep(usuario.getEnderecoCep());
        dto.setRole(usuario.getRole());
        dto.setAtivo(usuario.isAtivo());
        return dto;
    }

    @Override
    public UserDetails loadUserById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o ID: " + id));
    }
}