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
    public ResponseEntity<?> criarEmpresa(@RequestBody Empresa empresa){
        try {
            Empresa empresaCriada = empresaService.criarEmpresaDto(empresa);
            return new ResponseEntity<>(empresaCriada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao criar a empresa: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
