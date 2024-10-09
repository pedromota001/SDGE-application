package br.com.rondonCompany.SDGE.service;


import br.com.rondonCompany.SDGE.models.Turma;
import br.com.rondonCompany.SDGE.repository.ITurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    @Autowired
    public ITurmaRepository repositoryTurma;

    public List<Turma> obterTurmas(){
        //implementar metodo
        return null;
    }


    public void converteDadosDTO(){
        //implementar
    }
}
