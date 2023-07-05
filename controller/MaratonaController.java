package com.example.corridanaselva.controller;

import com.example.corridanaselva.entity.Maratona;
import com.example.corridanaselva.entity.Maratonista;
import com.example.corridanaselva.service.MaratonaService;
import com.example.corridanaselva.service.MaratonistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MaratonaController {
    @Autowired
    private MaratonaService maratonaService;

    @PostMapping("maratona")
    public ResponseEntity<Maratona> salvarMaratona(@RequestBody Maratona maratona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonaService.salvarMaratona(maratona));
    }

    @GetMapping("maratona/{id}")
    public ResponseEntity<Maratona> buscarMaratona(@PathVariable Long id) {
        Maratona maratona = maratonaService.buscarMaratona(id);
        if (maratona == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Maratona não encontrada");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(maratona);
        }
    }

    @GetMapping("maratonas")
    public ResponseEntity<List<Maratona>> buscarMaratonas() {
        return ResponseEntity.status(HttpStatus.OK).body(maratonaService.buscarMaratonas());
    }
}
