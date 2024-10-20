package br.com.rondonCompany.SDGE.service.aluno;

import br.com.rondonCompany.SDGE.entity.Aluno;

public interface IAlunoService {

    //salvar um aluno no db
    Aluno save(Aluno theAluno);
}
