package com.example.corridanaselva.controller;

import com.example.corridanaselva.entity.Inscricao;
import com.example.corridanaselva.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping("usuario")
    public ResponseEntity<Inscricao> salvarIncricao(@RequestBody Inscricao inscricao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.salvarInscricao(inscricao));
    }
}