package br.com.rondonCompany.SDGE.repository;

import br.com.rondonCompany.SDGE.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunoRepository extends JpaRepository<Aluno, Long> {
}
