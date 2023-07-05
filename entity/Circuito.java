package com.example.corridanaselva.entity;

import com.example.corridanaselva.entity.Enum.Categoria;
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
public class Circuito {
    private Categoria categoria;
    @Id
    private Long id;
    private int distancia;

    @ManyToOne
    private Maratona maratona;

    @JsonIgnore
    @OneToMany(mappedBy = "circuito")
    private List<Inscricao> inscricoes;

}
