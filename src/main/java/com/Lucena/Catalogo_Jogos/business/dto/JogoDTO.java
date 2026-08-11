package com.Lucena.Catalogo_Jogos.business.dto;

import com.Lucena.Catalogo_Jogos.infrastructure.enums.TipoJogo;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JogoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private TipoJogo tipo;
    private Integer quantidadeDisponivel;
}