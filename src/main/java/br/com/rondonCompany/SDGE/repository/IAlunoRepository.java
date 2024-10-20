package br.com.rondonCompany.SDGE.repository;

import br.com.rondonCompany.SDGE.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmail(String email);
}
