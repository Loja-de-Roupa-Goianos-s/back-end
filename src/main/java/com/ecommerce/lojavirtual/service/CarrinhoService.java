package com.ecommerce.lojavirtual.service;

import com.ecommerce.lojavirtual.dto.CarrinhoDTO;
import com.ecommerce.lojavirtual.dto.ItemCarrinhoDTO;
import com.ecommerce.lojavirtual.exception.RecursoNaoEncontradoException;
import com.ecommerce.lojavirtual.model.Carrinho;
import com.ecommerce.lojavirtual.model.ItemCarrinho;
import com.ecommerce.lojavirtual.model.Produto;
import com.ecommerce.lojavirtual.model.Usuario;
import com.ecommerce.lojavirtual.repository.CarrinhoRepository;
import com.ecommerce.lojavirtual.repository.ItemCarrinhoRepository;
import com.ecommerce.lojavirtual.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProdutoService produtoService;

    public CarrinhoDTO buscarCarrinhoPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        Carrinho carrinho = carrinhoRepository.findByUsuarioAndItensIsNotEmpty(usuario)
                .orElseGet(() -> {
                    Carrinho novoCarrinho = new Carrinho();
                    novoCarrinho.setUsuario(usuario);
                    novoCarrinho.setDataAtualizacao(LocalDateTime.now());
                    novoCarrinho.setItens(new ArrayList<>());
                    return carrinhoRepository.save(novoCarrinho);
                });

        return converterParaDTO(carrinho);
    }

    @Transactional
    public CarrinhoDTO adicionarItemAoCarrinho(Long usuarioId, ItemCarrinhoDTO itemDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        Produto produto = produtoService.buscarProdutoPorIdEntidade(itemDTO.getProdutoId());

        if (produto.getQuantidadeEstoque() < itemDTO.getQuantidade()) {
            throw new IllegalArgumentException("Quantidade solicitada maior que o estoque disponível");
        }

        Carrinho carrinho = carrinhoRepository.findByUsuarioAndItensIsNotEmpty(usuario)
                .orElseGet(() -> {
                    Carrinho novoCarrinho = new Carrinho();
                    novoCarrinho.setUsuario(usuario);
                    novoCarrinho.setDataAtualizacao(LocalDateTime.now());
                    novoCarrinho.setItens(new ArrayList<>());
                    return carrinhoRepository.save(novoCarrinho);
                });

        Optional<ItemCarrinho> itemExistente = itemCarrinhoRepository.findByCarrinhoAndProduto(carrinho, produto);

        if (itemExistente.isPresent()) {
            ItemCarrinho item = itemExistente.get();
            item.setQuantidade(item.getQuantidade() + itemDTO.getQuantidade());
            itemCarrinhoRepository.save(item);
        } else {
            ItemCarrinho novoItem = new ItemCarrinho();
            novoItem.setCarrinho(carrinho);
            novoItem.setProduto(produto);
            novoItem.setQuantidade(itemDTO.getQuantidade());
            carrinho.getItens().add(novoItem);
            itemCarrinhoRepository.save(novoItem);
        }

        carrinho.setDataAtualizacao(LocalDateTime.now());
        carrinhoRepository.save(carrinho);

        return converterParaDTO(carrinho);
    }

    @Transactional
    public CarrinhoDTO atualizarItemDoCarrinho(Long usuarioId, Long itemId, ItemCarrinhoDTO itemDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        Carrinho carrinho = carrinhoRepository.findByUsuarioAndItensIsNotEmpty(usuario)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Carrinho não encontrado para o usuário"));

        ItemCarrinho item = itemCarrinhoRepository.findById(itemId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Item não encontrado no carrinho"));

        if (!item.getCarrinho().getId().equals(carrinho.getId())) {
            throw new IllegalArgumentException("Item não pertence ao carrinho do usuário");
        }

        Produto produto = produtoService.buscarProdutoPorIdEntidade(itemDTO.getProdutoId());

        if (produto.getQuantidadeEstoque() < itemDTO.getQuantidade()) {
            throw new IllegalArgumentException("Quantidade solicitada maior que o estoque disponível");
        }

        item.setQuantidade(itemDTO.getQuantidade());
        itemCarrinhoRepository.save(item);

        carrinho.setDataAtualizacao(LocalDateTime.now());
        carrinhoRepository.save(carrinho);

        return converterParaDTO(carrinho);
    }

    @Transactional
    public CarrinhoDTO removerItemDoCarrinho(Long usuarioId, Long itemId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        Carrinho carrinho = carrinhoRepository.findByUsuarioAndItensIsNotEmpty(usuario)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Carrinho não encontrado para o usuário"));

        ItemCarrinho item = itemCarrinhoRepository.findById(itemId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Item não encontrado no carrinho"));

        if (!item.getCarrinho().getId().equals(carrinho.getId())) {
            throw new IllegalArgumentException("Item não pertence ao carrinho do usuário");
        }

        carrinho.getItens().remove(item);
        itemCarrinhoRepository.delete(item);

        carrinho.setDataAtualizacao(LocalDateTime.now());
        carrinhoRepository.save(carrinho);

        return converterParaDTO(carrinho);
    }

    @Transactional
    public void limparCarrinho(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + usuarioId));

        Carrinho carrinho = carrinhoRepository.findByUsuarioAndItensIsNotEmpty(usuario)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Carrinho não encontrado para o usuário"));

        itemCarrinhoRepository.deleteAll(carrinho.getItens());
        carrinho.getItens().clear();

        carrinho.setDataAtualizacao(LocalDateTime.now());
        carrinhoRepository.save(carrinho);
    }

    private CarrinhoDTO converterParaDTO(Carrinho carrinho) {
        CarrinhoDTO dto = new CarrinhoDTO();
        dto.setId(carrinho.getId());
        dto.setDataAtualizacao(carrinho.getDataAtualizacao());

        List<ItemCarrinhoDTO> itensDTO = carrinho.getItens().stream()
                .map(this::converterItemParaDTO)
                .collect(Collectors.toList());

        dto.setItens(itensDTO);

        BigDecimal valorTotal = itensDTO.stream()
                .map(ItemCarrinhoDTO::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        dto.setValorTotal(valorTotal);

        return dto;
    }

    private ItemCarrinhoDTO converterItemParaDTO(ItemCarrinho item) {
        ItemCarrinhoDTO dto = new ItemCarrinhoDTO();
        dto.setId(item.getId());
        dto.setProdutoId(item.getProduto().getId());
        dto.setNomeProduto(item.getProduto().getNome());
        dto.setQuantidade(item.getQuantidade());
        dto.setPrecoUnitario(item.getProduto().getPreco());
        dto.setSubtotal(item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
        return dto;
    }
}