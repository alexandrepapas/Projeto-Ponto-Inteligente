package com.alexandrepapas.pontointeligente.Controllers;

import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import com.alexandrepapas.pontointeligente.enuns.PerfilEnum;
import com.alexandrepapas.pontointeligente.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FunciarioController {


    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/criarFuncionario")
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.criarFuncionario(funcionario, PerfilEnum.ROLE_USUARIO);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @GetMapping("/buscarFuncionarioPorCpf")
    public  ResponseEntity <Funcionario>buscaFuncionarioPorCpf(@RequestParam String cpf) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @GetMapping("/buscarTodosFuncionarios")
    public ResponseEntity<List<Funcionario>> buscarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.buscarTodosFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }


}
