package br.com.rondonCompany.SDGE.service.aluno;

import br.com.rondonCompany.SDGE.entity.Aluno;

import java.util.Optional;

public interface IAlunoService {

    //salvar um aluno no db
    Aluno save(Aluno theAluno);

    //encontrar aluno pelo email
    Optional<Aluno> findByEmail(String email);
}
