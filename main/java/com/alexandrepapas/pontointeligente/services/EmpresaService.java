package com.alexandrepapas.pontointeligente.services;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.Exceptions.ExceptionEmpresa;
import com.alexandrepapas.pontointeligente.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public List<Empresa> buscarEmpresas() {
        return empresaRepository.findAll();
    }


    public boolean existsById(Long id) {
        return empresaRepository.existsById(id);
    }


}
