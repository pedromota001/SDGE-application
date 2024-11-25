package br.com.rondonCompany.SDGE.service;


import br.com.rondonCompany.SDGE.entity.Turma;
import br.com.rondonCompany.SDGE.repository.IProfessorRepository;
import br.com.rondonCompany.SDGE.repository.ITurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    @Autowired
    public ITurmaRepository repositoryTurma;

    @Autowired
    public TurmaService(ITurmaRepository repositoryTurma) {
        this.repositoryTurma = repositoryTurma;
    }


    public List<Turma> obterTurmas(){
        //implementar metodo
        return null;
    }


    public void converteDadosDTO(){
        //implementar
    }

    public Optional<Turma> findById(Long id) {
        return repositoryTurma.findById(id);
    }
    public void save(Turma turma){
        repositoryTurma.save(turma);
    }
}
