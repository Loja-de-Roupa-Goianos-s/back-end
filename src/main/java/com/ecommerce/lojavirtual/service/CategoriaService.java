package com.ecommerce.lojavirtual.service;

import com.ecommerce.lojavirtual.dto.CategoriaDTO;
import com.ecommerce.lojavirtual.exception.RecursoExistenteException;
import com.ecommerce.lojavirtual.exception.RecursoNaoEncontradoException;
import com.ecommerce.lojavirtual.model.Categoria;
import com.ecommerce.lojavirtual.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> listarTodasCategorias() {
        return categoriaRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public CategoriaDTO buscarCategoriaPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com o ID: " + id));
        return converterParaDTO(categoria);
    }

    @Transactional
    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        if (categoriaRepository.existsByNome(categoriaDTO.getNome())) {
            throw new RecursoExistenteException("Categoria já existe com o nome: " + categoriaDTO.getNome());
        }

        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());

        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return converterParaDTO(categoriaSalva);
    }

    @Transactional
    public CategoriaDTO atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com o ID: " + id));

        if (!categoria.getNome().equals(categoriaDTO.getNome()) &&
                categoriaRepository.existsByNome(categoriaDTO.getNome())) {
            throw new RecursoExistenteException("Categoria já existe com o nome: " + categoriaDTO.getNome());
        }

        categoria.setNome(categoriaDTO.getNome());
        Categoria categoriaAtualizada = categoriaRepository.save(categoria);
        return converterParaDTO(categoriaAtualizada);
    }

    @Transactional
    public void excluirCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Categoria não encontrada com o ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }

    private CategoriaDTO converterParaDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }

    public Categoria buscarCategoriaPorIdEntidade(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com o ID: " + id));
    }
}