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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public String mostraTurmas(@PathVariable Long id, @ModelAttribute("professor") ProfessorDTO professorDTO, Model theModel){
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
    public ResponseEntity<String> atribuir_professor(
            @RequestBody Map<String, String> payload,
            @PathVariable Long id) {
        String turma_payload = payload.get("turma");
        Long turma_payload_asLong = Long.valueOf(turma_payload);
        String professor_payload = payload.get("professor");

        Optional<Professor> professor_busca = professorService.buscaPorEmail(professor_payload);
        Optional<Turma> turma_buscas = turmaService.findById(turma_payload_asLong);

        if (professor_busca.isPresent() && turma_buscas.isPresent()) {
            Professor wilmer = professor_busca.get();
            Turma turma = turma_buscas.get();
            wilmer.adicionaProfessor_turma(turma);
            professorService.save(wilmer);
            return ResponseEntity.ok("Professor inserido com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Erro ao inserir professor a uma turma!");
        }
    }




}
