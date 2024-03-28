package com.alexandrepapas.pontointeligente.Controllers;

import com.alexandrepapas.pontointeligente.Entities.Lancamento;
import com.alexandrepapas.pontointeligente.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

    @Autowired
    LancamentoService lancamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Lancamento> cadastrarLancamento (@RequestBody Lancamento lancamento){
        try {
            Lancamento lancamentoCadastrado = lancamentoService.cadastrarLancamento(lancamento);
            return new ResponseEntity<>(lancamentoCadastrado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarLancamentos")
    public ResponseEntity<?> buscarLancamentos(){
        try {
            return new ResponseEntity<>(lancamentoService.buscarLancamentos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarLancamentoPorId/{id}")
    public ResponseEntity<?> buscarLancamentoPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(lancamentoService.buscarLancamentoPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
