package com.gabriel.api.repository;

import com.gabriel.api.entity.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> { // ajuste pro code review
}