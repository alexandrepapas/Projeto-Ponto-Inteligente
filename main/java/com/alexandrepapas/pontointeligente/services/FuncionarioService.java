package com.alexandrepapas.pontointeligente.services;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import com.alexandrepapas.pontointeligente.enuns.PerfilEnum;
import com.alexandrepapas.pontointeligente.repositories.EmpresaRepository;
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
    EmpresaRepository empresaRepository;

    @Autowired
    EmpresaService empresaService;

    public Funcionario cadastrarFuncionario(Funcionario funcionario, PerfilEnum perfil) {

        if (funcionario.getPerfil() == null) {
            funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
        }

        if (funcionario.getNome() == null || funcionario.getEmail() == null || funcionario.getSenha() == null ||
                funcionario.getCpf() == null || funcionario.getEmpresa() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }

        if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
            throw new IllegalArgumentException("Funcionário já cadastrado, verifique o CPF");
        }

        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email ja cadastrado , verifique o email ");
        }

        if (!empresaRepository.existsById(funcionario.getEmpresa().getId())) {
            throw new IllegalArgumentException("Empresa não cadastrada");
        }
        Empresa empresa = buscarEmpresaId(funcionario.getEmpresa().getId());
        funcionario.setEmpresa(empresa);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario cadastrarFuncionarioAdmin(Funcionario funcionario, PerfilEnum perfil) {

        if (funcionario.getPerfil() == null) {
            funcionario.setPerfil(PerfilEnum.ROLE_ADMIN);
        }

        if (funcionario.getNome() == null || funcionario.getEmail() == null || funcionario.getSenha() == null ||
                funcionario.getCpf() == null || funcionario.getEmpresa() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }

        if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
            throw new IllegalArgumentException("Funcionário Admin  cadastrado, verifique o CPF");
        }

        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email ja cadastrado , verifique o email ");
        }

        if (!empresaRepository.existsById(funcionario.getEmpresa().getId())) {
            throw new IllegalArgumentException("Empresa não cadastrada");
        }
        Empresa empresa = buscarEmpresaId(funcionario.getEmpresa().getId());
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

    public Empresa buscarEmpresaId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public void deletarFuncionario(String cpf) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));
        funcionarioRepository.deleteByCpf(cpf);
    }

    public Funcionario editarFuncionario(String cpf, String novoNome, String novoEmail, String novaSenha) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));

        funcionario.setNome(novoNome);
        funcionario.setEmail(novoEmail);
        funcionario.setSenha(novaSenha);

        return funcionarioRepository.save(funcionario);
    }



}
