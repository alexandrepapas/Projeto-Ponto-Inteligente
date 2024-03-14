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


    public Empresa criarEmpresa(Empresa empresa) throws Exception {
        if(empresaRepository.findByCnpj(empresa.getCnpj()).isPresent()){
            throw new ExceptionEmpresa(HttpStatus.INTERNAL_SERVER_ERROR,"Cnpj já cadastrado");
        }
        return empresaRepository.save(empresa);
    }




}
