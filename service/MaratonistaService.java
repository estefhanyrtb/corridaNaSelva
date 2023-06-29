package com.example.corridanaselva.service;

import com.example.corridanaselva.entity.Maratonista;
import com.example.corridanaselva.repository.MaratonistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MaratonistaService {
    @Autowired
    private MaratonistaRepository maratonistaRepository;

    public Maratonista salvarMaratonista(Maratonista maratonista) {
        return maratonistaRepository.save(maratonista);
    }

    public Maratonista buscarMaratonista(Long id) {
        return maratonistaRepository.findById(id).get();

    }

    public List<Maratonista> buscarMaratonistas() {
        return maratonistaRepository.findAll();
    }

    public void apagarMaratonista(Long id) {
        if (maratonistaRepository.existsById(id)) {
            maratonistaRepository.deleteById(id);
        } else {
            throw new RuntimeException("não encontrado");
        }
    }
}

