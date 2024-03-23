package com.alexandrepapas.pontointeligente.Exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionEmpresa extends ResponseStatusException {
    public ExceptionEmpresa(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
