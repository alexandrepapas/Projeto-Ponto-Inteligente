package com.alexandrepapas.pontointeligente.services;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    public Empresa criarEmpresa(Empresa empresa) throws Exception {
        if(empresaRepository.findByCnpj(empresa.getCnpj()).isPresent()){
            throw new Exception("Empresa já cadastrada");
        }
        return empresaRepository.save(empresa);
    }




}
