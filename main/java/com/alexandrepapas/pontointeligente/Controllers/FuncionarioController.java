package com.alexandrepapas.pontointeligente.Controllers;

import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import com.alexandrepapas.pontointeligente.enuns.PerfilEnum;
import com.alexandrepapas.pontointeligente.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/buscarQtdFuncionarios")
    public ResponseEntity<List<Funcionario>> buscarTodosFuncionarios(Pageable pageable) {
        Page<Funcionario> funcionariosPage = funcionarioService.buscarFuncionariosPaginas(pageable);
        List<Funcionario> funcionarios = funcionariosPage.getContent();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @PutMapping("/editarFuncionario/{cpf}")
    public ResponseEntity<Funcionario> editarFuncionario(@PathVariable String cpf, @RequestBody Funcionario dadosFuncionario) {
        Funcionario funcionarioAtualizado = funcionarioService.editarFuncionario(cpf, dadosFuncionario.getNome(), dadosFuncionario.getEmail(), dadosFuncionario.getSenha());
        return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletarFuncionario/{cpf}")
    public ResponseEntity<String> deletarFuncionario(@PathVariable String cpf) {
        funcionarioService.deletarFuncionario(cpf);
        return new ResponseEntity<>("Funcionario Excluido", HttpStatus.OK);
    }





}
