package br.com.rondonCompany.SDGE.controller;


import br.com.rondonCompany.SDGE.entity.Professor;
import br.com.rondonCompany.SDGE.entity.Turma;
import br.com.rondonCompany.SDGE.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/coordenadores")
public class CoordenadorController {

    private ProfessorService professorService;

    @Autowired
    public CoordenadorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/showCoordenadorLoginForm")
    public String loginCoordenador(Model theModel){
        Professor professor = new Professor();
        theModel.addAttribute("coordenador", professor);
        return "coordenador/coordenador-login-form";
    }

    @PostMapping("/validate")
    public String validateCoordenadorLogin(@ModelAttribute("coordenador") Professor professor, Model theModel){
        Optional<Professor> professorExistente = professorService.buscaPorEmail(professor.getEmail());
        if(professorExistente.isPresent() && professorExistente.get().getSenha().equalsIgnoreCase(professor.getSenha())){
            return "coordenador/coordenadores-main-page";
        }
        else{
            theModel.addAttribute("error", "Email ou senha invalidos, tente novamente");
            return "coordenador/coordenador-login-form";
        }
    }

    @GetMapping("/showCoordenador-main-page")
    public String mainPageCoordenador(){
        return "coordenador/coordenador-main-page";
    }

    @GetMapping("/showGerenciaTurma")
    public String GerenciaTurmaCoordenador(){
        return "coordenador/gerencia-turma";
    }

    @GetMapping("/gerencia-turma/{id}")
    public String mostraTurmas(@PathVariable Long id, Model theModel){
        Optional<Turma> turmaExiste = professorService.buscaTurma(id);
        if(turmaExiste.isPresent()){
            return " ";//implementar
        }
        else{
            theModel.addAttribute("error", "Turma inexistente no sistema, tenta novamente");
            return "coordenador/gerencia-turma";
        }
    }
}
