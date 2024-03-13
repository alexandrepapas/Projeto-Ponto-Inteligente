package com.alexandrepapas.pontointeligente.repositories;

import com.alexandrepapas.pontointeligente.Entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
