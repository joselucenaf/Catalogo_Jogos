package com.Lucena.Catalogo_Jogos.business.service;

import com.Lucena.Catalogo_Jogos.business.converter.JogoConverter;
import com.Lucena.Catalogo_Jogos.business.dto.JogoDTO;
import com.Lucena.Catalogo_Jogos.infrastructure.repository.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JogoService {
    private final JogoRepository jogoRepository;
    private final JogoConverter jogoConverter;

    public List<JogoDTO> listarJogosVitrine() {
        return jogoRepository.findByQuantidadeDisponivelGreaterThan(0)
                .stream()
                .map(jogoConverter::paraDTO)
                .toList();
    }

    public JogoDTO salvarJogo(JogoDTO dto) {
        return jogoConverter.paraDTO(jogoRepository.save(jogoConverter.paraEntity(dto)));
    }
}