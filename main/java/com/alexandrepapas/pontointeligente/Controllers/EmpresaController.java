package com.alexandrepapas.pontointeligente.Controllers;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import com.alexandrepapas.pontointeligente.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @GetMapping("/buscarTodasEmpresas")
    public ResponseEntity<List<Empresa>> buscarTodosEmpresas() {
        List<Empresa> empresas = empresaService.buscarEmpresas();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        try {
            Empresa empresaEditada = empresaService.editarEmpresa(empresa, id);
            return new ResponseEntity<>(empresaEditada, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Ocorreu um erro ao editar a empresa: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEmpresa(@PathVariable Long id) {
        try {
            empresaService.deletarEmpresa(id);
            return new ResponseEntity<>("Empresa deletada com sucesso", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Ocorreu um erro ao deletar a empresa: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
