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
    @Column(name="id")
    private Long id;

    @Column(name="data_matricula")
    private String dataMatricula;

    @Column(name="nome")
    private String nome;

    @Column(name="data_nascimento")
    private String dataNascimento;

    @Column(name="endereco")
    private String endereco;

    @Column(name="telefone")
    private String telefone;

    @Column(name="email")
    private String email;

    @Column(name="senha")
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
