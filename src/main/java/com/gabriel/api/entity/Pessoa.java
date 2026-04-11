package com.gabriel.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "pessoas",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_pessoa_cpf", columnNames = "cpf")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa { // ajuste pro code review

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false, length = 20)
    private String rg;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estado_civil_id", nullable = false)
    private EstadoCivil estadoCivil;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grau_instrucao_id", nullable = false)
    private GrauInstrucao grauInstrucao;
}