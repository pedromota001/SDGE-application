package br.com.rondonCompany.SDGE.service.aluno;


import br.com.rondonCompany.SDGE.entity.Aluno;
import br.com.rondonCompany.SDGE.repository.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {
    private IAlunoRepository alunoRepository;

    @Autowired
    public AlunoService(IAlunoRepository theAlunoRepository){
        alunoRepository = theAlunoRepository;
    }

    public void save(Aluno theAluno) {
        alunoRepository.save(theAluno);
    }

    public Optional<Aluno> findByEmail(String email) {
        return alunoRepository.findByEmail(email);
    }
}
