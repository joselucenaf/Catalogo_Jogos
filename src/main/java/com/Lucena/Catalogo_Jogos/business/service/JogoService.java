package com.Lucena.Catalogo_Jogos.business.service;

import com.Lucena.Catalogo_Jogos.business.converter.JogoConverter;
import com.Lucena.Catalogo_Jogos.business.dto.JogoDTO;
import com.Lucena.Catalogo_Jogos.infrastructure.entity.Jogo;
import com.Lucena.Catalogo_Jogos.infrastructure.repository.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogoService {
    private final JogoRepository jogoRepository;
    private final JogoConverter jogoConverter;

    // Lista apenas jogos com estoque real para a vitrine
    public List<JogoDTO> listarJogosVitrine() {
        return jogoRepository.findByQuantidadeDisponivelGreaterThan(0) //
                .stream()
                .map(jogoConverter::paraDTO) //
                .toList();
    }

    // Salva um novo jogo garantindo que não haja duplicidade pelo nome
    public JogoDTO salvarJogo(JogoDTO dto) {
        if (jogoRepository.existsByNomeIgnoreCase(dto.getNome())) { //[cite: 18]
            throw new RuntimeException("Já existe um jogo cadastrado com este nome: " + dto.getNome());
        }

        Jogo jogo = jogoConverter.paraEntity(dto); //[cite: 17]
        return jogoConverter.paraDTO(jogoRepository.save(jogo));
    }

    public JogoDTO atualizarJogo(Long id, JogoDTO dto) {
        Jogo jogoExistente = jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + id));
        Jogo jogoAtualizado = jogoConverter.atualizarJogo(dto, jogoExistente);
        return jogoConverter.paraDTO(jogoRepository.save(jogoAtualizado));
    }

    public void deletaJogoPorId(Long id) {
        if (!jogoRepository.existsById(id)) {
            throw new RuntimeException("Não é possível excluir: Jogo não encontrado com o ID: " + id);
        }
        jogoRepository.deleteById(id);
    }
}