package com.example.corridanaselva.service;

import com.example.corridanaselva.entity.Maratona;
import com.example.corridanaselva.repository.MaratonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MaratonaService {
    @Autowired
    private MaratonaRepository maratonaRepository;

    public Maratona salvarMaratona(Maratona maratona) {
        return maratonaRepository.save(maratona);
    }

    public Maratona buscarMaratona(Long id) {
        return maratonaRepository.findById(id).get();

    }

    public List<Maratona> buscarMaratonas() {
        return maratonaRepository.findAll();
    }
}


