package com.example.corridanaselva.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Inscricao {
    @Id
    private Long id;
    private Long circuito_Id;
    private double valor_Incricao;


    @ManyToOne
    private Maratonista maratonista;

    @ManyToOne
}
