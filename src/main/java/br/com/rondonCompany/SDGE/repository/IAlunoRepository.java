package br.com.rondonCompany.SDGE.repository;

import br.com.rondonCompany.SDGE.dto.AlunoDTO;
import br.com.rondonCompany.SDGE.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmail(String email);

    List<Aluno> findByTurma_Id(Long id);

}
