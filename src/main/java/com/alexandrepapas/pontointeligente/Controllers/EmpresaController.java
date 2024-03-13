package com.alexandrepapas.pontointeligente.Controllers;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
     EmpresaService empresaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Empresa> criarEmpresa(@RequestBody Empresa empresa){
        try {
            Empresa empresaCriada = empresaService.criarEmpresa(empresa);
            return new ResponseEntity<>(empresaCriada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
