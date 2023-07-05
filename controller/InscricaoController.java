package com.example.corridanaselva.controller;

import com.example.corridanaselva.entity.Inscricao;
import com.example.corridanaselva.entity.Maratona;
import com.example.corridanaselva.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping("inscricao")
    public ResponseEntity<Inscricao> salvarIncricao(@RequestBody Inscricao inscricao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.salvarInscricao(inscricao));
    }

    @GetMapping("inscricao/{id}")
    public ResponseEntity<Inscricao> buscarIncricao(@PathVariable Long id) {
        Inscricao inscricao =inscricaoService.buscarInscricao(id);
        if (inscricao == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Incricao não encontrada");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(inscricao);
        }
    }

    @GetMapping("inscricoes")
    public ResponseEntity<List<Inscricao>> buscarInscricoes() {
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoService.buscarInscricoes());
    }
}