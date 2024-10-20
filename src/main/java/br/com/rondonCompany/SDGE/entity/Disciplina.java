package br.com.rondonCompany.SDGE.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
