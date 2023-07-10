package com.example.corridanaselva.service;

import com.example.corridanaselva.entity.Circuito;
import com.example.corridanaselva.entity.Enum.Categoria;
import com.example.corridanaselva.entity.Inscricao;
import com.example.corridanaselva.entity.Maratonista;
import com.example.corridanaselva.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public Inscricao salvarInscricao(Inscricao inscricao) {
        Maratonista maratonista = inscricao.getMaratonista();
        Circuito circuito = inscricao.getCircuito();
        if (circuito.getCategoria() == Categoria.ALVANCADO && maratonista.getIdade() < 18) {
            throw new RuntimeException("O maratonista deve ter 18 anos ou mais para se inscrever no circuito avançado.");
        }
        return inscricaoRepository.save(inscricao);
    }

    public Inscricao buscarInscricao(Long id) {
        return inscricaoRepository.findById(id).orElse(null);
    }

    public List<Inscricao> buscarInscricoes() {
        return inscricaoRepository.findAll();
    }
}
