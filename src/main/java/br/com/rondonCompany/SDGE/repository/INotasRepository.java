package br.com.rondonCompany.SDGE.repository;

import br.com.rondonCompany.SDGE.entity.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INotasRepository extends JpaRepository<Notas, Long> {
    List<Notas> findByAlunoId(Long id);

}
