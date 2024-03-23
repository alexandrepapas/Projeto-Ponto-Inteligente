package com.alexandrepapas.pontointeligente.repositories;

import com.alexandrepapas.pontointeligente.Entities.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
}
