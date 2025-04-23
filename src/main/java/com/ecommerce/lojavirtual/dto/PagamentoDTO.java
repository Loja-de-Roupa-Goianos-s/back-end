package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Pagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    private Long id;
    private Pagamento.MetodoPagamento metodoPagamento;
    private Pagamento.StatusPagamento statusPagamento;

    @NotNull(message = "Valor do pagamento é obrigatório")
    @Positive(message = "Valor do pagamento deve ser maior que zero")
    private BigDecimal valorPago;

    private LocalDateTime dataPagamento;
}