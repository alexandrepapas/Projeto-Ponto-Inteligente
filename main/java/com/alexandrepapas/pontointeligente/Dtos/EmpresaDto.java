package com.alexandrepapas.pontointeligente.Dtos;

public class EmpresaDto {

    private String razaoSocial;
    private String cnpj;

    public EmpresaDto() {
    }

    public EmpresaDto(Long id, String razaoSocial, String cnpj) {

        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

}
