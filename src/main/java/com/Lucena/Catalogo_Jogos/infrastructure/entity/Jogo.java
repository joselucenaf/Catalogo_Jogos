package com.Lucena.Catalogo_Jogos.infrastructure.entity;

import com.Lucena.Catalogo_Jogos.infrastructure.enums.TipoJogo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jogos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoJogo tipo;
    private Integer quantidadeDisponivel;
    private Integer quantidadeTotal;
}
