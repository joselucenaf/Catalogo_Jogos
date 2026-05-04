package com.Lucena.Catalogo_Jogos.controller;

import com.Lucena.Catalogo_Jogos.business.dto.JogoDTO;
import com.Lucena.Catalogo_Jogos.business.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
@RequiredArgsConstructor
public class JogoController {
    private final JogoService jogoService;

    @GetMapping("/disponiveis")
    public ResponseEntity<List<JogoDTO>> vitrine() {
        return ResponseEntity.ok(jogoService.listarJogosVitrine());
    }
    @PostMapping
    public ResponseEntity<JogoDTO> cadastrarJogo(@RequestBody JogoDTO dto) {
        return ResponseEntity.ok(jogoService.salvarJogo(dto));
    }
}