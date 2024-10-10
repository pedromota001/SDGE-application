package br.com.rondonCompany.SDGE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlunoController {

    @GetMapping("/cadastrar-alunos")
    public String cadastrarAluno() {
        return "cadastrar-aluno"; //html referente ao cadastro de alunos

    }
}
