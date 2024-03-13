package com.alexandrepapas.pontointeligente.repositories;

import com.alexandrepapas.pontointeligente.Entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
}
