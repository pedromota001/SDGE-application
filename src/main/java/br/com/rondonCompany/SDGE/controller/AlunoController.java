package br.com.rondonCompany.SDGE.controller;

import br.com.rondonCompany.SDGE.entity.Aluno;
import br.com.rondonCompany.SDGE.service.aluno.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService theAlunoService){
        alunoService = theAlunoService;
    }

    @GetMapping("/index")
    public String alunoIndex(){
        return "index";
    }


    @GetMapping("/showAlunoLoginForm")
    public String loginAluno(Model theModel){
        //cria novo aluno e faz o binding com os dados do form
        Aluno theAluno = new Aluno();
        theModel.addAttribute("aluno", theAluno);
        return "alunos/aluno-login-form";
    }

    @GetMapping("/showAlunoCadastroForm")
    public String cadastroAluno(Model theModel){
        Aluno theAluno = new Aluno();
        theModel.addAttribute("aluno", theAluno);
        return "alunos/aluno-cadastro-form";
    }

    @PostMapping("/save")
    public String saveAluno(@ModelAttribute("aluno") Aluno theAluno){
        //salvar o aluno
        alunoService.save(theAluno);

        //retorna para pg de login
        return "redirect:/alunos/showAlunoLoginForm";
    }

    @PostMapping("/validate")
    public String validateAlunoLogin(@ModelAttribute("aluno") Aluno theAluno, Model theModel){
        Optional<Aluno> alunoExistente = alunoService.findByEmail(theAluno.getEmail());
        return alunoService.verificaAlunoNoBanco(alunoExistente, theAluno, theModel);
    }

    @GetMapping("/aluno-main-page")
    public String showAlunoMainPage(){
        return "alunos/aluno-main-page";
    }
}