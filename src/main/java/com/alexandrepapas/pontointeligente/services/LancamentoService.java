package com.alexandrepapas.pontointeligente.services;

import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import com.alexandrepapas.pontointeligente.Entities.Lancamento;
import com.alexandrepapas.pontointeligente.repositories.FuncionarioRepository;
import com.alexandrepapas.pontointeligente.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LancamentoService {
    @Autowired
    LancamentoRepository lancamentoRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    private Funcionario funcionario;
    private Lancamento lancamento;

    public Lancamento cadastrarLancamento(Lancamento lancamento) {
        if (lancamento.getData() == null || lancamento.getDataCriacao() == null ||
                lancamento.getDataAtualizacao() == null || lancamento.getDescricao() == null
                || lancamento.getLocalizacao() == null || lancamento.getTipo() == null || lancamento.getFuncionario() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }

        Funcionario funcionario= buscarFuncarioPorId(lancamento.getFuncionario().getId());
        funcionario.getNome();
        lancamento.setFuncionario(funcionario);
        return lancamentoRepository.save(lancamento);
    }
    private Funcionario buscarFuncarioPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));
        return funcionario;
    }
    public List<Lancamento> buscarLancamentos(){
        List<Lancamento> lancamentos = lancamentoRepository.findAll();
        lancamentos.forEach(lancamento -> {
            Funcionario funcionario = lancamento.getFuncionario();

          String nomeFuncionario= funcionario.getNome();
          //System.out.println("nome do funciario"+nomeFuncionario);
        });
        return lancamentos;
    }

    public Lancamento buscarLancamentoPorId(Long id) {
        Lancamento lancamento = lancamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lancamento não encontrado"));
        return lancamento;
    }

}
