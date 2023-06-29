package com.example.corridanaselva.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Maratonista {
    @Id
    private Long id;
    private int idade;
    private String grupoSanguineo;
    private String nome;
    private String numeroCelular;
    private String numeroEmergencia;
    private String rg;
    private String sobrenome;

    @JsonIgnore
    @OneToMany(mappedBy = "maratonista")
   private List<Inscricao> inscricoes;

}
