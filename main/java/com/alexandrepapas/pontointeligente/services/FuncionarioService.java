package com.alexandrepapas.pontointeligente.services;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import com.alexandrepapas.pontointeligente.enuns.PerfilEnum;
import com.alexandrepapas.pontointeligente.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    EmpresaService empresaRepository;

    public Funcionario criarFuncionario (Funcionario funcionario, PerfilEnum perfil){
        System.out.println(funcionario);
        if (funcionario.getNome() == null || funcionario.getEmail() == null || funcionario.getSenha() == null ||
                funcionario.getCpf() == null || funcionario.getPerfil() == null || funcionario.getDataCriacao() == null ||
                funcionario.getDataAtualizacao() == null || funcionario.getEmpresa() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
        if (!empresaRepository.existsById(funcionario.getEmpresa().getId())) {
            throw new IllegalArgumentException("Empresa não cadastrada");
        }
        Empresa empresa = empresaRepository.buscarEmpresaId(funcionario.getEmpresa().getId());

        funcionario.setEmpresa(empresa);
        return funcionarioRepository.save(funcionario);
    }

}
