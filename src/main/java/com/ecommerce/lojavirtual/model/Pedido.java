package com.ecommerce.lojavirtual.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private LocalDateTime dataPedido = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.EM_ANDAMENTO;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    private String enderecoEntregaRua;
    private String enderecoEntregaNumero;
    private String enderecoEntregaBairro;
    private String enderecoEntregaCidade;
    private String enderecoEntregaEstado;
    private String enderecoEntregaCep;

    private boolean ativo = true;

    @Column(unique = true)
    private String codigoPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Entrega entrega;

    public enum StatusPedido {
        EM_ANDAMENTO, APROVADO, NEGADO, CANCELADO
    }

    public enum FormaPagamento {
        CARTAO, PIX, BOLETO
    }
}