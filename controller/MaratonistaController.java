package com.example.corridanaselva.controller;

import com.example.corridanaselva.entity.Maratonista;
import com.example.corridanaselva.service.MaratonistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MaratonistaController {
    @Autowired
    private MaratonistaService maratonistaService;

    @PostMapping("maratonista")
    public ResponseEntity<Maratonista> salvarMaratonista(@RequestBody Maratonista maratonista) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonistaService.salvarMaratonista(maratonista));
    }

    @GetMapping("maratonista/{id}")
    public ResponseEntity<Maratonista> buscarMaratonista(@PathVariable Long id) {
        Maratonista maratonista = maratonistaService.buscarMaratonista(id);
        if (maratonista == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Maratonista não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(maratonista);
        }
    }

    @GetMapping("maratonistas")
    public ResponseEntity<List<Maratonista>> buscarMaratonistas() {
        return ResponseEntity.status(HttpStatus.OK).body(maratonistaService.buscarMaratonistas());
    }
    @DeleteMapping("maratonista/{id}")
    public ResponseEntity<String> apagarMaratonista(@PathVariable Long id) {
        try {
            maratonistaService.apagarMaratonista(id);
            return ResponseEntity.status(HttpStatus.OK).body("maratonista com id " + id + " Maratonista excluído com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}



