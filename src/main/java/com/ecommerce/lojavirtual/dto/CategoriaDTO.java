package com.ecommerce.lojavirtual.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private Long id;

    @NotBlank(message = "Nome da categoria é obrigatório")
    private String nome;
}