package br.com.rondonCompany.SDGE.service;

import br.com.rondonCompany.SDGE.dto.AlunoDTO;
import br.com.rondonCompany.SDGE.dto.ProfessorDTO;
import br.com.rondonCompany.SDGE.entity.Professor;
import br.com.rondonCompany.SDGE.entity.Turma;
import br.com.rondonCompany.SDGE.repository.IProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    private IProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(IProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Optional<Professor> buscaPorEmail(String email) {
        return professorRepository.findByEmail(email);
    }

    public Optional<Turma> buscaTurma(Long id) {
        return professorRepository.buscaTurmaId(id);
    }

    public List<AlunoDTO> buscaAluno() {
        return professorRepository.buscaAlunos();
    }

    public String verificaCoordenador(Optional<Professor> professor, Professor theProfessor, Model theModel){
        if(professor.isPresent() && professor.get().getSenha().equalsIgnoreCase(theProfessor.getSenha()) && professor.get().isCoordenador()){
            return "redirect:/coordenadores/coordenador-main-page";
        }
        else{
            theModel.addAttribute("error", "Email ou senha invalidos, tente novamente");
            return "coordenadores/coordenador-login-form";
        }
    }

    public List<ProfessorDTO> findAll() {
        List<Professor> lista = professorRepository.findAll();
        return converteDados(lista);
    }

    public List<ProfessorDTO> converteDados(List<Professor> listaProfessores){
        return listaProfessores.stream()
                .map(p -> new ProfessorDTO(p.getEmail()))
                .collect(Collectors.toList());
    }

    public Optional<Professor> buscaPorEmail(ProfessorDTO professor) {
        return professorRepository.findByEmail(professor.email());
    }

    public void save(Professor professor){
        professorRepository.save(professor);
    }
}
