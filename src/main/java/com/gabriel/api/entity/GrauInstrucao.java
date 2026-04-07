package com.gabriel.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "graus_instrucao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrauInstrucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String descricao;
}