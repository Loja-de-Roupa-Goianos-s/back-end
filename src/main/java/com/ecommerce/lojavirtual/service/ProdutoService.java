package com.ecommerce.lojavirtual.service;

import com.ecommerce.lojavirtual.dto.ProdutoDTO;
import com.ecommerce.lojavirtual.exception.RecursoExistenteException;
import com.ecommerce.lojavirtual.exception.RecursoNaoEncontradoException;
import com.ecommerce.lojavirtual.model.Categoria;
import com.ecommerce.lojavirtual.model.Produto;
import com.ecommerce.lojavirtual.model.Usuario;
import com.ecommerce.lojavirtual.repository.ProdutoRepository;
import com.ecommerce.lojavirtual.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaService categoriaService;
    private final UsuarioRepository usuarioRepository;

    public Page<ProdutoDTO> listarProdutosAtivos(Pageable pageable) {
        return produtoRepository.findByAtivoTrue(pageable)
                .map(this::converterParaDTO);
    }

    public Page<ProdutoDTO> listarProdutosPorCategoria(Long categoriaId, Pageable pageable) {
        Categoria categoria = categoriaService.buscarCategoriaPorIdEntidade(categoriaId);
        return produtoRepository.findByCategoria(categoria, pageable)
                .map(this::converterParaDTO);
    }

    public Page<ProdutoDTO> buscarProdutosPorNome(String nome, Pageable pageable) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome, pageable)
                .map(this::converterParaDTO);
    }

    public List<ProdutoDTO> listarProdutosPorVendedor(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        return produtoRepository.findByUsuario(usuario).stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarProdutoPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com o ID: " + id));
        return converterParaDTO(produto);
    }

    public Produto buscarProdutoPorIdEntidade(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com o ID: " + id));
    }

    @Transactional
    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        Categoria categoria = categoriaService.buscarCategoriaPorIdEntidade(produtoDTO.getCategoriaId());

        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        produto.setCodigoProduto(gerarCodigoProduto());
        produto.setAtivo(true);
        produto.setUsuario(usuario);
        produto.setCategoria(categoria);

        Produto produtoSalvo = produtoRepository.save(produto);
        return converterParaDTO(produtoSalvo);
    }

    @Transactional
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com o ID: " + id));

        Categoria categoria = categoriaService.buscarCategoriaPorIdEntidade(produtoDTO.getCategoriaId());

        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        produto.setAtivo(produtoDTO.isAtivo());
        produto.setCategoria(categoria);

        Produto produtoAtualizado = produtoRepository.save(produto);
        return converterParaDTO(produtoAtualizado);
    }

    @Transactional
    public void atualizarEstoque(Long id, int quantidade) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com o ID: " + id));

        int novoEstoque = produto.getQuantidadeEstoque() - quantidade;
        if (novoEstoque < 0) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome());
        }

        produto.setQuantidadeEstoque(novoEstoque);
        produtoRepository.save(produto);
    }

    @Transactional
    public void desativarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com o ID: " + id));

        produto.setAtivo(false);
        produtoRepository.save(produto);
    }

    private String gerarCodigoProduto() {
        String codigo;
        do {
            codigo = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        } while (produtoRepository.existsByCodigoProduto(codigo));

        return codigo;
    }

    private ProdutoDTO converterParaDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        dto.setCodigoProduto(produto.getCodigoProduto());
        dto.setAtivo(produto.isAtivo());
        dto.setCategoriaId(produto.getCategoria().getId());
        return dto;
    }
}