package com.Lucena.Catalogo_Jogos.business.converter;

import com.Lucena.Catalogo_Jogos.business.dto.JogoDTO;
import com.Lucena.Catalogo_Jogos.infrastructure.entity.Jogo;
import org.springframework.stereotype.Component;

@Component
public class JogoConverter {

    public JogoDTO paraDTO(Jogo entity) {
        return JogoDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .tipo(entity.getTipo())
                .quantidadeDisponivel(entity.getQuantidadeDisponivel())
                .build();
    }

    public Jogo paraEntity(JogoDTO dto) {
        return Jogo.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .tipo(dto.getTipo())
                .quantidadeDisponivel(dto.getQuantidadeDisponivel())
                .quantidadeTotal(dto.getQuantidadeDisponivel())
                .build();
    }
}
