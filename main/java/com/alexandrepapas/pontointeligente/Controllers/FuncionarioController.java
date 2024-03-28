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
@RequestMapping("/api/funcionarios")
public class FuncionarioController {


    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrarFuncionario")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.cadastrarFuncionario(funcionario, PerfilEnum.ROLE_USUARIO);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrarFuncionarioAdmin")
    public ResponseEntity<Funcionario> cadastrarFuncionarioAdmin(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.cadastrarFuncionarioAdmin(funcionario, PerfilEnum.ROLE_ADMIN);
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
