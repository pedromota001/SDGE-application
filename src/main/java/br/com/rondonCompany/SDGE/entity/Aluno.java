package br.com.rondonCompany.SDGE.entity;


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

    public Aluno(){}

    public Aluno(String dataMatricula, String nome, String dataNascimento, String endereco, String telefone, String email, String senha) {
        this.dataMatricula = dataMatricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
}
