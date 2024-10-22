package br.com.rondonCompany.SDGE.controller;


import br.com.rondonCompany.SDGE.dto.AlunoDTO;
import br.com.rondonCompany.SDGE.entity.Aluno;
import br.com.rondonCompany.SDGE.entity.Professor;
import br.com.rondonCompany.SDGE.entity.Turma;
import br.com.rondonCompany.SDGE.service.ProfessorService;
import br.com.rondonCompany.SDGE.service.aluno.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/coordenadores")
public class CoordenadorController {

    private ProfessorService professorService;
    private AlunoService alunoService;

    @Autowired
    public CoordenadorController(ProfessorService professorService, AlunoService alunoService) {
        this.professorService = professorService;
        this.alunoService = alunoService;
    }

    @GetMapping("/showCoordenadorLoginForm")
    public String loginCoordenador(Model theModel){
        Professor professor = new Professor();
        theModel.addAttribute("coordenador", professor);
        return "coordenadores/coordenador-login-form";
    }

    @PostMapping("/validate")
    public String validateCoordenadorLogin(@ModelAttribute("coordenador") Professor professor, Model theModel){
        Optional<Professor> professorExistente = professorService.buscaPorEmail(professor.getEmail());
        return professorService.verificaCoordenador(professorExistente, theModel);
    }

    @GetMapping("/coordenador-main-page")
    public String mainPageCoordenador(){
        return "coordenadores/coordenador-main-page";
    }

    @GetMapping("/addProfessorForm")
    public String GerenciaTurmaCoordenador(){
        return "coordenadores/atribuir-professor";
    }

    /*@GetMapping("/coordenador-main-page/gerenciamento-turmas/{id}")
    public String mostraTurmas(@PathVariable Long id, Model theModel){
        List<AlunoDTO> alunosTurma = alunoService.findByTurma_Id(id);
        alunosTurma.forEach(System.out::println);
        theModel.addAttribute("aluno", alunosTurma);
        return "coordenadores/coordenador-main-page";
    }*/

    @GetMapping("/mostrarTurma")
    public String mostraTurma(Model theModel){

        List<AlunoDTO> theAlunos = alunoService.findAll();

        theModel.addAttribute("aluno", theAlunos);

        return "coordenadores/mostrar-turma";
    }

    @GetMapping("/showProfessorForm")
    public String showProfessorForm(){
        return "coordenadores/atribuir-professor";
    }
}
