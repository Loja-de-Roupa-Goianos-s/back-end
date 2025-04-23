package com.ecommerce.lojavirtual.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega = StatusEntrega.AGUARDANDO_ENVIO;

    private LocalDateTime dataEnvio;
    private LocalDateTime dataPrevistaEntrega;
    private LocalDateTime dataEntregaEfetiva;
    private String codigoRastreio;

    public enum StatusEntrega {
        AGUARDANDO_ENVIO, EM_TRANSITO, ENTREGUE
    }
}