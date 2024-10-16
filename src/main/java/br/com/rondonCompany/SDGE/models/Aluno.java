package br.com.rondonCompany.SDGE.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private String email;
    private String senha;

    @ManyToOne
    private Turma turma;
}
