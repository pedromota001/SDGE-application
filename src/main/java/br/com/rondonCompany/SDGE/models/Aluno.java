package br.com.rondonCompany.SDGE.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataMatricula;
    private String nome;
    private String dataNascimento;
    private String endereco;
    private String telefone;

    @ManyToOne
    private Turma turma;
}
