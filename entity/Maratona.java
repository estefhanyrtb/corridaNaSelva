package com.example.corridanaselva.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Maratona {
    @Id
    private Long id;
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy = "maratona")
    private List<Circuito> circuitos;



    //1 MARATONA PRA VÁRIOS CIRCUITOS
//1 CIRCUITO PRA VÁRIAS INCRICOES
}
