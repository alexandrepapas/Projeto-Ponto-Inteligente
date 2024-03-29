package com.alexandrepapas.pontointeligente.services;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.Exceptions.ExceptionEmpresa;
import com.alexandrepapas.pontointeligente.repositories.EmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa criarEmpresaDto(Empresa criarEmpresa) throws Exception {
        validarEmpresa(criarEmpresa);
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(criarEmpresa.getRazaoSocial());
        empresa.setCnpj(criarEmpresa.getCnpj());
        return empresaRepository.save(empresa);
    }

    private void validarEmpresa(Empresa empresa) throws Exception {
        if(empresaRepository.findByCnpj(empresa.getCnpj()).isPresent()){
            throw new ExceptionEmpresa(HttpStatus.INTERNAL_SERVER_ERROR,"Cnpj já cadastrado");
        }
        if(empresa.getCnpj() == null || empresa.getCnpj().isEmpty()){
            throw new ExceptionEmpresa(HttpStatus.BAD_REQUEST,"Cnpj não pode ser vazio");
        }
        if(empresa.getRazaoSocial() == null || empresa.getRazaoSocial().isEmpty()){
            throw new ExceptionEmpresa(HttpStatus.BAD_REQUEST,"Razão social não pode ser vazio");
        }
    }

    public List<Empresa> buscarEmpresas() {
        return empresaRepository.findAll();
    }

    public boolean existsById(Long id) {
        return empresaRepository.existsById(id);
    }

    public Empresa editarEmpresa(Empresa editarEmpresa,Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
        empresa.setCnpj(editarEmpresa.getCnpj());
        empresa.setRazaoSocial(editarEmpresa.getRazaoSocial());
        return empresaRepository.save(empresa);
    }

    public void deletarEmpresa(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
        empresaRepository.deleteById(id);
    }
}