package com.ecommerce.lojavirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDTO {
    private Long id;
    private LocalDateTime dataAtualizacao;
    private List<ItemCarrinhoDTO> itens = new ArrayList<>();
    private BigDecimal valorTotal;
}