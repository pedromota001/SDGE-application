package br.com.rondonCompany.SDGE.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id da nota

    private String nome; // nome da materia da nota

    private double nota; // nota daquela pessoa naquela materia

    @ManyToOne
    private Aluno aluno; // uma nota so pode ta atribuida para um aluno

    public Notas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
