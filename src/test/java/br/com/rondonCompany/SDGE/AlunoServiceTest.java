package br.com.rondonCompany.SDGE;

import br.com.rondonCompany.SDGE.entity.Aluno;
import br.com.rondonCompany.SDGE.repository.IAlunoRepository;
import br.com.rondonCompany.SDGE.service.aluno.AlunoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @Mock
    private IAlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;


    @Test
    void testFindByEmailWithMocks() {
        String email = "teste@email.com";
        Aluno mockAluno = new Aluno();
        mockAluno.setId(1L);
        mockAluno.setNome("João");
        mockAluno.setEmail(email);

        Mockito.when(alunoRepository.findByEmail(email)).thenReturn(Optional.of(mockAluno));

        Optional<Aluno> result = alunoService.findByEmail(email);

        assertTrue(result.isPresent());
        assertEquals("João", result.get().getNome());
    }
}
