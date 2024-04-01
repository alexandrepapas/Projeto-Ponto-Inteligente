package com.alexandrepapas.pontointeligente.Entities;

import org.springframework.web.multipart.MultipartFile;

public class FotoFuncionario {

    private MultipartFile arquivo;
    private String descricao;

    public MultipartFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(MultipartFile arquivo) {
        this.arquivo = arquivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
