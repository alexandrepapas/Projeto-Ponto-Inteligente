package com.alexandrepapas.pontointeligente.Controllers;

import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import com.alexandrepapas.pontointeligente.enuns.PerfilEnum;
import com.alexandrepapas.pontointeligente.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunciarioController {



    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/criarFuncionario")
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario, PerfilEnum perfilEnum ) {
        Funcionario novoFuncionario = funcionarioService.criarFuncionario(funcionario, PerfilEnum.ROLE_USUARIO);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }


}
