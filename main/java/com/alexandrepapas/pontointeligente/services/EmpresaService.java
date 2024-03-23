package com.alexandrepapas.pontointeligente.services;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.Exceptions.ExceptionEmpresa;
import com.alexandrepapas.pontointeligente.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa criarEmpresaDto(Empresa criarEmpresa) throws Exception {
        if(empresaRepository.findByCnpj(criarEmpresa.getCnpj()).isPresent()){
            throw new ExceptionEmpresa(HttpStatus.INTERNAL_SERVER_ERROR,"Cnpj já cadastrado");
        }
        if(criarEmpresa.getCnpj() == null || criarEmpresa.getCnpj().isEmpty()){
            throw new ExceptionEmpresa(HttpStatus.BAD_REQUEST,"Cnpj não pode ser vazio");
        }
        if(criarEmpresa.getRazaoSocial() == null || criarEmpresa.getRazaoSocial().isEmpty()){
            throw new ExceptionEmpresa(HttpStatus.BAD_REQUEST,"Razão social não pode ser vazio");
        }
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(criarEmpresa.getRazaoSocial());
        empresa.setCnpj(criarEmpresa.getCnpj());
        return empresaRepository.save(empresa);
    }

    public Empresa buscarEmpresaId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
    }

    public boolean existsById(Long id) {
        return empresaRepository.existsById(id);
    }
}
