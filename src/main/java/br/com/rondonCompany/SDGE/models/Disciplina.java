package br.com.rondonCompany.SDGE.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "disciplinas")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer cargaHoraria;

    @ManyToMany(mappedBy = "listaDisciplinas", cascade = CascadeType.ALL)
    private List<Professor> listaProfessores = new ArrayList<>();

}
