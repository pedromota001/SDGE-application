package br.com.rondonCompany.SDGE.service;

import br.com.rondonCompany.SDGE.entity.Professor;
import br.com.rondonCompany.SDGE.entity.Turma;
import br.com.rondonCompany.SDGE.repository.IProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {
    private IProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(IProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Optional<Professor> buscaPorEmail(String email) {
        return professorRepository.findByEmail();
    }

    public Optional<Turma> buscaTurma(Long id) {
        return professorRepository.buscaTurmaId(id);
    }
}
