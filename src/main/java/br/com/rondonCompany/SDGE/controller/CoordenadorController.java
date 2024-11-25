package br.com.rondonCompany.SDGE.controller;


import br.com.rondonCompany.SDGE.dto.AlunoDTO;
import br.com.rondonCompany.SDGE.dto.ProfessorDTO;
import br.com.rondonCompany.SDGE.entity.Aluno;
import br.com.rondonCompany.SDGE.entity.Professor;
import br.com.rondonCompany.SDGE.entity.Turma;
import br.com.rondonCompany.SDGE.repository.IProfessorRepository;
import br.com.rondonCompany.SDGE.service.ProfessorService;
import br.com.rondonCompany.SDGE.service.TurmaService;
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
    private TurmaService turmaService;

    @Autowired
    public CoordenadorController(ProfessorService professorService, AlunoService alunoService, TurmaService turmaService) {
        this.professorService = professorService;
        this.alunoService = alunoService;
        this.turmaService = turmaService;
    }

    @GetMapping("/index")
    public String coordenadorIndex(){
        return "index";
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
        return professorService.verificaCoordenador(professorExistente, professor,theModel);
    }

    @GetMapping("/coordenador-main-page")
    public String mainPageCoordenador(){
        return "coordenadores/coordenador-main-page";
    }

    @GetMapping("/addProfessorForm")
    public String GerenciaTurmaCoordenador(){
        return "coordenadores/atribuir-professor";
    }

    @GetMapping("/mostrarTurma/{id}")
    public String mostraTurmas(@PathVariable Long id, Model theModel){
        List<AlunoDTO> alunosTurma = alunoService.findByTurma_Id(id);
        List<ProfessorDTO> professores_disponiveis = professorService.findAll();
        alunosTurma.forEach(System.out::println);
        theModel.addAttribute("aluno", alunosTurma);
        theModel.addAttribute("professor", professores_disponiveis);
        return "coordenadores/mostrar-turma";
    }


    @GetMapping("/mostrarTurma")
    public String mostraTurma(Model theModel){

        List<AlunoDTO> theAlunos = alunoService.findAll();

        theModel.addAttribute("aluno", theAlunos);

        return "coordenadores/mostrar-turma";
    }


//    @GetMapping("/showProfessorForm")
//    public String showProfessorForm(){
//        return "coordenadores/atribuir-professor";
//    }

    @PostMapping("/mostrarTurma/{id}")
    public String atribuir_professor(@PathVariable Long id, @ModelAttribute("professor") ProfessorDTO professor, Model theModel){
        Optional<Professor> professor_busca = professorService.buscaPorEmail(professor.email());
        Optional<Turma> turma_buscas = turmaService.findById(id);
        if(professor_busca.isPresent() && turma_buscas.isPresent()){
            Professor wilmer = professor_busca.get();
            Turma turma = turma_buscas.get();
            wilmer.getListaTurmas().add(turma);
            turma.getListaProfessores().add(wilmer);
            professorService.save(wilmer);
            turmaService.save(turma);
            return "redirect:/coordenadores/coordenador-main-page";
        }
        else{
            return "coordenadores/mostrar-turma";
        }
    }



}
