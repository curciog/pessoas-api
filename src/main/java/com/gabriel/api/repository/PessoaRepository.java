package com.gabriel.api.repository;

import com.gabriel.api.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> { // ajuste pro code review
    boolean existsByCpf(String cpf);
}