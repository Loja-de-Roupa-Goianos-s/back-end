package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Entrega;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregaDTO {
    private Long id;
    private Entrega.StatusEntrega statusEntrega;
    private LocalDateTime dataEnvio;
    private LocalDateTime dataPrevistaEntrega;
    private LocalDateTime dataEntregaEfetiva;
    private String codigoRastreio;
}