package com.example.corridanaselva.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Maratona {
private Long id;
private String nome;
    @ManyToOne
    private Circuito circuito;
    //1 MARATONA PRA VÁRIOS CIRCUITOS
//1 CIRCUITOS PRA VÁRIAS INCRICOES
}
