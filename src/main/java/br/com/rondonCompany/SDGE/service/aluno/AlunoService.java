package br.com.rondonCompany.SDGE.service.aluno;


import br.com.rondonCompany.SDGE.dto.AlunoDTO;
import br.com.rondonCompany.SDGE.entity.Aluno;
import br.com.rondonCompany.SDGE.repository.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    private IAlunoRepository alunoRepository;

    @Autowired
    public AlunoService(IAlunoRepository theAlunoRepository){
        alunoRepository = theAlunoRepository;
    }

    public void save(Aluno theAluno) {
        alunoRepository.save(theAluno);
    }

    public Optional<Aluno> findByEmail(String email) {
        return alunoRepository.findByEmail(email);
    }

    public List<AlunoDTO> findAll(){
        List<Aluno> listaAlunos = alunoRepository.findAll();
        return converteDados(listaAlunos);
    }

    public String verificaAlunoNoBanco(Optional<Aluno> aluno, Aluno theAluno, Model theModel){
        if(aluno.isPresent() && aluno.get().getSenha().equals(theAluno.getSenha())){
            return "alunos/aluno-main-page";
        } else {
            theModel.addAttribute("error", "Email ou senha invalidos. Tente Novamente");
            return "alunos/aluno-login-form";
        }
    }

    public List<AlunoDTO> converteDados(List<Aluno> listaAlunos){
        return listaAlunos.stream()
                .map(a -> new AlunoDTO(a.getNome(), a.getEmail()))
                .collect(Collectors.toList());
    }
}
