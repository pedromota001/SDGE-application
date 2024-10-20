package br.com.rondonCompany.SDGE.service.aluno;


import br.com.rondonCompany.SDGE.entity.Aluno;
import br.com.rondonCompany.SDGE.repository.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private IAlunoRepository alunoRepository;

    @Autowired
    public AlunoService(IAlunoRepository theAlunoRepository){
        alunoRepository = theAlunoRepository;
    }

    public Aluno save(Aluno theAluno) {
        return alunoRepository.save(theAluno);
    }
}
