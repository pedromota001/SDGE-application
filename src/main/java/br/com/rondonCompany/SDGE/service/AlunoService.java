package br.com.rondonCompany.SDGE.service;


import br.com.rondonCompany.SDGE.repository.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    private IAlunoRepository alunoRepository;
}
