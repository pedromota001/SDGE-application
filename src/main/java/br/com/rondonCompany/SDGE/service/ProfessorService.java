package br.com.rondonCompany.SDGE.service;

import br.com.rondonCompany.SDGE.entity.Professor;
import br.com.rondonCompany.SDGE.entity.Turma;
import br.com.rondonCompany.SDGE.repository.IProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

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

    public String verificaCoordenador(Optional<Professor> professor, Model theModel){
        if(professor.isPresent() && professor.get().getSenha().equalsIgnoreCase(professor.get().getSenha()) && professor.get().isCoordenador()){
            return "coordenadores/coordenador-main-page";
        }
        else{
            theModel.addAttribute("error", "Email ou senha invalidos, tente novamente");
            return "coordenadores/coordenador-login-form";
        }
    }
}
