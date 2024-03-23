package com.alexandrepapas.pontointeligente.services;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import com.alexandrepapas.pontointeligente.enuns.PerfilEnum;
import com.alexandrepapas.pontointeligente.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    EmpresaService empresaRepository;

    public Funcionario criarFuncionario(Funcionario funcionario, PerfilEnum perfil) {

        if (funcionario.getNome() == null || funcionario.getEmail() == null || funcionario.getSenha() == null ||
                funcionario.getCpf() == null || funcionario.getPerfil() == null || funcionario.getDataCriacao() == null ||
                funcionario.getDataAtualizacao() == null || funcionario.getEmpresa() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }

        if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
            throw new IllegalArgumentException("Funcionário já cadastrado, verifique o CPF");
        }

        if (!empresaRepository.existsById(funcionario.getEmpresa().getId())) {
            throw new IllegalArgumentException("Empresa não cadastrada");
        }
        Empresa empresa = empresaRepository.buscarEmpresaId(funcionario.getEmpresa().getId());

        funcionario.setEmpresa(empresa);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf)
                        .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));
        Empresa empresa = funcionario.getEmpresa();
        return funcionario;
    }

    public List<Funcionario> buscarTodosFuncionarios() {
      List<Funcionario> funcionarios = funcionarioRepository.findAll();
      return funcionarios;
    }
}
