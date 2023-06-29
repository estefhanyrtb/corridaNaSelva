package com.example.corridanaselva.service;

import com.example.corridanaselva.entity.Inscricao;
import com.example.corridanaselva.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public Inscricao salvarInscricao(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }
}