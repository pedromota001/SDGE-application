package br.com.rondonCompany.SDGE.repository;

import br.com.rondonCompany.SDGE.dto.AlunoDTO;
import br.com.rondonCompany.SDGE.dto.ProfessorDTO;
import br.com.rondonCompany.SDGE.entity.Professor;
import br.com.rondonCompany.SDGE.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProfessorRepository extends JpaRepository<Professor, Long> {
     Optional<Professor> findByEmail(String email);

     @Query("SELECT t, p, a FROM Professor p JOIN p.listaTurmas t JOIN t.listaAlunos a WHERE t.id = :id")
     Optional<Turma> buscaTurmaId(Long id);

     @Query("SELECT new br.com.rondonCompany.SDGE.dto.AlunoDTO(a.nome, a.email) FROM Professor p JOIN p.listaTurmas t JOIN t.listaAlunos a")
     List<AlunoDTO> buscaAlunos();


     //List<ProfessorDTO> buscaProfessoresDisponiveis();

}
