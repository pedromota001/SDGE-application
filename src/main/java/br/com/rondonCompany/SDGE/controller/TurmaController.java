package br.com.rondonCompany.SDGE.controller;

import br.com.rondonCompany.SDGE.dto.TurmaDTO;
import br.com.rondonCompany.SDGE.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TurmaController {

    @Autowired
    private TurmaService turmaService;
    @GetMapping("/turma")
    public TurmaDTO obterTurmas(){
        //implementar retorno para /get em /turma

        return null;
    }

}
